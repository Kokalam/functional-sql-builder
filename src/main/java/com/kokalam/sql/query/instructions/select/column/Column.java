package com.kokalam.sql.query.instructions.select.column;

import com.kokalam.sql.query.instructions.Instruction;

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
        return null;
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
            return new Column(name, table, alias);
        }

    }


}
