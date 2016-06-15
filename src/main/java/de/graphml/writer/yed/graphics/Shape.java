package de.graphml.writer.yed.graphics;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;
import de.graphml.writer.yed.style.ShapeType;

public class Shape implements LeafRenderable, YedConstants {
	public ShapeType shapeType = ShapeType.RECTANGLE;
	@Override
	public void writeTo(ElementWriter w) {
 		w.startElement(Y, "Shape");
 		w.writeAttribute("type", shapeType.value);
  		w.endElement();
	}

}
