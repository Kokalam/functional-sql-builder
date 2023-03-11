package com.kokalam.sql.query;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.from.From;
import com.kokalam.sql.query.instructions.select.Select;
import com.kokalam.sql.query.instructions.select.column.Column;
import com.kokalam.sql.query.instructions.from.clauses.table.Table;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Query {

    private String query;

    private Query(String query) {
        this.query = query;
    }

    public String get() {
        return this.query;
    }

    public static class Builder {

        private  List<Instruction> instructions;

        public Builder select(Consumer<Select.Builder> builder) {
            return this;
        }

        public Builder from(Consumer<From.Builder> builder) {
            return this;
        }

        public Query build() {
            return new Query("");
        }
    }
}
