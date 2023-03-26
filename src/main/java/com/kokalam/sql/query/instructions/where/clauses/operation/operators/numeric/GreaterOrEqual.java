package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import com.kokalam.sql.query.instructions.where.clauses.operation.operators.Operator;

public class GreaterOrEqual <T extends Number> implements Operator {

    private final T value;

    GreaterOrEqual(T value) {
        this.value = value;
    }

    @Override
    public String generate() {
        return null;
    }
}
