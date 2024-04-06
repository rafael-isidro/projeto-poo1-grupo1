package serialization.csv;

import entities.Ator;

import static serialization.csv.CsvSerializable.DELIMITER;

public class AtorCsvSerializable implements CsvSerializable<Ator> {
    //        TODO: implementar pós adequações da entidade

    @Override
    public String serialize(Ator entity) {
        return String.join(DELIMITER, entity.getNome(), entity.getCpf());
    }

    @Override
    public Ator deserialize(String serializedEntity) {
        String[] fields = serializedEntity.split(DELIMITER);
        String nome = fields[0];
        String cpf = fields[1];
        return new Ator(nome, cpf);
    }
}
