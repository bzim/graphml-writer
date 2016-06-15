package de.graphml.writer.model;

public interface Node{
	void writeStart(ElementWriter writer, String id);
	void writeEnd(ElementWriter writer);
}