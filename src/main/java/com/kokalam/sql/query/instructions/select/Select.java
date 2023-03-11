package com.kokalam.sql.query.instructions.select;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.select.column.Column;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Select implements Instruction {

    private List<Column> columns;

    private Select(List<Column> columns) {
        this.columns = columns;
    }

    @Override
    public String generate() {
        return "SELECT "
                + columns.stream()
                .map(Column::generate)
                .collect(Collectors.joining(","));
    }

    public static class Builder {

        private List<Column> columns;

        public Builder() {
            columns = new ArrayList<>();
        }

        public Builder column(Consumer<Column.Builder> consumer) {
            Column.Builder builder = new Column.Builder();
            consumer.accept(builder);
            columns.add(builder.build());
            return this;
        }

        public Select build() {
            return new Select(columns);
        }
    }
}
