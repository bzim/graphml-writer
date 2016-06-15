package org.graphml.writer.yed;

import org.graphml.writer.model.AbstractBaseEdge;
import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.graphics.EdgeGraphics;

public class YedEdge<T extends EdgeGraphics> extends AbstractBaseEdge {
	public final T edgeGraphics;

	public YedEdge(final T edgeGraphics) {
		this.edgeGraphics = edgeGraphics;
	}

	@Override
	public void writeTo(ElementWriter w) {
		w.startData(YedKeys.EDGE_GRAPHICS);
		edgeGraphics.writeTo(w);
		w.endElement();
	}
}
