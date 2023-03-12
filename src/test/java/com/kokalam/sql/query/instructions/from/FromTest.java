package com.kokalam.sql.query.instructions.from;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FromTest {

    @Test
    @DisplayName("from with one table")
    void shouldReturnFromWithOneTable() {
        String expectedFrom = " FROM User";
        From.Builder builder = new From.Builder();
        From from = builder.table(t -> t.name("User")).build();
        Assertions.assertEquals(expectedFrom, from.generate());
    }

    @Test
    @DisplayName("from with two table")
    void shouldReturnFromWithTwoTable() {
        String expectedFrom = " FROM User,Address";
        From.Builder builder = new From.Builder();
        From from = builder
                .table(t -> t.name("User"))
                .table(t -> t.name("Address"))
                .build();
        Assertions.assertEquals(expectedFrom, from.generate());
    }

    @Test
    @DisplayName("at least one table should be selected")
    void shouldThrowExceptionOfNoTableSelected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new From.Builder().build();
        });
    }
}
