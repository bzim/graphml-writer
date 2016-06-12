package org.graphml.writer.yed.graphics;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.style.BorderStyle;

public class AbstractNodeGraphicsBase {
	public Geometry geometry = new Geometry();
	public Shape shape= new Shape();
	public DropShadow dropShadow= new DropShadow();
	public Fill fill = new Fill();
	public NodeLabel label = new NodeLabel();
	public BorderStyle borderStyle = new BorderStyle();
	
	protected void writeGraphics(ElementWriter w) {
		geometry.writeTo(w);
		fill.writeTo(w);
		borderStyle.writeTo(w);
		label.writeTo(w);
		shape.writeTo(w);
  		dropShadow.writeTo(w);
	}
}
