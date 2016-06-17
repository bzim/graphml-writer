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

public enum ModelName {
	CUSTOM("custom"),
	CORNERS("corners"),
	INTERNAL("internal"),
	SANDWICH("sandwich"),
	EIGHT_POS("eight_pos"),
	EDGE_OPPOSITE("edge_opposite"),
	// edge models
	CENTERED("centered"),
	TWO_POS("two_pos"),
	THREE_CENTER("three_center"),
	SIX_POS("six_pos"),
	CENTER_SLIDER("center_slider"),
	SIDE_SLIDER("side_slider");
	public final String value;
	private ModelName(String value){
		this.value = value;
	}
}
