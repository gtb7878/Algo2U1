package Praktikum1;

// Sondierungssequenz gemäß doppelter Streuung.
class DoubleHashing extends AbstractHashSequence
{
    // Zweite Streuwertfunktion.
    private HashFunction func2;

    // Doppelte Streuung mit Streuwertfunktionen f1 und f2.
    public DoubleHashing (HashFunction f1, HashFunction f2)
    {
        super(f1);
        func2 = f2;
    }
}