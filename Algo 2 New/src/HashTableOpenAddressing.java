// Implementierung von Streuwerttabellen mit offener Adressierung.
class HashTableOpenAddressing implements HashTable
{
    private Element[] tab;
    //private int[][] marker;
    private HashSequence seq;
    private int saved_i;
    // Streuwerttabelle mit Sondierungsfunktion s.
    public HashTableOpenAddressing (HashSequence s)
    {
        seq = s;
        tab = new Element[s.size()];
        // [0] -> Löschmarkierung
        // [1] -> vorhanden / nicht vorhanden
        // marker = new int[s.size()][2];
    }


    // siehe Folie 42 -> Hilfsoperation
    public int search(Object key)
    {
        saved_i = -1;
        int i = seq.first(key); // 1.1

        for (int j = 0; j < seq.size(); j++) // 1
        {
            if (tab[i] == null) // 1.2
            {
                if (saved_i != -1) return saved_i;
                else return i;
            }

            if (tab[i].getMarker() && saved_i == -1) // 1.3
            {
                saved_i = i;
            }

            if (!tab[i].getMarker()) return i; // 1.4

            i = seq.next(); // 1.1
        }

        if (saved_i != -1) return saved_i; // 2

        return -1; // 3
    }



    @Override
    public boolean put(Object key, Object val)
    {
        Element Elem = new Element(key, val);
        int i = search(key);
        // System.out.println("Index " + i + " Key " + key.toString());

        if (i >= 0)
        {
            tab[i] = Elem;
            return true;
        }
        else return false;
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
            if (tab[j] != null)
            {
                System.out.println(j + " " + tab[j].getKey().toString() + " " + tab[j].getValue().toString());
            }
        }
    }

}
