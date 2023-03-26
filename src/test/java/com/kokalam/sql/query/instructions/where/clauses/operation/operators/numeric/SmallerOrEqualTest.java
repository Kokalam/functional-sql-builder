package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SmallerOrEqualTest {

    @Test
    @DisplayName("should generate integer smaller or smallerOrEqual check")
    void shouldReturnSmallerOrEqualOperationWithInteger() {
        SmallerOrEqual<Integer> smallerOrEqual = new SmallerOrEqual<>(12);

        Assertions.assertEquals(" <= 12", smallerOrEqual.generate());
    }

    @Test
    @DisplayName("should generate long smaller or smallerOrEqual check")
    void shouldReturnSmallerOrEqualOperationWithLong() {
        SmallerOrEqual<Long> smallerOrEqual = new SmallerOrEqual<>(12L);

        Assertions.assertEquals(" <= 12", smallerOrEqual.generate());
    }

    @Test
    @DisplayName("should generate double smaller or smallerOrEqual check")
    void shouldReturnSmallerOrEqualOperationWithDouble() {
        SmallerOrEqual<Double> smallerOrEqual = new SmallerOrEqual<>(12.12);

        Assertions.assertEquals(" <= 12.12", smallerOrEqual.generate());
    }

    @Test
    @DisplayName("should generate big integer smaller or smallerOrEqual check")
    void shouldReturnSmallerOrEqualOperationWithBigInteger() {
        SmallerOrEqual<BigInteger> smallerOrEqual = new SmallerOrEqual<>(BigInteger.TEN);

        Assertions.assertEquals(" <= 10", smallerOrEqual.generate());
    }

    @Test
    @DisplayName("should generate big decimal smaller or smallerOrEqual check")
    void shouldReturnSmallerOrEqualOperationWithBigDecimal() {
        SmallerOrEqual<BigDecimal> smallerOrEqual = new SmallerOrEqual<>(BigDecimal.valueOf(10.10));

        Assertions.assertEquals(" <= 10.10", smallerOrEqual.generate());
    }
}
