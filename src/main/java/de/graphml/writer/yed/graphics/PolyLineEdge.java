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
import java.util.ArrayList;
import java.util.List;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.YedConstants;
import de.graphml.writer.yed.style.ArrowStyle;

public class PolyLineEdge implements EdgeGraphics, YedConstants{
	public Path path = new Path();
	public LineStyle lineStyle = new LineStyle();
	public List<EdgeLabel> labels;
	public ArrowStyle source = ArrowStyle.NONE;
	public ArrowStyle target = ArrowStyle.STANDARD;

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "PolyLineEdge");

		path.writeTo(w);
		lineStyle.writeTo(w);

		w.startElement(Y, "Arrows");
		w.writeAttribute("source", source.value);
		w.writeAttribute("type", "line");
		w.writeAttribute("target", target.value);
		w.endElement();		
		
		if (labels != null){
			for (EdgeLabel label: labels){
				label.writeTo(w);
			}
		}
		
		w.startElement(Y, "BendStyle");
		w.writeAttribute("smoothed", false);
		w.endElement();		
		
		w.endElement();
	}
	
	public void addLabel(EdgeLabel label){
		if (labels == null){
			labels = new ArrayList<>();
		}
		labels.add(label);
	}
}
