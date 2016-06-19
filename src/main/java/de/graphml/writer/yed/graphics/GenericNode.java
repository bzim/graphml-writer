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

public class GenericNode extends AbstractNodeGraphicsBase implements NodeGraphics, YedConstants{
	public enum Configuration{
		FLOWCHART_DIRECT_DATA("com.yworks.flowchart.directData"),
		FLOWCHART_PROCESS("com.yworks.flowchart.process"),
		FLOWCHART_DATABASE("com.yworks.flowchart.dataBase"),
		FLOWCHART_DECISION("com.yworks.flowchart.decision"),
		FLOWCHART_DOCUMENT("com.yworks.flowchart.document"),
		FLOWCHART_START1("com.yworks.flowchart.start1"),
		FLOWCHART_START2("com.yworks.flowchart.start2"),
		FLOWCHART_DATA("com.yworks.flowchart.data"),
		FLOWCHART_PREDEFINED_PROCESS("com.yworks.flowchart.predefinedProcess"),
		FLOWCHART_STORED_DATA("com.yworks.flowchart.storedData"),
		FLOWCHART_INTERNAL_STORAGE("com.yworks.flowchart.internalStorage"),
		FLOWCHART_SEQUENTIAL_DATA("com.yworks.flowchart.sequentialData"),
		FLOWCHART_MANUAL_INPUT("com.yworks.flowchart.manualInput"),
		FLOWCHART_CARD("com.yworks.flowchart.card"),
		FLOWCHART_PAPER_TYPE("com.yworks.flowchart.paperType"),
		FLOWCHART_CLOUD("com.yworks.flowchart.cloud"),
		FLOWCHART_DELAY("com.yworks.flowchart.delay"),
		FLOWCHART_DISPLAY("com.yworks.flowchart.display"),
		FLOWCHART_MANUAL_OPERATION("com.yworks.flowchart.manualOperation"),
		FLOWCHART_PREPARATION("com.yworks.flowchart.preparation"),
		FLOWCHART_LOOP_LIMIT("com.yworks.flowchart.loopLimit"),
		FLOWCHART_LOOP_LIMIT_END("com.yworks.flowchart.loopLimitEnd"),
		FLOWCHART_TERMINATOR("com.yworks.flowchart.terminator"),
		FLOWCHART_ON_PAGE_REFERENCE("com.yworks.flowchart.onPageReference"),
		FLOWCHART_OFF_PAGE_REFERENCE("com.yworks.flowchart.offPageReference"),
		FLOWCHART_ANNOTATION("com.yworks.flowchart.annotation"),
		FLOWCHART_USER_MESSAGE("com.yworks.flowchart.userMessage"),
		FLOWCHART_NETWORK_MESSAGE("com.yworks.flowchart.networkMessage");
		public final String value;
		private Configuration(String value){
			this.value = value;
		}
	}
	
	public Configuration configuration;
	
	public GenericNode(){
		this.geometry.width = 80d;
		this.geometry.height = 40d;
	}

	public GenericNode(Configuration configuration) {
		this();
		this.configuration = configuration;
	}

	public GenericNode withConfiguration(Configuration configuration){
		this.configuration = configuration;
		return this;
	}
	
	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "GenericNode");
		w.writeAttribute("configuration", configuration.value);
		writeGraphics(w);
		
  		w.endElement(); // shape node
	}

	public static GenericNode as(Configuration configuration, String text) {
		GenericNode
			node = new GenericNode(configuration);
		node.addLabel(new NodeLabel(text));
		return node;
	}

	public GenericNode withConfigurationAndLabelText(Configuration configuration, String text) {
		withConfiguration(configuration);
		withLabelText(text);	
		return this;
	}
}