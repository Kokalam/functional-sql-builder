package com.kokalam.sql.query.instructions.from.clauses.table;

import com.kokalam.sql.query.instructions.from.clauses.Clause;

import java.util.Optional;

public class Table implements Clause {

    private String name;

    private String alias;

    private Table(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }

    @Override
    public String generate() {
        return name
                + Optional.ofNullable(alias).map(a ->" " + a).orElse("");
    }

    public static class Builder {

        private String name;

        private String alias;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder as(String alias) {
            this.alias = alias;
            return this;
        }

        public Table build() {
            if (name == null || name.isBlank()) {
                throw new IllegalArgumentException("Table has no name defined");
            }
            return new Table(name, alias);
        }
    }
}
