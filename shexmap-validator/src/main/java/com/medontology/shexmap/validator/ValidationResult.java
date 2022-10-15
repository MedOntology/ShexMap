package com.medontology.shexmap.validator;

import com.medontology.shexmap.validator.test.ShapeExpressionTest;
import org.apache.jena.graph.Node;

public class ValidationResult {
    private Node node;
    private Node shape;//Not sure what type this really is. Using node for now.
    private String status;//Create an enum instead. Need to know what are the values "conformant", ...
    private ShapeExpressionTest appInfo;
    private int elapsed;

}
