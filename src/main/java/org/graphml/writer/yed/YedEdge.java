package org.graphml.writer.yed;

import org.graphml.writer.model.AbstractBaseEdge;
import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.graphics.EdgeGraphics;

public class YedEdge extends AbstractBaseEdge {
	public final EdgeGraphics edgeGraphics;

	public YedEdge(final EdgeGraphics edgeGraphics) {
		this.edgeGraphics = edgeGraphics;
	}

	@Override
	public void writeTo(ElementWriter w) {
		w.startData(YedKeys.EDGE_GRAPHICS);
		edgeGraphics.writeTo(w);
		w.endElement();
	}
}
