package com.medontology.shexmap.validator;

import org.apache.jena.graph.Graph;
import org.apache.jena.shex.*;

public class Validator {

    /**
     * Load schema and data and validate
     *
     * @param schema Load resource
     * @param data   Load resource
     * @return       ShExReport from validation
     */
    public static ShexReport validateSchema(Load schema, Load data) {
        Resolver r = new Resolver();

        ShexMap shapeMap = r.shapeMap(r.node(data.node, data.base), r.node(schema.node, schema.base));
        Graph graph = r.readTurtle(data.path, data.base);
        ShexSchema schema1 = Shex.readSchema(schema.path, schema.base);
        return ShexValidator.get().validate(graph, schema1, shapeMap);
    }

    /**
     * parameter to `validateSchema` for specifying:
     * path - file path for loadable resource
     * base - base URI when loading that resource
     * node - point in loaded resource (validation focus or shape name)
     */
    public static class Load {
        String path;
        String base;
        String node;

        /**
         * Specify rooted RDF resource to parse
         * @param path file path for loadable resource
         * @param base base URI when loading that resource
         * @param node point in loaded resource (validation focus or shape name)
         */
        Load(String path, String base, String node) {
            this.path = path;
            this.base = base;
            this.node = node;
        }
    }
}
