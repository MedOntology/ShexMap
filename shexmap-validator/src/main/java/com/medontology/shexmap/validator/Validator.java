package com.medontology.shexmap.validator;

import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shex.*;
import org.apache.jena.irix.IRIx;

public class Validator {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public boolean validateSchema(Load data, Load schema) {
        Resolver r = new Resolver();

        ShexMap shapeMap = r.shapeMap(r.node(data.node, data.base), r.node(schema.node, schema.base));
        Graph graph = r.readGraph(data.path, data.base);
        ShexSchema schema1 = Shex.readSchema(schema.path, schema.base);
        ShexReport report = ShexValidator.get().validate(graph, schema1, shapeMap);

        return report.conforms();
    }
    public static class Load {
        String path;
        String base;
        String node;
        Load(String path, String base, String node) {
            this.path = path;
            this.base = base;
            this.node = node;
        }
    }
}

/**
 * Crap work to make Validator more literate.
 * Holds a Model and an IRIxResolver.
 */
class Resolver {
    Model model = ModelFactory.createDefaultModel();

    Node node (String rel, String base) {
        String resolved;
        if (base == null) {
            resolved = rel;
        } else {
            IRIx b = IRIx.create(base);
            resolved = b.resolve(rel).toString();
        }
        return model.createResource(resolved).asNode();
    }

    public ShexMap shapeMap(Node node, Node shapeRef) {
        ShexMapBuilder mb = new ShexMapBuilder();
        mb.add(node, shapeRef);
        return mb.build();
    }

    public Graph readGraph(String dataPath, String dataBase) {
        RDFDataMgr.read(model, dataPath, dataBase, Lang.TTL);
        return model.getGraph();
    }
}
