package com.kokalam.sql.query.instructions.where.clauses;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.where.clauses.connector.Connector;
import com.kokalam.sql.query.instructions.where.clauses.operation.Operation;

import java.util.function.Consumer;

public class Clause implements Instruction {

    Connector connector;

    Operation operation;

    @Override
    public String generate() {
        return null;
    }

    public static class Builder {

        Builder(Connector connector) {

        }

        Builder() {

        }

        public Clause.Builder must(Consumer<Operation.Builder> consumer) {
            return this;
        }

        public Clause build() {
            return new Clause();
        }
    }

}
