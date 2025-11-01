package no.hvl.dat100.oppgave3;

import no.hvl.dat100.oppgave1.*;

public class Blogg {

    // innleggtabell som er en referanse tabell av Innlegg-objekt
	private Innlegg[] innleggtabell;
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
        for(int i = 0; i < nesteledig; i++) {
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
        if(finnes(innlegg)) return false;
        if(!ledigPlass()) return false;

        innleggtabell[nesteledig++] = innlegg;
        return true;
	}

    //i
    @Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nesteledig).append("\n");
        for(int i = 0; i < nesteledig; i++) {
            sb.append(innleggtabell[i].toString());
        }
        return sb.toString();
	}

    public void utvid() {
        Innlegg[] ny = new Innlegg[innleggtabell.length * 2];
        for(int i = 0; i < nesteledig; i++) ny[i] = innleggtabell[i];
        innleggtabell = ny;
    }

    //k
    public boolean leggTilUtvid(Innlegg innlegg) {
        if (finnes(innlegg)) return false;
        if (!ledigPlass()) utvid();
        innleggtabell[nesteledig++] = innlegg;
        return true;
    }

    public boolean slett(Innlegg innlegg) {
        int idx = finnInnlegg(innlegg);
        if (idx == -1) return false;
        // shift venstre
        for (int i = idx; i < nesteledig - 1; i++) {
            innleggtabell[i] = innleggtabell[i + 1];
        }
        innleggtabell[--nesteledig] = null;
        return true;
    }

    public int[] search(String user, String ord) {
        // Teller først treff
        int count = 0;
        for (int i = 0; i < nesteledig; i++) {
            Innlegg in = innleggtabell[i];
            boolean userMatch = in.getBruker().equals(user);
            boolean textMatch = in.toString().contains(ord); // enkel variant
            if (userMatch && textMatch) count++;
        }
        int[] ids = new int[count];
        int k = 0;
        for (int i = 0; i < nesteledig; i++) {
            Innlegg in = innleggtabell[i];
            boolean userMatch = in.getBruker().equals(user);
            boolean textMatch = in.toString().contains(ord);
            if (userMatch && textMatch) ids[k++] = in.getId();
        }
        return ids;
    }
}