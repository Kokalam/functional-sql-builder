package com.kokalam.sql.query.instructions.from.clauses.table;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TableTest {

    @Test
    @DisplayName("generate table with name")
    void shouldReturnTableName() {
        String expectTable = "User";
        Table.Builder builder = new Table.Builder();
        builder.name("User");
        Table table = builder.build();
        Assertions.assertEquals(expectTable, table.generate());
    }

    @Test
    @DisplayName("generate table with name and alias")
    void shouldReturnTableNameAndItsAlias() {
        String expectTable = "User u";
        Table.Builder builder = new Table.Builder();
        builder.name("User").as("u");
        Table table = builder.build();
        Assertions.assertEquals(expectTable, table.generate());
    }

    @Test
    @DisplayName("table name should always be set")
    void shouldThrowExceptionIfTableHasNoName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Table.Builder builder = new Table.Builder();
            builder.as("u").build();
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Table.Builder builder = new Table.Builder();
            builder.name("").as("u").build();
        });
    }
}
