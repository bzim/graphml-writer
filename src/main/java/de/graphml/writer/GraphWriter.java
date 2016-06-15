package de.graphml.writer;

import java.io.OutputStream;
import java.util.Collection;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

import de.graphml.writer.model.DefaultKeys;
import de.graphml.writer.model.Edge;
import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.model.Graph;
import de.graphml.writer.model.Key;
import de.graphml.writer.model.Node;

public class GraphWriter {
	protected XMLStreamWriter xtw;
	protected int openElements = 0;
	protected int idSequence;
	protected final ElementWriter elementWriter = new InternalWriter();
	public GraphWriter(OutputStream fileOutputStream, String name) {
		XMLOutputFactory xof = XMLOutputFactory.newInstance();
		try {
			xtw = xof.createXMLStreamWriter(fileOutputStream, name);
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
	}

	public String getNextId() {
		int id = idSequence++;
		return String.valueOf(id);
	}

	public void node(Node node, String id) {
		node.writeStart(elementWriter, id);
		node.writeEnd(elementWriter);
	}

	public void startNode(Node node, String id) {
		node.writeStart(elementWriter, id);
	}

	public void endNode(Node node) {
		node.writeEnd(elementWriter);
	}

	public void edge(Edge edge, String id, String source, String target) {
		edge.writeStart(elementWriter, id, source, target);
		edge.writeEnd(elementWriter);
	}

	public void startDocument() {
		try {
			xtw.writeStartDocument("utf-8", "1.0");
			xtw.setPrefix("html", "http://www.w3.org/TR/REC-html40");
			elementWriter.startElement("graphml");
			xtw.writeNamespace("xmlns", "http://graphml.graphdrawing.org/xmlns");
			xtw.writeNamespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
			xtw.writeNamespace("y", "http://www.yworks.com/xml/graphml");
			xtw.writeAttribute("http://www.w3.org/2001/XMLSchema-instance", "schemaLocation",
					"http://graphml.graphdrawing.org/xmlns");
			for (Key key : DefaultKeys.values()) {
				key.writeTo(elementWriter);
			}
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
	}

	public void writeKeys(Collection<Key> keys) {
		for (Key key : keys) {
			key.writeTo(elementWriter);
		}
	}

	public String startGraph(Graph graph){
		String nextId = getNextId();
		startGraph(graph, nextId);
		return nextId;
	}
	
	public void startGraph(Graph graph, String id) {
		graph.writeStart(elementWriter, id);
	}

	public void endGraph(Graph graph) {
		graph.writeEnd(elementWriter);
	}

	public void endDocument() {
		while (openElements > 0) {
			elementWriter.endElement();
		}
		try {
			xtw.writeEndDocument();
			xtw.flush();
			xtw.close();
		} catch (XMLStreamException e) {
			throw new RuntimeException(e);
		}
	}

	private class InternalWriter implements ElementWriter {

		@Override
		public void endElement() {
			if (openElements == 0) {
				throw new IllegalStateException("no open element found");
			}
			try {
				openElements--;
				xtw.writeEndElement();
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void writeText(String description) {
			try {
				xtw.writeCharacters(description);
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void startData(Key key) {
			startElement("data");
			writeAttribute("key", key.getId());
		}

		@Override
		public void startElement(String localName) {
			openElements++;

			try {
				xtw.writeStartElement(localName);
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void startElement(String namespaceURI, String localName) {
			openElements++;

			try {
				xtw.writeStartElement(namespaceURI, localName);
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void writeAttribute(String localName, String value) {
			if (value == null) {
				return;
			}
			try {
				xtw.writeAttribute(localName, value);
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void writeAttribute(String localName, Boolean value) {
			if (value == null) {
				return;
			}
			try {
				xtw.writeAttribute(localName, String.valueOf(value));
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public void writeAttribute(String localName, Double value) {
			if (value == null) {
				return;
			}
			try {
				xtw.writeAttribute(localName, String.valueOf(value));
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}

		}

		@Override
		public void writeAttribute(String localName, Integer value) {
			if (value == null) {
				return;
			}
			try {
				xtw.writeAttribute(localName, String.valueOf(value));
			} catch (XMLStreamException e) {
				throw new RuntimeException(e);
			}
		}
	}

}