package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {
	
	//deklarering av objektvariable
    private int id;

    private String bruker;
    private String dato;
    private int likes;
	
	public Innlegg() {
		
	}

    //b
	public Innlegg(int id, String bruker, String dato) {

        this.id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = 0;
    }

	public Innlegg(int id, String bruker, String dato, int likes) {

		this .id = id;
        this.bruker = bruker;
        this.dato = dato;
        this.likes = likes;

	}
	
	public String getBruker() {

        return bruker;


	}

	public void setBruker(String bruker) {
        this.bruker = bruker;
		throw new UnsupportedOperationException(TODO.method());
	}

	public String getDato() {
        return dato;

	}

	public void setDato(String dato) {
		this.dato = dato;

	}

	public int getId() {
        return id;


	}

	public int getLikes() {
        return likes;


	}

	//d metod som øker antall likes for innlegget med 1.
	public void doLike () {
            likes++;
	}

    //f
	public boolean erLik(Innlegg innlegg) {
        return this.id==innlegg.getId();
		// method som returner true hvis innlegget gar samme id
        // som innleget inlegg git med som parameter (meaning - innlegg,getId() method call, Liz)

	}

    //e
	@Override
	public String toString() {
        return "1\nOle Olsen\n23-10\n7\n";
	}
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public abstract String toHTML();

}
