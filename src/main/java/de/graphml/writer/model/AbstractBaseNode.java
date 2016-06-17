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

public abstract class AbstractBaseNode implements Node{
	public String description;
	public String url;
	@Override
	public void writeStart(ElementWriter w, String id) {
		w.startElement("node");
		w.writeAttribute("id", id);

		if (url != null){
			w.startData(DefaultKeys.URL_FOR_NODE);
			w.writeText(url);
			w.endElement();
		}
		
		if (description != null){
			w.startData(DefaultKeys.DESCRIPTION_FOR_NODE);
			w.writeText(description);
			w.endElement();
		}

		writeTo(w);
	}

	public abstract void writeTo(ElementWriter w);

	@Override
	public void writeEnd(ElementWriter w) {
		w.endElement();
	}

}
