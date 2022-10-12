package com.medontology.shexmap.validator;

import org.apache.jena.graph.Graph;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shex.Shex;
import org.apache.jena.shex.ShexMap;
import org.apache.jena.shex.ShexSchema;
import org.apache.jena.shex.ShexValidator;

import java.io.InputStream;

public class Validator {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public void validateSchema(String schemaPath, String baseUri, String dataPath) {
        ShexSchema schema = Shex.readSchema(schemaPath, baseUri);
        Graph graph = RDFDataMgr.loadGraph(dataPath);
        ShexValidator.get().validate(graph, schema, schema.getShapes().get(0), graph.find().next().getSubject());
    }
}
