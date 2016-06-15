package de.graphml.writer.model;

public interface Edge{
	void writeStart(ElementWriter writer, String id, String source, String target);
	void writeEnd(ElementWriter writer);
}