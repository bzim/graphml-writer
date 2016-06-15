package de.graphml.writer.yed.style;

public enum ShapeType {
	RECTANGLE("rectangle"),
	RECTANGLE3D("rectangle3d"),
	TRIANGLE("triangle"),
	ROUNDRECTANGLE("roundrectangle"),
	DIAMOND("diamond"),
	OCTAGON("octagon"),
	PARALLELOGRAM("parallelogram"),
	HEXAGON("hexagon"),
	ELLIPSE("ellipse"),
	TRAPEZOID("trapezoid"),
	TRAPEZOID2("trapezoid2");
	
	public final String value;
	ShapeType(final String value){
		this.value = value;
	}
}
