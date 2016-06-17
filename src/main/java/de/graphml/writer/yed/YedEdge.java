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

import de.graphml.writer.model.AbstractBaseEdge;
import de.graphml.writer.model.ElementWriter;
import de.graphml.writer.yed.graphics.EdgeGraphics;

public class YedEdge<T extends EdgeGraphics> extends AbstractBaseEdge {
	public final T edgeGraphics;

	public YedEdge(final T edgeGraphics) {
		this.edgeGraphics = edgeGraphics;
	}

	@Override
	public void writeTo(ElementWriter w) {
		w.startData(YedKeys.EDGE_GRAPHICS);
		edgeGraphics.writeTo(w);
		w.endElement();
	}
}
