package no.hvl.dat100.oppgave6;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.Innlegg;
import no.hvl.dat100.oppgave3.Blogg;

public class HtmlBlogg extends Blogg {

	public HtmlBlogg() {
		super();
	}

	
	private static String HTMLPREFIX = 
			"<html>\n\t<head>\n\t\t<title>DAT100 Blogg</title>\n\t</head>\n\t<body>\n";
	
	private static String HTMLPOSTFIX = 
			"\t</body>\n</html>";
	
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
        for (Innlegg innlegg : samling) {
            if (innlegg == null) break;
            html.append(innlegg.toHTML());
        }

        html.append("  </body>\n");
        html.append("</html>\n");
        return html.toString();
    }
}