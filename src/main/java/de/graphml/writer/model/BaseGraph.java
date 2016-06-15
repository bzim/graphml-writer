package de.graphml.writer.model;

public class BaseGraph implements Graph {
	public String description;
	public boolean defaultDirected;
	public static final Graph DIRECTED = new BaseGraph().withDefaultDirected(true);
	public static final Graph UNDIRECTED = new BaseGraph();
	
	public BaseGraph(){
	}

	public BaseGraph withDescription(String description){
		this.description = description;
		return this;
	}
	
	public BaseGraph withDefaultDirected(boolean defaultDirected){
		this.defaultDirected = defaultDirected;
		return this;
	}
	
	@Override
	public void writeStart(ElementWriter w, String id) {
		w.startElement("graph");
		w.writeAttribute("id", id);
		w.writeAttribute("edgedefault", defaultDirected ? "directed" : "undirected");
		if (description != null){
			w.startData(DefaultKeys.DESCRIPTION_FOR_GRAPH);
			w.writeText(description);
			w.endElement();
		}
	}

	@Override
	public void writeEnd(ElementWriter w) {
		w.endElement();
	}
}
