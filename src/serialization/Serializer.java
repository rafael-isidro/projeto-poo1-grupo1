package serialization;

public interface Serializer<E, S> {

    S serialize(E entity);

    E deserialize(S serializedEntity);

}
