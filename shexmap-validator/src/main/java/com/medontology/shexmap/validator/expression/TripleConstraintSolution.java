package com.medontology.shexmap.validator.expression;

import com.medontology.shexmap.validator.SemanticAct;
import com.medontology.shexmap.validator.solution.Solution;
import org.apache.jena.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class TripleConstraintSolution extends AbstractExpression {

    private Node predicate;
    private Expression valueExpression;
    private List<SemanticAct> semActs = new ArrayList<>();
    private List<Solution> solutions = new ArrayList<>();
}
