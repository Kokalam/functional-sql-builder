package com.kokalam.sql.query.instructions.select.column;

import com.kokalam.sql.query.instructions.Instruction;

import java.util.Optional;

public class Column implements Instruction {

    private final String name;

    private final String alias;

    private final String table;

    private Column(final String name, final String table, final String alias) {
        this.name = name;
        this.alias = alias;
        this.table = table;
    }

    @Override
    public String generate() {
        return Optional.ofNullable(table).map(t -> t + ".").orElse("")
                + name
                + Optional.ofNullable(alias).map(a -> " as " + alias).orElse("");
    }

    public static class Builder {

        private String table;

        private String name;

        private String alias;

        public Builder name(final String name) {
            this.name = name;
            return this;
        }

        public Builder of(final String table) {
            this.table = table;
            return this;
        }

        public Builder as(final String alias) {
            this.alias = alias;
            return this;
        }

        public Column build() {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Column has no name defined");
            }
            return new Column(name, table, alias);
        }

    }


}
