package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class GreaterTest {

    @Test
    @DisplayName("should generate integer greater check")
    void shouldReturnGreaterOperationWithInteger() {
        Greater<Integer> greater = new Greater<>(12);

        Assertions.assertEquals(" > 12", greater.generate());
    }

    @Test
    @DisplayName("should generate long greater check")
    void shouldReturnGreaterOperationWithLong() {
        Greater<Long> greater = new Greater<>(12L);

        Assertions.assertEquals(" > 12", greater.generate());
    }

    @Test
    @DisplayName("should generate double greater check")
    void shouldReturnGreaterOperationWithDouble() {
        Greater<Double> greater = new Greater<>(12.12);

        Assertions.assertEquals(" > 12.12", greater.generate());
    }

    @Test
    @DisplayName("should generate big integer greater check")
    void shouldReturnGreaterOperationWithBigInteger() {
        Greater<BigInteger> greater = new Greater<>(BigInteger.TEN);

        Assertions.assertEquals(" > 10", greater.generate());
    }

    @Test
    @DisplayName("should generate big decimal greater check")
    void shouldReturnGreaterOperationWithBigDecimal() {
        Greater<BigDecimal> greater = new Greater<>(BigDecimal.valueOf(10.10));

        Assertions.assertEquals(" > 10.10", greater.generate());
    }
}
