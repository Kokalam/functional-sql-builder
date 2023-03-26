package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import com.kokalam.sql.query.instructions.where.clauses.operation.operators.Operator;

public class Smaller <T extends Number> implements Operator {

    private final T value;

    Smaller(T value) {
        this.value = value;
    }

    @Override
    public String generate() {
        return null;
    }
}
