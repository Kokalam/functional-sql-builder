package com.kokalam.sql.query.instructions.from.clauses.table;

import com.kokalam.sql.query.instructions.from.clauses.Clause;

public class Table implements Clause {

    @Override
    public String generate() {
        return null;
    }

    public static class Builder {

        public Builder name(String name) {
            return this;
        }

        public Builder as(String alias) {
            return this;
        }
    }
}
