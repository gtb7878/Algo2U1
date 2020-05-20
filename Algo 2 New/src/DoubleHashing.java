// Sondierungssequenz gemäß doppelter Streuung.
class DoubleHashing extends AbstractHashSequence
{
    // Zweite Streuwertfunktion.
    private HashFunction func2;
    private int j, hash1, hash2;

    // Doppelte Streuung mit Streuwertfunktionen f1 und f2.
    public DoubleHashing (HashFunction f1, HashFunction f2)
    {
        super(f1);
        func2 = f2;
    }

    @Override
    public int first(Object key)
    {
        j = 0;
        hash2 = func2.compute(key);
        return prev = hash1 = func.compute(key);
    }

    @Override
    public int next()
    {
        j++;
        return prev = (hash1 + j * hash2) % size();
    }
}
