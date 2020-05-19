package Übungen;

import java.io.*;

// Listenelement.
class Elem212
{
    String word;    // Wort.
    int count;      // Häufigkeit.
    Elem212 next;      // Verkettung.
    Elem212(String w, Elem212 n)
    {
        word = w;
        count = 1;
        next = n;
    }
}


class WordCount212
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader r =  // Standardeingabe als BufferedReader.
                new BufferedReader(new InputStreamReader(System.in));
        Elem212 h = null;  // Listenanfang (head).
        String w;   // Aktuelles Wort.

        // Eingabe zeilenweise lesen und verarbeiten.
        input:  // readLine kann IOException werfen.
        while ((w = r.readLine()) != null)
        {
            // Element e mit Wort w suchen.
            for (Elem212 e = h; e != null; e = e.next)
            {
                // Wenn vorhanden, Zähler erhöhen.
                if (e.word.equals(w))
                {
                    e.count++;
                    continue input;
                }
            }
            // Andernfalls neues Element mit Zähler 1 erzeugen.
            h = new Elem212(w, h);
        }

        // Ausgabe produzieren.
        for (Elem212 e = h; e != null; e = e.next)
        {
            System.out.println(e.count + " " + e.word);
        }
    }
}
