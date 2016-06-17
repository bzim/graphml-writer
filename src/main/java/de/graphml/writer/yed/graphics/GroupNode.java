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

public class GroupNode extends AbstractNodeGraphicsBase implements LeafRenderable, YedConstants{

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "GroupNode");
		
		writeGraphics(w);
		
  		w.endElement(); // group node
	}
	/*
    <y:Shape type="rectangle"/>
    <y:DropShadow color="#D2D2D2" offsetX="4" offsetY="4"/>
    <y:State closed="false" closedHeight="50.0" closedWidth="50.0" innerGraphDisplayEnabled="false"/>
    <y:Insets bottom="15" bottomF="15.0" left="15" leftF="15.0" right="15" rightF="15.0" top="15" topF="15.0"/>
    <y:BorderInsets bottom="0" bottomF="0.0" left="0" leftF="0.0" right="0" rightF="0.0" top="0" topF="0.0"/>		
*/
}