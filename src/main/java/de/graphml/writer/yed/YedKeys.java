package de.graphml.writer.yed;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.model.Key;

public enum YedKeys implements Key{
	PORT_GRAPHICS("y1", "port", "yfiles.type", "portgraphics"),
	PORT_GEOMETRY("y2", "port", "yfiles.type", "portgeometry"),
	PORT_USERDATA("y3", "port", "yfiles.type", "portuserdata"),
	NODE_GRAPHICS("y4", "node", "yfiles.type", "nodegraphics"),
	RESOURCES_FOR_GRAPHML("y5", "graphml", "yfiles.type", "resources"),
	EDGE_GRAPHICS("y6", "edge", "yfiles.type", "edgegraphics");

	public final String id;
	public final String forName;
	public final String attrTypeName;
	public final String attrTypeValue;
	
	YedKeys(String id, String forName, String attrTypeName, String attrTypeValue){
		this.id = id;
		this.forName = forName;
		this.attrTypeName = attrTypeName;
		this.attrTypeValue = attrTypeValue;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void writeTo(ElementWriter w) {
		w.startElement("key");
		w.writeAttribute("id", id);
		w.writeAttribute("for", forName);
		w.writeAttribute(attrTypeName, attrTypeValue);
		w.endElement();
	}
}