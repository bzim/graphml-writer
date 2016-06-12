package org.graphml.writer.yed.graphics;
import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;

public class ShapeNode extends AbstractNodeGraphicsBase implements NodeGraphics, YedConstants{

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "ShapeNode");
		
		writeGraphics(w);
		
  		w.endElement(); // shape node
	}
	
	public static ShapeNode asRectangle(double x, double y, double width, double height, String text){
		ShapeNode nodeGraphics = new ShapeNode();
		nodeGraphics.geometry.x = x;
		nodeGraphics.geometry.y = y;
		nodeGraphics.geometry.width = width;
		nodeGraphics.geometry.height = height;
		nodeGraphics.label.text = text;
		return nodeGraphics;
	}	

	public static ShapeNode asRectangle(double width, double height, String text){
		ShapeNode nodeGraphics = new ShapeNode();
		nodeGraphics.geometry.width = width;
		nodeGraphics.geometry.height = height;
		nodeGraphics.label.text = text;
		return nodeGraphics;
	}	
}