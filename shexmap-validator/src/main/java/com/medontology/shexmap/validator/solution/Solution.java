package com.medontology.shexmap.validator.solution;

import com.medontology.shexmap.validator.expression.AbstractExpression;
import org.apache.jena.graph.Node;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String type;//Turn this into an enum. Need all possible statuses
    private Node subject;
    private Node predicate;
    private Node object;
    private Object referenced;//Figure out the type with Eric. Looks like a constraint.
    private List<Object> extensions; //Figure out the type with Eric. Can that be anything? At the very list make Extension an interface but probably already exists in Jena

    private List<AbstractExpression> expressions = new ArrayList<>();
    private List<Solution> solutions = new ArrayList<>();
}
