package Übungen;

// Punkt im zweidimensionalen Raum.
class Point222
{
    // Koordinaten des Punkts.
    public final double x, y;

    // Punkt mit Koordinaten x und y konstruieren.
    public Point222 (double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    // Zeichenketten-Darstellung des aktuellen Objekts liefern.
    public String toString ()
    {
        return "(" + x + ", " + y + ")";
    }

    // Vergleich des aktuellen Objekts this (mit Typ Point)
    // mit irgendeinem anderen Objekt other (mit beliebigem
    // dynamischen Typ).
    public boolean equals (Object other)
    {
        // 1. Wenn other kein Point ist, kann es nicht gleich this sein.
        if (!(other instanceof Point222)) return false;

        // 2. Andernfalls kann other in Point that umgewandelt werden.
        Point222 that = (Point222) other;

        // 3. Dann können this und that inhaltlich verglichen werden.
        return this.x == that.x && this.y == that.y;
    }

    // Streuwert für das aktuelle Objekt liefern.
    public int hashCode ()
    {
        // Für Punkte, die gemäß equals gleich sind,
        // erhält man den gleichen Streuwert.
        // return (int)(x + y);
        // Oder besser:
        return (int)x << 16 | (int)y;
    }
}
