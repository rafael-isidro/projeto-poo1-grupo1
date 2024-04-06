package serialization;

public interface CustomSerializable <E, S> {

    S serialize(E entity);

    E deserialize(S serializedEntity);

}
