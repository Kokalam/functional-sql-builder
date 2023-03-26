package com.kokalam.sql.query.instructions.where.clauses.operation.column;

import com.kokalam.sql.query.instructions.Instruction;

import java.util.Optional;

public class Column implements Instruction {

    private final String reference;

    private final String table;

    private Column(final String reference, final String table) {
        this.reference = reference;
        this.table = table;
    }

    @Override
    public String generate() {
        return Optional.ofNullable(table).map(t -> t + ".").orElse("")
                + reference;
    }

    public static class Builder {

        private String table;

        private String reference;

        public Column.Builder name(final String reference) {
            this.reference = reference;
            return this;
        }

        public Column.Builder of(final String table) {
            this.table = table;
            return this;
        }

        public Column build() {
            if (this.reference == null || this.reference.isBlank()) {
                throw new IllegalArgumentException("Column has no reference defined");
            }
            return new Column(reference, table);
        }

    }


}
