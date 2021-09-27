package net.shawshark.core.api.database;

public enum SqlInputType {
    INSERT_INTO("INSERT INTO"), REPLACE_INTO("REPLACE INTO");

    private String type;
    SqlInputType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}