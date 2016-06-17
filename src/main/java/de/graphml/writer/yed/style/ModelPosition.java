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
package de.graphml.writer.yed.style;

public enum ModelPosition {
	NORTH("n"),
	NORTH_EAST("ne"),
	EAST("e"),
	SOUTH_EAST("se"),
	SOUTH("s"),
	SOUTH_WEST("se"),
	WEST("w"),
	NORTH_WEST("nw"),
	CENTER("c"),
	TOP("t"),
	BOTTOM("b"),
	LEFT("l"),
	RIGHT("r"),
	TOP_RIGHT("tr"),
	TOP_LEFT("tl"),
	BOTTOM_RIGHT("br"),
	BOTTOM_LEFT("bl"),
	
	TWO_POS_HEAD("head"),
	TWO_POS_TAIL("tail"),
	
	THREE_CENTER("center"),
	THREE_SOURCE_CENTER("scentr"),
	THREE_TARGET_CENTER("tcentr"),
	
	SIX_POS_HEAD("head"),
	SIX_POS_TAIL("tail"),
	SIX_POS_SOURCE_HEAD("shead"),
	SIX_POS_SOURCE_TAIL("stail"),
	SIX_POS_TARGET_HEAD("thead"),
	SIX_POS_TARGET_TAIL("ttail");
	public final String value;
	private ModelPosition(String value){
		this.value = value;
	}
}
