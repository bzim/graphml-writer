package de.graphml.writer.model;

public interface Graph{
	void writeStart(ElementWriter writer, String id);
	void writeEnd(ElementWriter writer);
}