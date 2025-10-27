package no.hvl.dat100.oppgave5;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;
import no.hvl.dat100.oppgave2.*;
import no.hvl.dat100.oppgave3.*;

import javax.swing.JOptionPane;

public class LesBlogg {

	private static String TEKST = "TEKST";
	private static String BILDE = "BILDE";

	public static Blogg les(String mappe, String filnavn) {

            File file = new File((mappe == null || mappe.isEmpty()) ? "." : mappe, filnavn);
            if (!file.exists()) {
                System.out.println("Filen finnes ikke: " + file.getAbsolutePath());
                return null;
            }

            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line = br.readLine();
                if (line == null) return null;

                int antall = Integer.parseInt(line.trim());
                Blogg blogg = new Blogg(antall > 0 ? antall : 20);

                for (int i = 0; i < antall; i++) {
                    String type = br.readLine();
                    if (type == null) break;
                    type = type.trim();

                    // Common fields: id, bruker, dato, likes
                    String idLine = br.readLine();
                    String bruker = br.readLine();
                    String dato = br.readLine();
                    String likesLine = br.readLine();

                    int id = Integer.parseInt(idLine.trim());
                    int likes = Integer.parseInt(likesLine.trim());

                    if ("TEKST".equalsIgnoreCase(type)) {
                        String tekst = br.readLine();
                        Tekst t = new Tekst(id, bruker, dato, likes, tekst);
                        blogg.leggTil(t);
                    } else if ("BILDE".equalsIgnoreCase(type)) {
                        // For BILDE we expect tekst then url
                        String tekst = br.readLine();
                        String url = br.readLine();
                        Bilde b = new Bilde(id, bruker, dato, likes, tekst, url);
                        blogg.leggTil(b);
                    } else {
                        // Unknown type: try to be resilient (skip one line)
                        System.out.println("Ukjent innleggstype: " + type);
                    }
                }
                return blogg;

            } catch (IOException e) {
                System.out.println("IO-feil ved lesing: " + e.getMessage());
                return null;
            } catch (NumberFormatException nfe) {
                System.out.println("Feil tallformat i fil: " + nfe.getMessage());
                return null;
            }
        }
    }

