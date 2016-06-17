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

public class RotatedDiscreteEdgeLabelModel implements LabelModel {
	/** label placement near the middle of the edge, directly on the edge's path */
	public static final int	CENTER=128;
	/** allowed positions to the center of the edge's path */
	public static final int	CENTERED=128;
	/** label placement near the middle of the edge, left/above the edge's path */
	public static final int	HEAD=2;
	/** label placement near the source, directly on the edge's path */
	public static final int	SCENTER=64;
	/** label placement near the source, left/above the edge's path */
	public static final int	SHEAD=1;
	/**  allowed positions to a set of six positions beside the edge path */
	public static final int	SIX_POS=63;
	/** label placement near the source, right/below the edge's path */
	public static final int	STAIL=8;
	/** label placement near the middle of the edge, right/below the edge's path */
	public static final int	TAIL=16;
	/** label placement near the target, directly on the edge's path */
	public static final int	TCENTER=256;
	/** label placement near the target, left/above the edge's path */
	public static final int	THEAD=4;
	/**  positions to a set of three positions directly on the edge's path */
	public static final int	THREE_CENTER=448;
	/** label placement near the target, right/below the edge's path */
	public static final int	TTAIL=32;
	/** allowed positions to the two locations near the center of the edge, beside the edge path */
	public static final int	TWO_POS=18;

	public boolean autoRotationEnabled=true;
	public double angle=0d;
	public double distance;
	public int candidateMask=HEAD|TAIL;
	public boolean positionRelativeToSegment=false;
	public RotatedDiscreteEdgeLabelModelParameter parameter = new RotatedDiscreteEdgeLabelModelParameter();
	
	@Override
	public void writeTo(ElementWriter w) {
		w.startElement(Y, "RotatedDiscreteEdgeLabelModel");
		w.writeAttribute("angle", angle);
		w.writeAttribute("autoRotationEnabled", autoRotationEnabled);
		w.writeAttribute("candidateMask", candidateMask);
		w.writeAttribute("distance", distance);
		w.writeAttribute("positionRelativeToSegment", positionRelativeToSegment);
		w.endElement();

		// TODO Auto-generated method stub
		/* <y:RotatedDiscreteEdgeLabelModel 
		 * angle="0.0" 
		 * autoRotationEnabled="true" 
		 * candidateMask="18" 
		 * distance="10.0" 
		 * positionRelativeToSegment="false"/>
		 */
	}

	public static class RotatedDiscreteEdgeLabelModelParameter implements LeafRenderable, YedConstants{
		public ModelPosition position=ModelPosition.TWO_POS_HEAD;
		@Override
		public void writeTo(ElementWriter w) {
			w.startElement(Y, "RotatedDiscreteEdgeLabelModelParameter");
			w.writeAttribute("position", position.value);
			w.endElement();		
		}
	}
	
	@Override
	public void writeParameter(ElementWriter w) {
		parameter.writeTo(w);
	}

}
