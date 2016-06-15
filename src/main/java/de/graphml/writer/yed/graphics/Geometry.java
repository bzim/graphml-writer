package de.graphml.writer.yed.graphics;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;

public class Geometry implements LeafRenderable, YedConstants {
	public Double width=100d;
	public Double height=100d;
	public Double x;
	public Double y;
	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "Geometry");
		w.writeAttribute("height", height);
		w.writeAttribute("width", width);
		w.writeAttribute("x", x);
		w.writeAttribute("y", y);
		w.endElement();
	}

}
