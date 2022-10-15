package com.medontology.shexmap.validator.expression;

import com.medontology.shexmap.validator.SemanticAct;
import org.apache.jena.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class TripleConstraint extends AbstractExpression {
    private Node predicate;
    private Expression valueExpression;
    private List<SemanticAct> semActs = new ArrayList<>();

    public Node getPredicate() {
        return predicate;
    }

    public void setPredicate(Node predicate) {
        this.predicate = predicate;
    }

    public Expression getValueExpression() {
        return valueExpression;
    }

    public void setValueExpression(Expression valueExpression) {
        this.valueExpression = valueExpression;
    }

    public List<SemanticAct> getSemActs() {
        return semActs;
    }

    public void setSemActs(List<SemanticAct> semActs) {
        this.semActs = semActs;
    }

    public void addSemAct(SemanticAct semAct) {
        this.semActs.add(semAct);
    }
}
