// Implementierung von Streuwerttabellen mit offener Adressierung.
class HashTableOpenAddressing implements HashTable
{
    private Element[][] tab;
    private HashSequence seq;
    private int saved_i;
    // Streuwerttabelle mit Sondierungsfunktion s.
    public HashTableOpenAddressing (HashSequence s)
    {
        seq = s;
        tab = new Element[s.size()][2];
    }


    // siehe Folie 42 -> Hilfsoperation
    public int search(Object key)
    {
        saved_i = -1;
        int i = seq.first(key); // 1.1

        for (int j = 0; j < seq.size(); j++) // 1
        {
            if (tab[i][0] == null) // 1.2
            {
                if (saved_i != -1) return saved_i;
                else return i;
            }

            if (tab[i][1] != null && saved_i == -1) // 1.3
            {
                saved_i = i;
            }

            if (tab[i][0] != null) return i; // 1.4

            i = seq.next(); // 1.1
        }

        if (saved_i != -1) return saved_i; // 2

        return -1; // 3
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
        for (int j = 0; j < seq.size(); j++)
        {
            if (tab[j][0] != null)
            {
                System.out.println(j + " " + tab[j][0].getKey().toString() + " " + tab[j][0].getValue().toString());
            }
        }
    }

}
