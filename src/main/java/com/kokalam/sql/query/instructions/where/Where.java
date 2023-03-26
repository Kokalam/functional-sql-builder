package com.kokalam.sql.query.instructions.where;

import com.kokalam.sql.query.instructions.Instruction;
import com.kokalam.sql.query.instructions.where.clauses.Clause;

import java.util.List;

public class Where implements Instruction {

    private List<Clause> clauses;

    @Override
    public String generate() {
        return null;
    }
}
