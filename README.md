graphml-writer
==============

The library is intended to be used as a sequential writer for the GraphML file format:

http://graphml.graphdrawing.org

This library writes XML nodes, graphs and edges with necessary namespace initialization ahead.
 
There is explicitly no graph model, complex layout logic or any other fancy stuff. This library just writes. 
Note: All objects which define a graphic state could be reused after they are written to the stream, so a minimal processing memory footprint is possible.

Typically this is where you start with: 

1. Build a nice graph model with any of the freely available libraries or your own
2. Do some operations on the graph, express your relations etc.
3. Use this library to write a representational GraphML file
4. View it in an external tool, like yEd or any other GraphML supporting renderer

Furthermore it has support for writing yEd (http://www.yworks.com/products/yed) compatible graphic nodes and edges.

Example code to render a simple graph
=====================================

```java

	GraphWriter graphWriter = new GraphWriter(new FileOutputStream("target/simple.graphml"));
	graphWriter.startDocument();
	graphWriter.writeKeys(Arrays.asList(YedKeys.values()));

	graphWriter.startGraph(BaseGraph.DIRECTED);
	YedNode<ShapeNode> node = new YedNode<>(ShapeNode.asRectangle(0d, 0d, 250d, 30d, "Data"));
	// write the node
	graphWriter.node(node, graphWriter.getNextId());
	
	// re-set text for next node
	node.nodeGraphics.firstLabel().text = "Task1";
	// adjust y coordinate
	node.nodeGraphics.geometry.y = 250d;
	// write the next node
	graphWriter.node(node, graphWriter.getNextId());
	
	PolyLineEdge
		edgeGraphics = new PolyLineEdge();
	edgeGraphics.addLabel(EdgeLabel.sourceHead("source head"));
	edgeGraphics.addLabel(EdgeLabel.centered("flow"));
	edgeGraphics.addLabel(EdgeLabel.targetHead("target"));
	
	YedEdge<PolyLineEdge>
		edge = new YedEdge<>(edgeGraphics);
	// write the edge, connecting from node "2" to "1"
	graphWriter.edge(edge, graphWriter.getNextId(), "2", "1");
	graphWriter.endGraph(BaseGraph.DIRECTED);
	graphWriter.endDocument();
	
```

![](https://github.com/bzim/graphml-writer/blob/develop/doc/images/simple.jpg)

[Resulting graph, viewed in yEd]

Dependency for maven projects
============================================

```xml

	<dependency>
		<groupId>de.graphml.writer</groupId>
		<artifactId>graphml-writer</artifactId>
		<version>0.1.0</version>
	</dependency>
		
```

Other
=====
Travis CI: [![Build Status](https://travis-ci.org/bzim/graphml-writer.svg?branch=develop)](https://travis-ci.org/bzim/graphml-writer)
