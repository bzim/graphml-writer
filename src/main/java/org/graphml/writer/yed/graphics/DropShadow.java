package org.graphml.writer.yed.graphics;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;

public class DropShadow implements LeafRenderable, YedConstants {
	public String color;
	public Integer offsetX;
	public Integer offsetY;

	@Override
	public void writeTo(ElementWriter w) {
  		if (color != null){
	  		w.startElement(Y, "DropShadow");
	 		w.writeAttribute("color", color);
	 		w.writeAttribute("offsetX", offsetX);
	 		w.writeAttribute("offsetY", offsetY);
	  		w.endElement();
  		}
	}
}
