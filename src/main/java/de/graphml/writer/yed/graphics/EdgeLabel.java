/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.graphml.writer.yed.graphics;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;
import de.graphml.writer.yed.style.ModelName;
import de.graphml.writer.yed.style.ModelPosition;

public class EdgeLabel extends AbstractBaseLabel implements LeafRenderable, YedConstants {
	private LabelModel labelModel;
	public boolean autoFlippingLabel;
	public Double distance=2.0;
	public Double ratio=0.5;
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
		if (autoFlippingLabel){
			w.writeAttribute("configuration", "AutoFlippingLabel");
		}
		w.writeAttribute("ratio", ratio);
		w.writeAttribute("distance", distance);
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
