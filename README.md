# graphml-writer
The GraphML Writer Library is intended to be used as a sequential writer for the GraphML file format (http://graphml.graphdrawing.org). 
This library just writes xml nodes, graphs and edges with necessary namespace initialization ahead. 
There is explicitly no graph model, complex layout logic or any other fancy stuff. This library just writes.
Typically this is where you start with: 

1. Build a nice graph model with any of the freely available libraries or your own
2. Do some operations on the graph, express your relations etc.
3. Use this library to write a representational graphML file
4. View it in an external tool, like yEd or any other graphML supporting renderer

Furthermore it has some support for writing yEd compatible nodes and edges which are displayable via the great yEd (http://www.yworks.com/products/yed) tool.
 
# Example Code to render a simple Graph

		```java
		GraphWriter graphWriter = new GraphWriter(new FileOutputStream("target/simple.graphml"),
				StandardCharsets.UTF_8.name());
		graphWriter.startDocument();
		graphWriter.writeKeys(Arrays.asList(YedKeys.values()));
		
		graphWriter.startGraph(BaseGraph.DIRECTED);
		YedNode<ShapeNode> node = new YedNode<>(ShapeNode.asRectangle(0d, 0d, 250d, 30d, "Data"));
		// write the node
		graphWriter.node(node, graphWriter.getNextId());
		
		// re-set text for next node
		node.nodeGraphics.label.text = "Task1";
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
[Resulting Graph, viewed in yEd]
		