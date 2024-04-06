package serialization.csv;

import entities.Diretor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class DiretorCsvSerializable implements CsvSerializable<Diretor> {
    //        TODO: implementar pós adequações da entidade
    
    @Override
    public String serialize(Diretor entity) {
        StringBuilder sb = new StringBuilder();
        sb.append(entity.getNome()).append(DELIMITER);
        sb.append(String.join(LIST_DELIMITER, entity.getListaAreas()));
        return sb.toString();
    }

    @Override
    public Diretor deserialize(String serializedEntity) {
        String[] fields = serializedEntity.split(DELIMITER);
        String nome = fields[0];ArrayList<String> areas = Arrays
                .stream(fields[1].split(LIST_DELIMITER))
                .collect(Collectors.toCollection(ArrayList::new));
        return new Diretor(nome, areas);
    }
}

