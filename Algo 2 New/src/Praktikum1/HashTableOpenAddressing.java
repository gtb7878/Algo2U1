package Praktikum1;

// Implementierung von Streuwerttabellen mit offener Adressierung.
class HashTableOpenAddressing implements HashTable
{
    private Object[][] tab;
    private HashSequence seq;
    private int saved_i = -1;
    // Streuwerttabelle mit Sondierungsfunktion s.
    public HashTableOpenAddressing (HashSequence s)
    {
        seq = s;
        tab = new Object[s.size()][2];
    }

    public int search(Object key)
    {
        for (int j = 0; j < seq.size(); j++)
        {
            int i = seq.first(key);

            if (tab[i][0] == null)
            {
                if (saved_i != -1) return saved_i;
                else return i;
            }

            if (tab[i][1] != null && saved_i == -1)
            {
                saved_i = i;
            }

            if (tab[i][0] != null) return i;
        }


    }



    @Override
    public boolean put(Object key, Object val)
    {
        return false;
    }

    @Override
    public Object get(Object key)
    {
        return null;
    }

    @Override
    public boolean remove(Object key)
    {
        return false;
    }

    @Override
    public void dump()
    {

    }
}
