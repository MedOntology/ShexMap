package com.medontology.shexmap.validator.solution;

import com.medontology.shexmap.validator.ShexExtension;
import org.apache.jena.graph.Node;

import java.util.List;

public class TestedTriple extends Solution {
    private Node subject;
    private Node predicate;
    private Node object;
    private Object referenced;//Don't know what object type that is
    private List<ShexExtension> extensions;
}
