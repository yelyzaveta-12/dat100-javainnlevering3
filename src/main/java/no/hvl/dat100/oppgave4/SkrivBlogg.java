package no.hvl.dat100.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


import no.hvl.dat100.oppgave3.*;

public class SkrivBlogg {

	public static boolean skriv(Blogg samling, String mappe, String filnavn) {

        PrintWriter pw = null;
        try {
            File dir = new File(mappe);
            if(!dir.exists()){
                dir.mkdir();
            }

            File file = new File(dir, filnavn);

            pw = new PrintWriter(new FileWriter(file));

            pw.print(samling.toString());
            return true;
        } catch (IOException e) {
            System.out.println("Feil: " + e.getMessage());
            return false;
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

	}
}
