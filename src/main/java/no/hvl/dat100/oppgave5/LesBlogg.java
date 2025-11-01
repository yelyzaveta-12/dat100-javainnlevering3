package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import no.hvl.dat100.oppgave2.Bilde;
import no.hvl.dat100.oppgave2.Tekst;
import no.hvl.dat100.oppgave3.Blogg;

public class LesBlogg {

    private static String TEKST = "TEKST";
    private static String BILDE = "BILDE";

    public static Blogg les(String mappe, String filnavn) {
        File file = new File((mappe == null || mappe.isEmpty()) ? "." : mappe, filnavn);
        if (!file.exists()) {
            return null;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            if (line == null) return null;

            int antall = Integer.parseInt(line.trim());
            if (antall < 0) return null;

            Blogg blogg = new Blogg(antall);

            for (int i = 0; i < antall; i++) {
                String type = br.readLine();
                if (type == null) return null;
                type = type.trim();

                String idLine = br.readLine(); if (idLine == null) return null;
                String bruker = br.readLine(); if (bruker == null) return null;
                String dato = br.readLine();   if (dato == null) return null;
                String likesLine = br.readLine(); if (likesLine == null) return null;

                int id = Integer.parseInt(idLine.trim());
                int likes = Integer.parseInt(likesLine.trim());

                if (TEKST.equals(type)) {
                    String tekst = br.readLine(); if (tekst == null) return null;
                    blogg.leggTil(new Tekst(id, bruker, dato, likes, tekst));
                } else if (BILDE.equals(type)) {
                    String tekst = br.readLine(); if (tekst == null) return null;
                    String url = br.readLine();   if (url == null) return null;
                    blogg.leggTil(new Bilde(id, bruker, dato, likes, tekst, url));
                } else {
                    return null;
                }
            }
            return blogg;

        } catch (IOException | NumberFormatException e) {
            return null;
        }
    }
}
