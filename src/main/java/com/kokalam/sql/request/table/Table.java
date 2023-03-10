package com.kokalam.sql.request.table;

public class Table {

    public static Table table(String name) {
        return new Table();
    }

    public Table as(String alias) {
        return this;
    }
}
