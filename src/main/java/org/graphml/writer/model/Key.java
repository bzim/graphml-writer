package org.graphml.writer.model;

public interface Key {
	String getId();
	void writeTo(ElementWriter writer);
}
