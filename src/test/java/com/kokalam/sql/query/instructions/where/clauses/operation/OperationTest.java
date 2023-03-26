package com.kokalam.sql.query.instructions.where.clauses.operation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OperationTest {

    @Test
    @DisplayName("should build equal operation on column score")
    void shouldReturnEqualStringWithColumnScoreAndOperator() {
        Operation.Builder builder = new Operation.Builder();
        builder.column(c -> c.name("score")).equal(1);
        Assertions.assertEquals("score == 1", builder.build().generate());
    }

    @Test
    @DisplayName("should build greater operation on column score")
    void shouldReturnGreaterStringWithColumnScoreAndOperator() {
        Operation.Builder builder = new Operation.Builder();
        builder.column(c -> c.name("score")).greater(1);
        Assertions.assertEquals("score > 1", builder.build().generate());
    }

    @Test
    @DisplayName("should build greater or equal operation on column score")
    void shouldReturnGreaterOrEqualStringWithColumnScoreAndOperator() {
        Operation.Builder builder = new Operation.Builder();
        builder.column(c -> c.name("score")).greaterOrEqual(1);
        Assertions.assertEquals("score >= 1", builder.build().generate());
    }

    @Test
    @DisplayName("should build smaller or equal operation on column score")
    void shouldReturnSmallerOrEqualStringWithColumnScoreAndOperator() {
        Operation.Builder builder = new Operation.Builder();
        builder.column(c -> c.name("score")).smallerOrEqual(1);
        Assertions.assertEquals("score <= 1", builder.build().generate());
    }

    @Test
    @DisplayName("should build smaller operation on column score")
    void shouldReturnSmallerStringWithColumnScoreAndOperator() {
        Operation.Builder builder = new Operation.Builder();
        builder.column(c -> c.name("score")).smaller(1);
        Assertions.assertEquals("score < 1", builder.build().generate());
    }

    @Test
    @DisplayName("should build smaller operation on column score")
    void shouldReturnBetweenStringWithColumnScoreAndOperator() {
        Operation.Builder builder = new Operation.Builder();
        builder.column(c -> c.name("score")).between(1, 2);
        Assertions.assertEquals("score BETWEEN 1 AND 2", builder.build().generate());
    }
}
