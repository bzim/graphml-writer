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

public class Path implements LeafRenderable, YedConstants {
	public Double sx=0d;
	public Double sy=0d;
	public Double tx=0d;
	public Double ty=0d;
	
	private List<Point>points;
	
	public static class Point{
		public Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
		public double x;
		public double y;
	}

	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "Path");
		w.writeAttribute("sx", sx);
		w.writeAttribute("sy", sy);
		w.writeAttribute("tx", tx);
		w.writeAttribute("ty", ty);
		if (points != null){
			for (Point point: points){
				w.startElement(Y, "Point");
				w.writeAttribute("x", point.x);
				w.writeAttribute("y", point.y);
				w.endElement();
			}
		}
		w.endElement();
	}
	public void addPoint(double x, double y){
		if (points == null){
			points = new ArrayList<>();
		}
		points.add(new Point(x,y));
	}
	
	public void clearPoints(){
		if (points != null){
			points.clear();
		}
	}
}
