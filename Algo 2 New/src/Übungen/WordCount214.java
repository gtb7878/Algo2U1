package Übungen;

import java.io.*;

// Tabellenelement.
class Elem214
{
    String word;    // Wort.
    int count;  // Häufigkeit.

    Elem214 (String w)
    {
        word = w;
        count = 1;
    }
}

// Hauptprogramm
class WordCount214
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader r =   // Standardeingabe als BufferedReader.
            new BufferedReader(new InputStreamReader(System.in));
        Elem214[] tab = new Elem214[1000];  // Tabelle.
        String w;   // Aktuelles Wort.

        // Eingabe zeilenweise lesen und verarbeiten.
        // readLine kann IOException werfen.
        while ((w = r.readLine()) != null)
        {
            // Streuwert des Worts als Index in die Tabelle verwenden.
            int i = w.hashCode() % tab.length;
            if (i < 0) i = -i;
            Elem214 e = tab[i];
            if (e != null)
            {
                // Wenn dort bereits ein Element ist, Zähler erhöhen.
                e.count++;
            }
            else
            {
                // Andernfalls neues Element mit Zähler 1 erzeugen.
                tab[i] = new Elem214(w);
            }
        }

        // Ausgabe produzieren.
        for (Elem214 e : tab) if (e != null)
        {
            System.out.println(e.count + " " + e.word);
        }
    }
}
