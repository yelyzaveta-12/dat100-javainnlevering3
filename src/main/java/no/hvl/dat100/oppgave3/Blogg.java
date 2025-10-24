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

    //c
	public int getAntall() {
        return nesteledig;
	}

    //d
	public Innlegg[] getSamling() {
        return innleggtabell;
	}

    //e
	public int finnInnlegg(Innlegg innlegg) {

        //som returnerer indeks (posisjon) i tabellen for et innlegg i samlingen med samme id
        // som parameteren innlegg (om en slik finnes) og -1 ellers.
        // Bruk erLik-metoden for Innlegg-objekt i implementasjonen

        if(innlegg == null) return -1;

        for(int i=0; i<nesteledig; i++) {
            if(innleggtabell[i].erLik(innlegg)){ //oppgave1 erLik
                return i;
            }
        }
        return -1;
	}

    //f
	public boolean finnes(Innlegg innlegg) {
        return finnInnlegg(innlegg) != -1;
	}

    //g
	public boolean ledigPlass() {
		return nesteledig < innleggtabell.length;
	}

    //h
	public boolean leggTil(Innlegg innlegg) {

        if(innlegg == null) return false;
        if(finnes(innlegg)) return false;
        if(!ledigPlass()) return false;

        innleggtabell[nesteledig] = innlegg;
        nesteledig++;
        return true;
	}

    //i
    @Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nesteledig).append("\n");
        for(int i=0; i<nesteledig; i++) {
            sb.append(innleggtabell[i].toString());
        }
        return sb.toString();
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