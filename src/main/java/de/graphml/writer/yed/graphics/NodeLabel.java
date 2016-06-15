package de.graphml.writer.yed.graphics;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;

public class NodeLabel extends AbstractBaseLabel implements LeafRenderable, YedConstants {
	@Override
	public void writeTo(ElementWriter w) {
		if (text == null){
			return;
		}
		w.startElement(Y, "NodeLabel");
		writerAttributes(w);
		w.writeText(text);
		w.endElement();
	}
/*	
    <y:NodeLabel 
    borderDistance="0.0" 
    modelName="internal" 
    modelPosition="t" 
*/
}
