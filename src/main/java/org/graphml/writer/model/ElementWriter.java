package org.graphml.writer.model;

public interface ElementWriter {

	void startData(Key key);

	void startElement(String localName);

	void startElement(String namespaceURI, String localName);

	void writeAttribute(String localName, String value);

	void writeAttribute(String localName, Boolean value);

	void writeAttribute(String localName, Double value);

	void writeAttribute(String localName, Integer value);

	void writeText(String description);

	void endElement();
}