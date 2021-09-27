package net.shawshark.core.api.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DataTable {
    String name;
    Object data;

    public DataType dataType;

    public enum DataType {
        STRING,
        INTEGER,
        DOUBLE,
        FLOAT,
        LONG,
        LONGTEXT;
    }
}
