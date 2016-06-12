package org.graphml.writer.yed.style;

public enum Alignment {
	CENTER("center"),
	LEFT("left"),
	RIGHT("right");
	public final String value;
	private Alignment(String value){
		this.value = value;
	}
}
