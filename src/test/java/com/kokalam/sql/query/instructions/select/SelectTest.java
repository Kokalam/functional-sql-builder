package com.kokalam.sql.query.instructions.select;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SelectTest {

    @Test
    @DisplayName("select one column")
    void shouldGenerateSelectWithOneColumn() {
        String expectedSelect = "SELECT name";
        Select.Builder builder = new Select.Builder();
        builder.column(c -> c.name("name"));
        Select select = builder.build();
        Assertions.assertEquals(expectedSelect, select.generate());
    }

    @Test
    @DisplayName("select two column")
    void shouldGenerateSelectWithTwoColumn() {
        String expectedSelect = "SELECT name,surname";
        Select.Builder builder = new Select.Builder();
        builder.column(c -> c.name("name"))
                .column(c -> c.name("surname"));
        Select select = builder.build();
        Assertions.assertEquals(expectedSelect, select.generate());
    }

    @Test
    @DisplayName("at least one column should be selected")
    void shouldThrowExceptionIfNoColumnSelected() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Select.Builder().build();
        });
    }
}
