package com.kokalam.sql.query.instructions.from;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.from.clauses.Clause;
import com.kokalam.sql.query.instructions.from.clauses.table.Table;
import com.kokalam.sql.query.instructions.select.column.Column;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class From implements Instruction {

    private List<Clause> clauses;

    public From(List<Clause> clauses) {
        this.clauses = clauses;
    }

    @Override
    public String generate() {
        return " FROM "
            + clauses.stream()
                .map(Clause::generate)
                .collect(Collectors.joining(","));
    }

    public static class Builder {

        private List<Clause> clauses;

        public Builder() {
            this.clauses = new ArrayList<>();
        }

        public Builder table(Consumer<Table.Builder> consumer) {
            Table.Builder builder = new Table.Builder();
            consumer.accept(builder);
            clauses.add(builder.build());
            return this;
        }

        public From build() {
            if (clauses.isEmpty()) {
                throw new IllegalArgumentException("List of table from select is empty");
            }
            return new From(clauses);
        }
    }
}
