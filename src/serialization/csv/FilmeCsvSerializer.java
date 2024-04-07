package serialization.csv;

import entities.Filme;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.Collectors;

public class FilmeCsvSerializer implements CsvSerializer<Filme> {

    private final String delimiter;
    private final String listDelimiter;
    private final AtorCsvSerializer atorCsvSerializer;
    private final DiretorCsvSerializer diretorCsvSerializer;

    public FilmeCsvSerializer(String delimiter, String delimiter2, String listDelimiter, String listDelimiter2) {
        this.delimiter = delimiter;
        this.listDelimiter = listDelimiter;
        this.atorCsvSerializer = new AtorCsvSerializer(delimiter2);
        this.diretorCsvSerializer = new DiretorCsvSerializer(delimiter2, listDelimiter2);
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
                        .map(diretorCsvSerializer::serialize)
                        .collect(Collectors.joining(listDelimiter))
        ).append(delimiter);
        sb.append(
                entity.getListaAtores().stream()
                        .map(atorCsvSerializer::serialize)
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
                .map(diretorCsvSerializer::deserialize)
                .forEach(filme::adicionarDiretor);
        Arrays.stream(fields[6].split(listDelimiter))
                .map(atorCsvSerializer::deserialize)
                .forEach(filme::adicionarAtor);
        Arrays.stream(fields[7].split(listDelimiter))
                .forEach(filme::adicionarGenero);

        return null;
    }
}
