package serialization.csv;

import entities.Filme;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FilmeCsvSerializable implements CsvSerializable<Filme> {

    private static final DateTimeFormatter LOCAL_DATE_FORMATER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final String delimiter;
    private final String listDelimiter;
    private final AtorCsvSerializable atorCsvSerializable;
    private final DiretorCsvSerializable diretorCsvSerializable;

    public FilmeCsvSerializable(String delimiter, String delimiter2, String listDelimiter, String listDelimiter2) {
        this.delimiter = delimiter;
        this.listDelimiter = listDelimiter;
        this.atorCsvSerializable = new AtorCsvSerializable(delimiter2);
        this.diretorCsvSerializable = new DiretorCsvSerializable(delimiter2, listDelimiter2);
    }

    @Override
    public String serialize(Filme entity) {
        StringBuilder sb = new StringBuilder();

        sb.append(entity.getNome()).append(delimiter);
        sb.append(entity.getDataLancamentoString()).append(delimiter);
        sb.append(entity.getOrcamento()).append(delimiter);

        sb.append(entity.getDescricao()).append(delimiter);
        sb.append(entity.getDuracao().get(ChronoUnit.MINUTES)).append(delimiter);

        sb.append(
                entity.getListaDiretores().stream()
                        .map(diretorCsvSerializable::serialize)
                        .collect(Collectors.joining(listDelimiter))
        ).append(delimiter);
        sb.append(
                entity.getListaAtores().stream()
                        .map(atorCsvSerializable::serialize)
                        .collect(Collectors.joining(listDelimiter))
        ).append(delimiter);
        sb.append(String.join(listDelimiter, entity.getListaGeneros()));

        return sb.toString();
    }

    @Override
    public Filme deserialize(String serializedEntity) {
        String[] fields = serializedEntity.split(delimiter);
        Filme filme = new Filme();

        filme.setNome(fields[0]);
        filme.setDataLancamento(fields[1]);
        filme.setOrcamento(Double.parseDouble(fields[2]));

        filme.setDescricao(fields[3]);
        filme.setDuracao(Duration.ofMinutes(Integer.parseInt(fields[4])));

        Arrays.stream(fields[5].split(listDelimiter))
                .map(diretorCsvSerializable::deserialize)
                .forEach(filme::adicionarDiretor);
        Arrays.stream(fields[6].split(listDelimiter))
                .map(atorCsvSerializable::deserialize)
                .forEach(filme::adicionarAtor);
        Arrays.stream(fields[7].split(listDelimiter))
                .forEach(filme::adicionarGenero);

        return null;
    }
}
