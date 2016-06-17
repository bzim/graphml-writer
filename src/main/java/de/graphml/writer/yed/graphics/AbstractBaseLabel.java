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
import de.graphml.writer.yed.style.Alignment;
import de.graphml.writer.yed.style.AutoSizePolicy;
import de.graphml.writer.yed.style.ModelName;
import de.graphml.writer.yed.style.ModelPosition;

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
