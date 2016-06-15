package de.graphml.writer.yed.style;

public enum LineType {
	LINE("line"),
	DASHED("dashed");
	public final String value;
	LineType(String value){
		this.value = value;
	}
}
