package org.graphml.writer.yed.graphics;
import java.util.ArrayList;
import java.util.List;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;
import org.graphml.writer.yed.style.LineType;

public class PolyLineEdge implements EdgeGraphics, YedConstants{
	public Double sx=0d;
	public Double sy=0d;
	public Double tx=0d;
	public Double ty=0d;
	public Double lineWidth=1.0;
	public LineType lineType = LineType.LINE;
	public List<EdgeLabel> labels;

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "PolyLineEdge");

		w.startElement(Y, "Path");
		w.writeAttribute("sx", sx);
		w.writeAttribute("sy", sy);
		w.writeAttribute("tx", tx);
		w.writeAttribute("ty", ty);
		w.endElement();

		w.startElement(Y, "LineStyle");
		w.writeAttribute("color", "#000000");
		w.writeAttribute("type", lineType.value);
		w.writeAttribute("width", lineWidth);
		w.endElement();

		w.startElement(Y, "Arrows");
		w.writeAttribute("source", "none");
		w.writeAttribute("type", "line");
		w.writeAttribute("target", "standard");
		w.endElement();		
		
		if (labels != null){
			for (EdgeLabel label: labels){
				label.writeTo(w);
			}
		}
		
		w.startElement(Y, "BendStyle");
		w.writeAttribute("smoothed", false);
		w.endElement();		
		
		// <y:PolyLineEdge>
		// <y:Path sx="0.0" sy="0.0" tx="0.0" ty="0.0"/>
		// <y:LineStyle color="#000000" type="line" width="1.0"/>
		// <y:Arrows source="none" target="standard"/>
		// <y:BendStyle smoothed="false"/>
		// </y:PolyLineEdge>

		w.endElement();
	}
	
	public void addLabel(EdgeLabel label){
		if (labels == null){
			labels = new ArrayList<>();
		}
		labels.add(label);
	}
}
