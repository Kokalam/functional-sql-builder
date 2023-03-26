package com.kokalam.sql.query.instructions.where.clauses.connector;

import com.kokalam.sql.query.instructions.where.clauses.operation.Operation;

import java.util.function.Consumer;

public class Or implements Connector {



    @Override
    public String generate() {
        return null;
    }

    public static class Builder {

        private Operation operation;

        public Or.Builder must(Consumer<Operation.Builder> consumer) {
            return this;
        }

        public Or build() {
            return new Or();
        }
    }
}
