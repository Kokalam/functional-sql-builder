package com.kokalam.sql.query.instructions.select;

import com.kokalam.sql.query.Query;
import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.select.column.Column;

import java.util.List;
import java.util.function.Consumer;

public class Select implements Instruction {

    private List<Column> columns;

    @Override
    public String generate() {
        return null;
    }

    public static class Builder {

        private List<Column> columns;

        public Builder() {}

        public Builder column(Consumer<Column.Builder> builder) {
            return this;
        }
    }
}
