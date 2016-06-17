package de.graphml.writer.test;
/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.junit.Test;

import de.graphml.writer.GraphWriter;
import de.graphml.writer.model.BaseGraph;
import de.graphml.writer.yed.YedEdge;
import de.graphml.writer.yed.YedGroupNode;
import de.graphml.writer.yed.YedKeys;
import de.graphml.writer.yed.YedNode;
import de.graphml.writer.yed.graphics.EdgeLabel;
import de.graphml.writer.yed.graphics.PolyLineEdge;
import de.graphml.writer.yed.graphics.ProxyAutoBoundsNode;
import de.graphml.writer.yed.graphics.RotatedDiscreteEdgeLabelModel;
import de.graphml.writer.yed.graphics.ShapeNode;
import de.graphml.writer.yed.style.AutoSizePolicy;
import de.graphml.writer.yed.style.LineType;
import de.graphml.writer.yed.style.ModelName;
import de.graphml.writer.yed.style.ModelPosition;
import de.graphml.writer.yed.style.ShapeType;

public class GraphMLWriterTest {
	@Test
	public void writeSimpleGraph() throws Exception {
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

		TestUtils.formatXMLFile("target/simple.graphml");
	}

	@Test
	public void writeSimpleGraphRotatingEdgeLabel() throws Exception {
		GraphWriter graphWriter = new GraphWriter(new FileOutputStream("target/simple_rotating_edgelabel.graphml"),
				StandardCharsets.UTF_8.name());
		graphWriter.startDocument();
		graphWriter.writeKeys(Arrays.asList(YedKeys.values()));

		graphWriter.startGraph(BaseGraph.DIRECTED);
		ShapeNode nodeGraphics = ShapeNode.asRectangle(250d, 30d, "Data");
		YedNode<ShapeNode> node = new YedNode<>(nodeGraphics);
		
		graphWriter.node(node, graphWriter.getNextId());
				
		nodeGraphics.label.text = "Task1";
		nodeGraphics.shape.shapeType = ShapeType.HEXAGON;
		nodeGraphics.geometry.width = 150d;

		graphWriter.node(node, graphWriter.getNextId());
		PolyLineEdge
			edgeGraphics = new PolyLineEdge();
		EdgeLabel edgeLabel = new EdgeLabel("flow");
		edgeLabel.setLabelModel(new RotatedDiscreteEdgeLabelModel());

		edgeGraphics.addLabel(edgeLabel);
		YedEdge<PolyLineEdge>
			edge = new YedEdge<>(edgeGraphics);
		graphWriter.edge(edge, graphWriter.getNextId(), "2", "1");
		
		graphWriter.endGraph(BaseGraph.DIRECTED);
		graphWriter.endDocument();

		TestUtils.formatXMLFile("target/simple_rotating_edgelabel.graphml");
	}
	
	
	@Test
	public void writeSubGraph() throws Exception {
		GraphWriter graphWriter = new GraphWriter(new FileOutputStream("target/subgraph.graphml"),
				StandardCharsets.UTF_8.name());

		graphWriter.startDocument();
		graphWriter.writeKeys(Arrays.asList(YedKeys.values()));

		graphWriter.startGraph(BaseGraph.DIRECTED);
		ShapeNode nodeGraphics = ShapeNode.asRectangle(250d, 30d, "Data");
		YedNode<ShapeNode> node = new YedNode<>(nodeGraphics);
		graphWriter.node(node, graphWriter.getNextId());

		ProxyAutoBoundsNode groupNodeShape = new ProxyAutoBoundsNode();
		YedGroupNode<ProxyAutoBoundsNode> graphicsGroupNode = new YedGroupNode<>(groupNodeShape);
		groupNodeShape.groupNode.label.modelName = ModelName.INTERNAL;
		groupNodeShape.groupNode.label.modelPosition = ModelPosition.TOP;
		groupNodeShape.groupNode.label.autoSizePolicy = AutoSizePolicy.NODE_WIDTH;
		groupNodeShape.groupNode.label.text = "test";
		graphWriter.startNode(graphicsGroupNode, "g1");
		graphWriter.startGraph(BaseGraph.DIRECTED);
		{
			nodeGraphics.label.text = "Sub Data 1";
			graphWriter.node(node, graphWriter.getNextId());
			nodeGraphics.label.text = "Sub Data 2";
			graphWriter.node(node, graphWriter.getNextId());
		}
		graphWriter.endGraph(BaseGraph.DIRECTED);
		graphWriter.endNode(graphicsGroupNode);
		PolyLineEdge
			edgeGraphics = new PolyLineEdge();
		edgeGraphics.lineType = LineType.DASHED;
		EdgeLabel edgeLabel = new EdgeLabel("flow");
		edgeGraphics.addLabel(edgeLabel);

		YedEdge<PolyLineEdge>
			edge = new YedEdge<>(edgeGraphics);
		
		graphWriter.edge(edge, graphWriter.getNextId(), "g1", "1");
		
		graphWriter.endGraph(BaseGraph.DIRECTED);
		graphWriter.endDocument();

		TestUtils.formatXMLFile("target/subgraph.graphml");

	}
	
	@Test
	public void writeBigGraph() throws Exception {
		ShapeNode dataShape = new ShapeNode();
		dataShape.geometry.width = 250d;
		dataShape.geometry.height = 30d;
		dataShape.shape.shapeType = ShapeType.PARALLELOGRAM;
		YedNode<ShapeNode> dataNode = new YedNode<>(dataShape);
		ShapeNode taskShape = new ShapeNode();
		YedNode<ShapeNode> taskNode = new YedNode<>(taskShape);
		taskShape.shape.shapeType = ShapeType.HEXAGON;
		taskShape.fill.color = "#00ff00";
		taskShape.geometry.width = 150d;
		taskShape.geometry.height = 30d;
		PolyLineEdge
			edgeGraphics = new PolyLineEdge();
		YedEdge<PolyLineEdge>
			edge = new YedEdge<>(edgeGraphics);
		GraphWriter graphWriter = new GraphWriter(new FileOutputStream("target/big.graphml"),
				StandardCharsets.UTF_8.name());
		graphWriter.startDocument();
		graphWriter.writeKeys(Arrays.asList(YedKeys.values()));

		graphWriter.startGraph(BaseGraph.DIRECTED);

		String oldTaskNodeId=null;
		
		for (int i=0; i < 100; i++){
			taskShape.label.text = ""+i;
			String taskNodeId = graphWriter.getNextId();
			graphWriter.node(taskNode, taskNodeId);
			if(oldTaskNodeId != null){
				graphWriter.edge(edge, graphWriter.getNextId(), oldTaskNodeId, taskNodeId);
			}
			oldTaskNodeId = taskNodeId;
			
			for (int n=0; n < 3; n++){
				dataShape.label.text = "Data";
				String dataNodeId = graphWriter.getNextId();
				graphWriter.node(dataNode, dataNodeId);
				graphWriter.edge(edge, graphWriter.getNextId(), taskNodeId, dataNodeId);
			}
			
		}
		graphWriter.endGraph(BaseGraph.DIRECTED);
		graphWriter.endDocument();
		TestUtils.formatXMLFile("target/big.graphml");
	}
}
