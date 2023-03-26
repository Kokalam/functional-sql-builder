package com.kokalam.sql.query.instructions.where.clauses.operation.operators.numeric;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

public class EqualTest {

    @Test
    @DisplayName("should generate integer equality check")
    void shouldReturnEqualOperationWithInteger() {
        Equal<Integer> equal = new Equal<>(12);

        Assertions.assertEquals(" == 12", equal.generate());
    }

    @Test
    @DisplayName("should generate long equality check")
    void shouldReturnEqualOperationWithLong() {
        Equal<Long> equal = new Equal<>(12L);

        Assertions.assertEquals(" == 12", equal.generate());
    }

    @Test
    @DisplayName("should generate double equality check")
    void shouldReturnEqualOperationWithDouble() {
        Equal<Double> equal = new Equal<>(12.12);

        Assertions.assertEquals(" == 12.12", equal.generate());
    }

    @Test
    @DisplayName("should generate big integer equality check")
    void shouldReturnEqualOperationWithBigInteger() {
        Equal<BigInteger> equal = new Equal<>(BigInteger.TEN);

        Assertions.assertEquals(" == 10", equal.generate());
    }

    @Test
    @DisplayName("should generate big decimal equality check")
    void shouldReturnEqualOperationWithBigDecimal() {
        Equal<BigDecimal> equal = new Equal<>(BigDecimal.valueOf(10.10));

        Assertions.assertEquals(" == 10.10", equal.generate());
    }
}
