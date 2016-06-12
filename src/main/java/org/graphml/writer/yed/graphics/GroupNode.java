package org.graphml.writer.yed.graphics;
import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;

public class GroupNode extends AbstractNodeGraphicsBase implements LeafRenderable, YedConstants{

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "GroupNode");
		
		writeGraphics(w);
		
  		w.endElement(); // group node
	}
	/*
    <y:Shape type="rectangle"/>
    <y:DropShadow color="#D2D2D2" offsetX="4" offsetY="4"/>
    <y:State closed="false" closedHeight="50.0" closedWidth="50.0" innerGraphDisplayEnabled="false"/>
    <y:Insets bottom="15" bottomF="15.0" left="15" leftF="15.0" right="15" rightF="15.0" top="15" topF="15.0"/>
    <y:BorderInsets bottom="0" bottomF="0.0" left="0" leftF="0.0" right="0" rightF="0.0" top="0" topF="0.0"/>		
*/
}