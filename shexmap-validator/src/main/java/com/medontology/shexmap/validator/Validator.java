package com.medontology.shexmap.validator;

import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shex.*;

public class Validator {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean validateSchema(String schemaPath, String schemaBase, String dataPath, String nodeStr, String shapeStr) {
        Model model = ModelFactory.createDefaultModel();
        Node node = model.createResource(nodeStr).asNode();
        Node shapeRef = model.createResource(shapeStr).asNode();
        ShexMapBuilder b = new ShexMapBuilder();
        b.add(node, shapeRef);

        Graph graph = RDFDataMgr.loadGraph(dataPath);
        //RDFDataMgr.read(Model model, String uri, String base, Lang hintLang)
        ShexSchema schema = Shex.readSchema(schemaPath, schemaBase);
        ShexReport report = ShexValidator.get().validate(graph, schema, b.build());

        return report.conforms();
    }
}
