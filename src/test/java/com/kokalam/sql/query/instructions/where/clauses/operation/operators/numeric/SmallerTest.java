package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class SmallerTest {

    @Test
    @DisplayName("should generate integer smaller check")
    void shouldReturnSmallerOperationWithInteger() {
        Smaller<Integer> smaller = new Smaller<>(12);

        Assertions.assertEquals(" < 12", smaller.generate());
    }

    @Test
    @DisplayName("should generate long smaller check")
    void shouldReturnSmallerOperationWithLong() {
        Smaller<Long> smaller = new Smaller<>(12L);

        Assertions.assertEquals(" < 12", smaller.generate());
    }

    @Test
    @DisplayName("should generate double smaller check")
    void shouldReturnSmallerOperationWithDouble() {
        Smaller<Double> smaller = new Smaller<>(12.12);

        Assertions.assertEquals(" < 12.12", smaller.generate());
    }

    @Test
    @DisplayName("should generate big integer smaller check")
    void shouldReturnSmallerOperationWithBigInteger() {
        Smaller<BigInteger> smaller = new Smaller<>(BigInteger.TEN);

        Assertions.assertEquals(" < 10", smaller.generate());
    }

    @Test
    @DisplayName("should generate big decimal smaller check")
    void shouldReturnSmallerOperationWithBigDecimal() {
        Smaller<BigDecimal> smaller = new Smaller<>(BigDecimal.valueOf(10.10));

        Assertions.assertEquals(" < 10.10", smaller.generate());
    }
}
