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
