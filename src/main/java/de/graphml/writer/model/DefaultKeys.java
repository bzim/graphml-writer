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
package de.graphml.writer.model;

public enum DefaultKeys implements Key{
	DESCRIPTION_FOR_GRAPH("d0", "graph", "attr.name", "Beschreibung", "attr.type", "string"),
	URL_FOR_NODE("d4", "node", "attr.name", "url", "attr.type", "string"),
	DESCRIPTION_FOR_NODE("d5", "node", "attr.name", "description", "attr.type", "string"),
	URL_FOR_EDGE("d8", "edge", "attr.name", "url", "attr.type", "string"),
	DESCRIPTION_FOR_EDGE("d9", "edge", "attr.name", "description", "attr.type", "string");
	
	public final String id;
	public final String forName;
	public final String attrName;
	public final String attrValue;
	public final String attrTypeName;
	public final String attrTypeValue;
	
	DefaultKeys(String id, String forName, String attrName, String attrValue, String attrTypeName, String attrTypeValue){
		this.id = id;
		this.forName = forName;
		this.attrName= attrName;
		this.attrValue = attrValue;
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
		if (attrName != null){
			w.writeAttribute(attrName, attrValue);
		}
		w.endElement();
	}
}