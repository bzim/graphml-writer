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
