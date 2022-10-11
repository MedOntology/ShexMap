package com.medontology.shexmap.validator;

import org.apache.jena.graph.Graph;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shex.Shex;
import org.apache.jena.shex.ShexSchema;
import org.apache.jena.shex.ShexValidator;

import java.io.InputStream;

public class Validator {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public void loadExample(String resourcePath) {

        ShexSchema schema = Shex.readSchema(resourcePath, "http://a.example");
        Graph graph = RDFDataMgr.loadGraph("Is1_Ip1_Io1.ttl");
        ShexValidator.get().validate(graph, schema, schema.getShapes().get(0), graph.find().next().getSubject());
    }
}
