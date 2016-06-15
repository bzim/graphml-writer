package de.graphml.writer.yed.style;

public enum AutoSizePolicy {
	CONTENT("content"),
	NODE_WIDTH("node_width"),
	NODE_HEIGHT("node_height"),
	NODE_SIZE("node_size");
	public final String value;
	private AutoSizePolicy(String value){
		this.value = value;
	}
}
