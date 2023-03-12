package com.kokalam.sql.query.instructions.from;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FromTest {

    @Test
    @DisplayName("from with one table")
    public void shouldReturnFromWithOneTable() {
        String expectedFrom = " FROM User";
        From.Builder builder = new From.Builder();
        From from = builder.table(t -> t.name("User")).build();
        Assertions.assertEquals(expectedFrom, from.generate());
    }

    @Test
    @DisplayName("from with two table")
    public void shouldReturnFromWithTwoTable() {
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
    public void shouldThrowExceptionOfNoTableSelected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new From.Builder().build();
        });
    }
}
