package com.medontology.shexmap.validator;

import org.apache.jena.graph.Graph;
import org.apache.jena.graph.Node;
import org.apache.jena.irix.IRIx;
import org.apache.jena.irix.IRIxResolver;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.shex.ShexMap;
import org.apache.jena.shex.ShexMapBuilder;
import org.apache.jena.irix.IRIx;

/**
 * Crap work to make Validator more literate.
 * Holds a Model and an IRIxResolver.
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
