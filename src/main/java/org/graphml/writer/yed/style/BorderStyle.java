package org.graphml.writer.yed.style;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;
import org.graphml.writer.yed.graphics.LeafRenderable;

public class BorderStyle implements LeafRenderable, YedConstants {
	public String borderColor="#000000";
	public LineType lineType= LineType.LINE;

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "BorderStyle");
		w.writeAttribute("color", borderColor);
		w.writeAttribute("type", lineType.value);
		w.writeAttribute("width", 1.0);
		w.endElement();
	}
}
