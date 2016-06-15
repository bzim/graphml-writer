package de.graphml.writer.model;

public abstract class AbstractBaseNode implements Node{
	public String description;
	public String url;
	@Override
	public void writeStart(ElementWriter w, String id) {
		w.startElement("node");
		w.writeAttribute("id", id);

		if (url != null){
			w.startData(DefaultKeys.URL_FOR_NODE);
			w.writeText(url);
			w.endElement();
		}
		
		if (description != null){
			w.startData(DefaultKeys.DESCRIPTION_FOR_NODE);
			w.writeText(description);
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
