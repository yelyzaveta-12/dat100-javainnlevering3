package no.hvl.dat100.oppgave4;

import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

    public static boolean skriv(Blogg samling, String mappe, String filnavn) {
        try {
            File dir = new File(mappe);
            if (!dir.exists() && !dir.mkdirs()) {
                return false; // klarte ikke lage mappe
            }

            File file = new File(dir, filnavn);
            try (PrintWriter out = new PrintWriter(new FileWriter(file))) {
                out.print(samling.toString());
            }
            return true;

        } catch (IOException e) {
            // valgfritt: logg e.getMessage()
            return false;
        }
    }
}
