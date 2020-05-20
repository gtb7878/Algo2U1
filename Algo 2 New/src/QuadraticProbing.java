// Sondierungssequenz gemäß quadratischer Sondierung
// (Implementierung nur mit Ganzzahlarithmetik).
class QuadraticProbing extends AbstractHashSequence
{
    private int j, hash;
    // Quadratische Sondierung mit Streuwertfunktion f.
    public QuadraticProbing (HashFunction f)
    {
        super(f);
    }

    @Override
    public int first(Object key)
    {
        j = 0;
        return prev = hash = func.compute(key);
    }

    @Override
    public int next()
    {
        j++;
        return prev = (hash + ((j + j*j) / 2)) % size();
    }
}
