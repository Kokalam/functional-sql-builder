package com.kokalam.sql.request.column;

public class Column {

    private final String name;

    private String alias;

    private Column(final String name) {
        this.name = name;
    }

    public static Column column(final String name) {
        return new Column(name);
    }

    public static Column column(final String table, final String name) {
        return new Column(table + "." + name);
    }

    public Column as(final String alias) {
        this.alias = alias;
        return this;
    }

    @Override
    public String toString() {
        return name + " as " + alias;
    }
}
