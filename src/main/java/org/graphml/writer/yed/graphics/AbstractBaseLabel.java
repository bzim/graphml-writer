package org.graphml.writer.yed.graphics;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.style.Alignment;
import org.graphml.writer.yed.style.AutoSizePolicy;
import org.graphml.writer.yed.style.ModelName;
import org.graphml.writer.yed.style.ModelPosition;

public abstract class AbstractBaseLabel {
	public Integer fontSize = 12;
	public String fontFamily = "Dialog";
	public String fontStyle = "plain";
	public String textColor = "#000000";
	public Alignment alignment = Alignment.CENTER;
	public Double width;
	public Double height;
	public Double x;
	public Double y;
	public String lineColor;
	public String backgroundColor;
	public boolean visible = true;
	public ModelName modelName = ModelName.CUSTOM;
	public ModelPosition modelPosition;
	public AutoSizePolicy autoSizePolicy = AutoSizePolicy.CONTENT;
	public Double rotationAngle;
	public Integer topInset;
	public Integer rightInset;
	public Integer bottomInset;
	public Integer leftInset;

	public String text;

	protected void writerAttributes(ElementWriter w) {
		w.writeAttribute("alignment", alignment.value);
		w.writeAttribute("fontFamily", fontFamily);
		w.writeAttribute("fontSize", fontSize);
		w.writeAttribute("fontStyle", fontStyle);

		if (backgroundColor == null) {
			w.writeAttribute("hasBackgroundColor", "false");
		}
		if (lineColor == null) {
			w.writeAttribute("hasLineColor", "false");
		}
		w.writeAttribute("modelName", modelName.value);
		if (modelPosition != null){
			w.writeAttribute("modelPosition", modelPosition.value);
		}
		w.writeAttribute("width", width);
		w.writeAttribute("height", height);
		w.writeAttribute("x", x);
		w.writeAttribute("y", y);
		w.writeAttribute("textColor", textColor);
		w.writeAttribute("visible", visible);
		w.writeAttribute("autoSizePolicy", autoSizePolicy.value);
		w.writeAttribute("rotationAngle", rotationAngle);
		
		w.writeAttribute("topInset", topInset);
		w.writeAttribute("rightInset", rightInset);
		w.writeAttribute("bottomInset", bottomInset);
		w.writeAttribute("leftInset", leftInset);
		if (text == null || text.isEmpty()){
			w.writeAttribute("hasText", false);
		}
	}
}
