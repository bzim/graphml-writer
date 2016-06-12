package org.graphml.writer.model;

public abstract class AbstractBaseEdge implements Edge{
	public String description;
	public String url;

	@Override
	public void writeStart(ElementWriter w, String id, String source, String target) {
		w.startElement("edge");
		w.writeAttribute("id", id);
		w.writeAttribute("source", source);
		w.writeAttribute("target", target);

		if (url != null){
			w.startData(DefaultKeys.URL_FOR_EDGE);
			w.writeText(url);
			w.endElement();
		}
		
		if (description != null){
			w.startData(DefaultKeys.DESCRIPTION_FOR_EDGE);
			w.writeText(url);
			w.endElement();
		}

		writeTo(w);
	}

	public abstract void writeTo(ElementWriter w);

	@Override
	public void writeEnd(ElementWriter w) {
		w.endElement();
	}

}
