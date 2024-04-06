package serialization.csv;

import entities.Filme;

public class FilmeCsvSerializable implements CsvSerializable<Filme> {
    //        TODO: implementar pós adequações da entidade

    @Override
    public String serialize(Filme entity) {
        StringBuilder sb = new StringBuilder();
        return sb.toString();
    }

    @Override
    public Filme deserialize(String serializedEntity) {
        return null;
    }
}
