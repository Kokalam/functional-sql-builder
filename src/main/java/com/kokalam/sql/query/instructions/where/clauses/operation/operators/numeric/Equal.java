package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import com.kokalam.sql.query.instructions.where.clauses.operation.operators.Operator;

public class Equal<T extends Number> implements Operator {

    private final T value;

    Equal(T value) {
        this.value = value;
    }

    @Override
    public String generate() {
        return null;
    }
}
