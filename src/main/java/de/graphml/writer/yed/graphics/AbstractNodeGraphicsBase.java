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
import de.graphml.writer.yed.style.BorderStyle;

public class AbstractNodeGraphicsBase {
	public Geometry geometry = new Geometry();
	public Shape shape= new Shape();
	public DropShadow dropShadow= new DropShadow();
	public Fill fill = new Fill();
	public List<NodeLabel> labels;
	public BorderStyle borderStyle = new BorderStyle();
	
	protected void writeGraphics(ElementWriter w) {
		geometry.writeTo(w);
		fill.writeTo(w);
		borderStyle.writeTo(w);
		if (labels != null){
			for (NodeLabel label: labels){
				label.writeTo(w);
			}
		}
		shape.writeTo(w);
  		dropShadow.writeTo(w);
	}
	
	public void addLabel(NodeLabel label){
		if (labels == null){
			labels = new ArrayList<>();
		}
		labels.add(label);
	}
	
	public NodeLabel firstLabel(){
		if (hasLabels()){
			return labels.get(0);
		}
		throw new RuntimeException("no label defined on node graphics");
	}

	public boolean hasLabels() {
		return labels != null && !labels.isEmpty();
	}
	
	public void withLabelText(String text) {
		if (!hasLabels()){
			addLabel(new NodeLabel(text));
		}else{
			firstLabel().text = text;
		}
	}
}
