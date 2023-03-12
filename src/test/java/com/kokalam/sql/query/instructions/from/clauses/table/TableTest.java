package com.kokalam.sql.query.instructions.from.clauses.table;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TableTest {

    @Test
    @DisplayName("generate table with name")
    public void shouldReturnTableName() {
        String expectTable = "User";
        Table.Builder builder = new Table.Builder();
        builder.name("User");
        Table table = builder.build();
        Assertions.assertEquals(expectTable, table.generate());
    }

    @Test
    @DisplayName("generate table with name and alias")
    public void shouldReturnTableNameAndItsAlias() {
        String expectTable = "User u";
        Table.Builder builder = new Table.Builder();
        builder.name("User").as("u");
        Table table = builder.build();
        Assertions.assertEquals(expectTable, table.generate());
    }

    @Test
    @DisplayName("table name should always be set")
    public void shouldThrowExceptionIfTableHasNoName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Table.Builder builder = new Table.Builder();
            builder.as("u").build();
        });
    }
}
