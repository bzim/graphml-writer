package de.graphml.writer.yed.graphics;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;

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
