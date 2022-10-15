package com.medontology.shexmap.validator.expression;

import java.util.ArrayList;
import java.util.List;

public class EachOf extends AbstractExpression {

    private List<Expression> expressions = new ArrayList<>();

    public List<Expression> getExpressions() {
        return expressions;
    }

    public void setExpressions(List<Expression> expressions) {
        this.expressions = expressions;
    }

    public void addExpression(Expression expression) {
        this.expressions.add(expression);
    }
}
