package Übungen;

import java.io.*;
import java.util.*;


// Hauptprogramm.
class WordCount215
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r =  // Standardeingabe als BufferedReader.
           new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> tab =  // Tabelle.
            new HashMap<String, Integer>(1000);
        String w;   // Aktuelles Wort.

        // Eingabe zeilenweise lesen und verarbeiten.
        // readLine kann IOException werfen.
        while ((w = r.readLine()) != null)
        {
            // Entweder einen neuen Eintrag mit Zähler 1 einfügen
            // oder den Zähler des vorhandenen Eintrags um 1 erhöhen.
            Integer c = tab.get(w);
            if (c == null) c = 0;
            tab.put(w, c + 1);
        }
        // Ausgabe produzieren.
        for (Map.Entry<String, Integer> e : tab.entrySet())
        {
            System.out.println(e.getValue() + " " + e.getKey());
        }
    }
}
