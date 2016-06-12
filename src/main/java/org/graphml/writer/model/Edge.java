package org.graphml.writer.model;

public interface Edge{
	void writeStart(ElementWriter writer, String id, String source, String target);
	void writeEnd(ElementWriter writer);
}