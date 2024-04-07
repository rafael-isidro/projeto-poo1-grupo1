package serialization.csv;

import entities.Diretor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DiretorCsvSerializable implements CsvSerializable<Diretor> {

    private final String delimiter;
    private final String listDelimiter;

    public DiretorCsvSerializable(String delimiter, String listDelimiter) {
        this.delimiter = delimiter;
        this.listDelimiter = listDelimiter;
    }

    @Override
    public String serialize(Diretor entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getNome()).append(delimiter);
        sb.append(String.join(listDelimiter, entity.getListaAreas()));
        return sb.toString();
    }

    @Override
    public Diretor deserialize(String serializedEntity) {
        String[] fields = serializedEntity.split(delimiter);
        String nome = fields[0];
        ArrayList<String> areas = Arrays
                .stream(fields[1].split(listDelimiter))
                .collect(Collectors.toCollection(ArrayList::new));
        return new Diretor(nome, areas);
    }
}

