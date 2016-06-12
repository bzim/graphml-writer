package org.graphml.writer.yed.graphics;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;
import org.graphml.writer.yed.style.ShapeType;

public class Shape implements LeafRenderable, YedConstants {
	public ShapeType shapeType = ShapeType.RECTANGLE;
	@Override
	public void writeTo(ElementWriter w) {
 		w.startElement(Y, "Shape");
 		w.writeAttribute("type", shapeType.value);
  		w.endElement();
	}

}
