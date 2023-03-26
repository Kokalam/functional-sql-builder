package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GreaterOrEqualTest {

    @Test
    @DisplayName("should generate integer greater check")
    void shouldReturnGreaterOrEqualOperationWithInteger() {
        GreaterOrEqual<Integer> greaterOrEqual = new GreaterOrEqual<>(12);

        Assertions.assertEquals(" >= 12", greaterOrEqual.generate());
    }

    @Test
    @DisplayName("should generate long greater check")
    void shouldReturnGreaterOrEqualOperationWithLong() {
        GreaterOrEqual<Long> greaterOrEqual = new GreaterOrEqual<>(12L);

        Assertions.assertEquals(" >= 12", greaterOrEqual.generate());
    }

    @Test
    @DisplayName("should generate double greater check")
    void shouldReturnGreaterOrEqualOperationWithDouble() {
        GreaterOrEqual<Double> greaterOrEqual = new GreaterOrEqual<>(12.12);

        Assertions.assertEquals(" >= 12.12", greaterOrEqual.generate());
    }

    @Test
    @DisplayName("should generate big integer greater check")
    void shouldReturnGreaterOrEqualOperationWithBigInteger() {
        GreaterOrEqual<BigInteger> greaterOrEqual = new GreaterOrEqual<>(BigInteger.TEN);

        Assertions.assertEquals(" >= 10", greaterOrEqual.generate());
    }

    @Test
    @DisplayName("should generate big decimal greater check")
    void shouldReturnGreaterOrEqualOperationWithBigDecimal() {
        GreaterOrEqual<BigDecimal> greaterOrEqual = new GreaterOrEqual<>(BigDecimal.valueOf(10.10));

        Assertions.assertEquals(" >= 10.10", greaterOrEqual.generate());
    }
}
