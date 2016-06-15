package de.graphml.writer.yed;

import de.graphml.writer.model.AbstractBaseNode;
import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.graphics.NodeGraphics;

public class YedNode<T extends NodeGraphics> extends AbstractBaseNode {
	public final T nodeGraphics;
	
	public YedNode(final T nodeGraphics){
		this.nodeGraphics = nodeGraphics;
	}
	@Override
	public void writeTo(ElementWriter w) {
		w.startData(YedKeys.NODE_GRAPHICS);
		this.nodeGraphics.writeTo(w);		
  		w.endElement(); 
	}
}
