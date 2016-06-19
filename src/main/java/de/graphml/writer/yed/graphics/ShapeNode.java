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

public class ShapeNode extends AbstractNodeGraphicsBase implements NodeGraphics, YedConstants{

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "ShapeNode");
		
		writeGraphics(w);
		
  		w.endElement(); // shape node
	}
	
	public static ShapeNode asRectangle(double x, double y, double width, double height, String text){
		ShapeNode nodeGraphics = new ShapeNode();
		nodeGraphics.geometry.x = x;
		nodeGraphics.geometry.y = y;
		nodeGraphics.geometry.width = width;
		nodeGraphics.geometry.height = height;
		nodeGraphics.addLabel(new NodeLabel(text));
		return nodeGraphics;
	}	

	public static ShapeNode asRectangle(double width, double height, String text){
		ShapeNode nodeGraphics = new ShapeNode();
		nodeGraphics.geometry.width = width;
		nodeGraphics.geometry.height = height;
		nodeGraphics.addLabel(new NodeLabel(text));
		return nodeGraphics;
	}	
}