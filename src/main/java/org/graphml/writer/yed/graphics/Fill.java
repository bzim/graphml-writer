package org.graphml.writer.yed.graphics;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;

public class Fill implements LeafRenderable, YedConstants {
	public boolean transparent;
	public String color="#c0c0c0";
	public String color2;
	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "Fill");
		w.writeAttribute("color", color);
		w.writeAttribute("color2", color2);
		w.writeAttribute("transparent", transparent);
		w.endElement();
	}
}
