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
package de.graphml.writer.yed;

import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.model.Key;

public enum YedKeys implements Key{
	PORT_GRAPHICS("y1", "port", "yfiles.type", "portgraphics"),
	PORT_GEOMETRY("y2", "port", "yfiles.type", "portgeometry"),
	PORT_USERDATA("y3", "port", "yfiles.type", "portuserdata"),
	NODE_GRAPHICS("y4", "node", "yfiles.type", "nodegraphics"),
	RESOURCES_FOR_GRAPHML("y5", "graphml", "yfiles.type", "resources"),
	EDGE_GRAPHICS("y6", "edge", "yfiles.type", "edgegraphics");

	public final String id;
	public final String forName;
	public final String attrTypeName;
	public final String attrTypeValue;
	
	YedKeys(String id, String forName, String attrTypeName, String attrTypeValue){
		this.id = id;
		this.forName = forName;
		this.attrTypeName = attrTypeName;
		this.attrTypeValue = attrTypeValue;
	}
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void writeTo(ElementWriter w) {
		w.startElement("key");
		w.writeAttribute("id", id);
		w.writeAttribute("for", forName);
		w.writeAttribute(attrTypeName, attrTypeValue);
		w.endElement();
	}
}