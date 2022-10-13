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

/**
 * Crap work to make Validator more literate.
 */
class Resolver {
    Model model = ModelFactory.createDefaultModel();

    /**
     * Emulate javascript's URL(rel, base) interface 'cause I [ericP] assume it has wisdom.
     * @param rel  a relative IRI to be resolved against base, or an absolute IRI
     * @param base if this is null, rel should be absolute
     * @return     Node (technically, a URI_Resource, but that would need casting to Node for some reason)
     */
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

    /**
     * Construct a ShapeMap from a pair of node/shape
     * @param node     node in node/shape pair
     * @param shapeRef shape in node/shape pair
     * @return         ShapeMap (currently called `ShExMap`, but I intend to PR that)
     */
    public ShexMap shapeMap(Node node, Node shapeRef) {
        ShexMapBuilder mb = new ShexMapBuilder();
        mb.add(node, shapeRef);
        return mb.build();
    }

    /**
     * Emulate jena-shex's readSchema interface for Turtle files
     *
     * @param path path to Turtle file to parse
     * @param base base for URL resolution
     * @return ShEx schema
     */
    public Graph readTurtle(String path, String base) {
        RDFDataMgr.read(model, path, base, Lang.TTL);
        return model.getGraph();
    }
}
