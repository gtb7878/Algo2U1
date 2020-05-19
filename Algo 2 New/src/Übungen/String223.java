package Übungen;

// (Gedachter) Ausschnitt aus der Bibliotheksklasse java.lang.String
public class String223
{
    // Feld mit den einzelnen Zeichen der Zeichenkette.
    private char[] s;

    // Streuwert der Zeichenkette berechnen.
    public int hashCode()
    {
        // Die einzelnen Zeichen werden quasi als Ziffer einer
        // Zahl h mit Basis 31 interpretiert (obwohl es natürlich
        // mehr als 31 verschiedene Zeichen gibt).
        // Durch arithmetischen Überlauf, der in Java wohldefiniert
        // ist, können auch negative Werte entstehen.
        int h = 0;
        for (int i = 0; i < s.length; i++)
        {
            h = h * 31 + s[i];
        }
        return h;
    }
    // ......
}
