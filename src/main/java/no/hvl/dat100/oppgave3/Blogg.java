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


    //j som oppretter en ny tabell av innlegg-objekt
    // som er dobbelt så stor og flytter elementene over i denne.
	public void utvid() {
        Innlegg[] ny = new Innlegg[innleggtabell.length * 2];
        for(int i=0; i<nesteledig; i++) {
            ny[i] = innleggtabell[i];
        }
        innleggtabell = ny;
	}

    //k
	public boolean leggTilUtvid(Innlegg innlegg) {
        if (innlegg == null) return false;
        if (finnes(innlegg)) return false;
        if(!ledigPlass()) {
            utvid();
        }
		return leggTil(innlegg);
	}

    //l
	public boolean slett(Innlegg innlegg) {

		int index = finnInnlegg(innlegg);
        if (index == -1) return false;

        for(int i = index, i < nesteledig -1; i++){
            innleggtabell[i] = innleggtabell[i + 1];
        }
        innleggtabell[nesteledig -1] = null;
        nesteledig--;
        return true;
	}

    //m
	public int[] search(String keyword) {
		


	}
}