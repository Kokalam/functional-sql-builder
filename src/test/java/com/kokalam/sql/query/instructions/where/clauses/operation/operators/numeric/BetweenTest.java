package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BetweenTest {

    @Test
    @DisplayName("should generate between integer check")
    void shouldReturnBetweenOperationWithInteger() {
        Between<Integer, Integer> between = new Between<>(12, 16);

        Assertions.assertEquals(" BETWEEN 12 AND 16", between.generate());
    }

    @Test
    @DisplayName("should generate between long check")
    void shouldReturnBetweenOperationWithLong() {
        Between<Long, Long> between = new Between<>(12L, 16L);

        Assertions.assertEquals(" BETWEEN 12 AND 16", between.generate());
    }

    @Test
    @DisplayName("should generate between double check")
    void shouldReturnBetweenOperationWithDouble() {
        Between<Double, Double> between = new Between<>(12.12, 16.16);

        Assertions.assertEquals(" BETWEEN 12.12 AND 16.16", between.generate());
    }

    @Test
    @DisplayName("should generate between big integer check")
    void shouldReturnBetweenOperationWithBigInteger() {
        Between<BigInteger, BigInteger> between = new Between<>(BigInteger.ONE, BigInteger.TEN);

        Assertions.assertEquals(" BETWEEN 1 AND 10", between.generate());
    }

    @Test
    @DisplayName("should between big decimal check")
    void shouldReturnBetweenOperationWithBigDecimal() {
        Between<BigDecimal, BigDecimal> between = new Between<>(BigDecimal.valueOf(10.10), BigDecimal.valueOf(15.15));

        Assertions.assertEquals(" BETWEEN 10.10 AND 15.15", between.generate());
    }
}
