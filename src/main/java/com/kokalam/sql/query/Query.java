package com.kokalam.sql.query;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.from.From;
import com.kokalam.sql.query.instructions.select.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Query {

    private final String request;

    private Query(String request) {
        this.request = request;
    }

    public String get() {
        return this.request;
    }

    public static class Builder {
        private enum State {
            INIT,SELECT,FROM
        }

        private State state;

        private  List<Instruction> instructions;

        public Builder() {
            this.instructions = new ArrayList<>();
            this.state = State.INIT;
        }

        public Builder select(Consumer<Select.Builder> consumer) {
            if (state.equals(State.SELECT)) {
                throw new IllegalStateException("select clause must be called only once");
            }
            Select.Builder builder = new Select.Builder();
            consumer.accept(builder);
            this.instructions.add(builder.build());
            this.state = State.SELECT;
            return this;
        }

        public Builder from(Consumer<From.Builder> consumer) {
            if (!state.equals(State.SELECT)) {
                throw new IllegalStateException("from clause must be called after select clause");
            }
            From.Builder builder = new From.Builder();
            consumer.accept(builder);
            this.instructions.add(builder.build());
            this.state = State.FROM;
            return this;
        }

        public Query build() {
            return new Query(instructions.stream().map(Instruction::generate).collect(Collectors.joining()));
        }
    }
}
