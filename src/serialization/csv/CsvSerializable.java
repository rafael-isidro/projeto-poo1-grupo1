package serialization.csv;

import serialization.CustomSerializable;

public interface CsvSerializable<E> extends CustomSerializable<E, String> {

    public final static String DELIMITER = ";";
    public final static String LIST_DELIMITER = "\\|";


}
