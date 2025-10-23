package no.hvl.dat100.oppgave3;


import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import java.util.ArrayList;

public class Blogg {

    // innleggtabell som er en referanse tabell av Innlegg-objekt
	private Innlegg[] innleggtabell;

    //nesteledig som angir antall Innlegg-objekt som er lagret i tabellen og dermed neste ledige posisjon i tabellen
    private int nesteledig;

	public Blogg() {
        this(20);
	}

	public Blogg(int lengde) {
        innleggtabell = new Innlegg[lengde];
        nesteledig = 0;


	}

	public int getAntall() {
        return nesteledig;
	}
	
	public Innlegg[] getSamling() {
        return innleggtabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {


        //som returnerer indeks (posisjon) i tabellen for et innlegg i samlingen med samme id
        // som parameteren innlegg (om en slik finnes) og -1 ellers.
        // Bruk erLik-metoden for Innlegg-objekt i implementasjonen

        if(innlegg == null) return -1;

        for(int i=0; i<nesteledig; i++) {
            if(innleggtabell[i].erLik(innlegg)){
                return i;
            }
        }
        return -1;
	}

	public boolean finnes(Innlegg innlegg) {



	}

	public boolean ledigPlass() {
		throw new UnsupportedOperationException(TODO.method());

	}
	
	public boolean leggTil(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
	}
	
	public String toString() {



	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {



	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {


		
	}
	
	public boolean slett(Innlegg innlegg) {
		

	}
	
	public int[] search(String keyword) {
		


	}
}