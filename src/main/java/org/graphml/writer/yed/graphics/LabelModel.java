package org.graphml.writer.yed.graphics;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;

public interface LabelModel extends LeafRenderable, YedConstants{
	void writeParameter(ElementWriter w);
}
