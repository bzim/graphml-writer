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
import de.graphml.writer.yed.style.ModelPosition;

public class SmartEdgeLabelModel implements LabelModel {
	public boolean autoRotationEnabled;
	public double defaultAngle=0d;
	public double defaultDistance=10d;
	public SmartEdgeLabelModelParameter parameter = new SmartEdgeLabelModelParameter();
	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "SmartEdgeLabelModel");
		w.writeAttribute("autoRotationEnabled", autoRotationEnabled);
		w.writeAttribute("defaultAngle", defaultAngle);
		w.writeAttribute("defaultDistance", defaultDistance);
		w.endElement();
	}

	@Override
	public void writeParameter(ElementWriter w){
		parameter.writeTo(w);
	}
	
	public static class SmartEdgeLabelModelParameter implements LeafRenderable, YedConstants{
		public double angle=0d;
		public double distance=30d;
		public boolean distanceToCenter=true;
		public ModelPosition position=ModelPosition.RIGHT;
		public double ratio=0.5;
		public int segment=0;
		@Override
		public void writeTo(ElementWriter w) {
			w.startElement(Y, "SmartEdgeLabelModelParameter");
			w.writeAttribute("angle", angle);
			w.writeAttribute("distance", distance);
			w.writeAttribute("distanceToCenter", distanceToCenter);
			w.writeAttribute("position", position.value);
			w.writeAttribute("ratio", ratio);
			w.writeAttribute("segment", segment);
			w.endElement();
		}
	}
}
