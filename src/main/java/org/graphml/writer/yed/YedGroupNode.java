package org.graphml.writer.yed;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.graphics.NodeGraphics;

public class YedGroupNode<T extends NodeGraphics> extends YedNode<T>  {
	
	public YedGroupNode(final T nodeGraphics){
		super(nodeGraphics);
	}
	
	@Override
	public void writeStart(ElementWriter w, String id) {
		w.startElement("node");
		w.writeAttribute("id", id);
		w.writeAttribute("yfiles.foldertype", "group");
		writeTo(w);
	}
}
