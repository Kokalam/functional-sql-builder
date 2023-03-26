package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import com.kokalam.sql.query.instructions.where.clauses.operation.operators.Operator;

public class Between<T extends Number, U extends Number> implements Operator {

    private final T firstValue;
    private final U secondValue;

    Between(T firstValue, U secondValue) {
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }

    @Override
    public String generate() {
        return null;
    }
}
