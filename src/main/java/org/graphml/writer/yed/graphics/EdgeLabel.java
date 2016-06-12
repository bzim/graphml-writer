package org.graphml.writer.yed.graphics;

import org.graphml.writer.model.ElementWriter;
import org.graphml.writer.yed.YedConstants;
import org.graphml.writer.yed.style.ModelName;
import org.graphml.writer.yed.style.ModelPosition;

public class EdgeLabel extends AbstractBaseLabel implements LeafRenderable, YedConstants {
	private LabelModel labelModel;
	public EdgeLabel(){
	}
	public EdgeLabel(String text){
		this.text = text;
	}
	
	public void setLabelModel(LabelModel labelModel){
		this.labelModel = labelModel;
		this.modelName = ModelName.CUSTOM;
	}
	@Override
	public void writeTo(ElementWriter w) {
		if (text == null) {
			return;
		}
		w.startElement(Y, "EdgeLabel");
		writerAttributes(w);
		w.writeAttribute("preferredPlacement", "anywhere");
		w.writeAttribute("configuration", "AutoFlippingLabel");
		w.writeAttribute("ratio", "0.5");
		w.writeAttribute("distance", "2.0");
		w.writeText(text);
		if (labelModel != null){
			w.startElement(Y, "LabelModel");
			labelModel.writeTo(w);
			w.endElement();
		}
		
		w.startElement(Y, "ModelParameter");
		if (labelModel != null){
			labelModel.writeParameter(w);
		}
		w.endElement();

		w.endElement();
	}

	public static EdgeLabel centered(String text) {
		return withModelAndPosition(text, ModelName.CENTERED, ModelPosition.CENTER);
	}
	public static EdgeLabel sourceCenter(String text) {
		return withModelAndPosition(text, ModelName.THREE_CENTER, ModelPosition.THREE_SOURCE_CENTER);
	}
	public static EdgeLabel sourceHead(String text) {
		return withModelAndPosition(text, ModelName.SIX_POS, ModelPosition.SIX_POS_SOURCE_HEAD);
	}
	public static EdgeLabel targetCenter(String text) {
		return withModelAndPosition(text, ModelName.THREE_CENTER, ModelPosition.THREE_TARGET_CENTER);
	}
	public static EdgeLabel targetHead(String text) {
		return withModelAndPosition(text, ModelName.SIX_POS, ModelPosition.SIX_POS_TARGET_HEAD);
	}
	public static EdgeLabel withModelAndPosition(String text, ModelName modelName, ModelPosition modelPosition) {
		EdgeLabel label = new EdgeLabel(text);
		label.modelName = modelName;
		label.modelPosition = modelPosition;
		return label;
	}
}
