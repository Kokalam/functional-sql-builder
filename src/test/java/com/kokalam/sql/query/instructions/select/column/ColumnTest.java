package com.kokalam.sql.query.instructions.select.column;

import com.kokalam.sql.query.instructions.select.column.Column;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ColumnTest {

    @Test
    @DisplayName("generate column with name")
    public void shouldReturnColumnName() {
        String expectedColumn = "name";
        Column.Builder builder = new Column.Builder();
        builder.name("name");
        Column column = builder.build();
        Assertions.assertEquals(expectedColumn, column.generate());
    }

    @Test
    @DisplayName("generate column with name and alias")
    public void shouldReturnColumnNameAndAsAlias() {
        String expectedColumn = "name as pseudo";
        Column.Builder builder = new Column.Builder();
        builder.name("name").as("pseudo");
        Column column = builder.build();
        Assertions.assertEquals(expectedColumn, column.generate());
    }

    @Test
    @DisplayName("generate column with name and table specifier")
    public void shouldReturnColumnNameAndItsTableSpecifier() {
        String expectedColumn = "u.name";
        Column.Builder builder = new Column.Builder();
        builder.name("name").of("u");
        Column column = builder.build();
        Assertions.assertEquals(expectedColumn, column.generate());
    }

    @Test
    @DisplayName("generate column with name, alias and table specifier")
    public void shouldReturnColumnNameAndItsTableSpecifierAndAsAlias() {
        String expectedColumn = "u.name as pseudo";
        Column.Builder builder = new Column.Builder();
        builder.name("name").of("u").as("pseudo");
        Column column = builder.build();
        Assertions.assertEquals(expectedColumn, column.generate());
    }

    @Test
    @DisplayName("column name should always be specified")
    public void shouldThrowExceptionIfColumnHaveNoName() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Column.Builder builder = new Column.Builder();
            builder.of("u").as("pseudo").build();
        });
    }
}
