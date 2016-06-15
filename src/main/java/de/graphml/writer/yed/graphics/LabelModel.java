package de.graphml.writer.yed.graphics;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;

public interface LabelModel extends LeafRenderable, YedConstants{
	void writeParameter(ElementWriter w);
}
