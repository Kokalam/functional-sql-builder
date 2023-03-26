package com.kokalam.sql.query.instructions.where.clauses.operation;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.where.clauses.operation.column.Column;

import java.util.function.Consumer;

public class Operation implements Instruction {

    @Override
    public String generate() {
        return null;
    }

    public static class Builder {

        public Operation.Builder column(Consumer<Column.Builder> columnBuilder) {
            return this;
        }

        public <T extends Number> Operation.Builder equal(T value) {
            return this;
        }

        public <T extends Number> Operation.Builder greater(T value) {
            return this;
        }

        public <T extends Number> Operation.Builder greaterOrEqual(T value) {
            return this;
        }

        public <T extends Number> Operation.Builder smaller(T value) {
            return this;
        }

        public <T extends Number> Operation.Builder smallerOrEqual(T value) {
            return this;
        }

        public <T extends Number, U extends Number> Operation.Builder between(T value1, U value2) {
            return this;
        }

        public Operation build() {
            return new Operation();
        }
    }
}
