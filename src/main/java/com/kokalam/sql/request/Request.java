package com.kokalam.sql.request;

import com.kokalam.sql.request.column.Column;
import com.kokalam.sql.request.table.Table;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Request {

    private String query;

    private Request(String query) {
        this.query = query;
    }

    public String get() {
        return this.query;
    }

    public static class Builder {

        private  List<Column> columns;

        public Builder select() {
            this.columns = Collections.singletonList(Column.column("*"));
            return this;
        }
        public Builder select(final String ...columns) {
            this.columns = Arrays.stream(columns)
                    .map(Column::column)
                    .collect(Collectors.toList());
            return this;
        }

        public Builder select(final Column ...columns) {
            this.columns = Arrays.asList(columns);
            return this;
        }

        public Builder from(final String ...tables) {
            return this;
        }

        public Builder from(final Table ...tables) {
            return this;
        }

        public Request build() {
            return new Request("");
        }
    }
}
