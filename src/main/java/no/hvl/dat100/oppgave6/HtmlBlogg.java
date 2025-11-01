package no.hvl.dat100.oppgave6;

import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}
	
	@Override
	public String toString() {
        StringBuilder html = new StringBuilder();
        html.append("<html>\n");
        html.append("  <head>\n");
        html.append("    <meta charset=\"utf-8\">\n");
        html.append("    <title>DAT100 Blogg</title>\n");
        html.append("    <style>\n");
        html.append("      body { font-family: Arial, sans-serif; margin: 20px; }\n");
        html.append("      h2 { font-size: 1.1em; margin: 0; }\n");
        html.append("      p { margin: 6px 0 12px 0; }\n");
        html.append("      hr { border: 0; border-top: 1px solid #ccc; }\n        \n");
        html.append("    </style>\n");
        html.append("  </head>\n");
        html.append("  <body>\n");

        Innlegg[] samling = getSamling();
        for (int i = 0; i < getAntall(); i++) {
            html.append(samling[i].toHTML());
        }

        html.append("  </body>\n");
        html.append("</html>\n");
        return html.toString();
    }
}