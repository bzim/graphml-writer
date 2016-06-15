package de.graphml.writer.yed.graphics;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;

public class ProxyAutoBoundsNode implements NodeGraphics, YedConstants{
	public GroupNode groupNode = new GroupNode();

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "ProxyAutoBoundsNode");
		w.startElement(Y, "Realizers");
		w.writeAttribute("active", 0);
		
		groupNode.writeTo(w);
		
        w.endElement(); // Realizers
   		w.endElement(); // ProxyAutoBoundsNode
	}
}
