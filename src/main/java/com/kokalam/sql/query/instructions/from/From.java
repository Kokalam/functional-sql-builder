package com.kokalam.sql.query.instructions.from;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.from.clauses.Clause;
import com.kokalam.sql.query.instructions.from.clauses.table.Table;
import com.kokalam.sql.query.instructions.select.column.Column;

import java.util.List;
import java.util.function.Consumer;

public class From implements Instruction {

    private List<Clause> clauses;

    @Override
    public String generate() {
        return null;
    }

    public static class Builder {

        private List<Clause> clauses;

        public Builder table(Consumer<Table.Builder> builder) {
            return this;
        }
    }
}
