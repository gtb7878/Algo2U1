// Implementierung von Streuwerttabellen mit Verkettung.
class HashTableChaining implements HashTable
{
    private MyLinkedList[] tab;
    private  HashFunction func;
    // Streuwerttabelle mit Streuwertfunktion f.
    public HashTableChaining (HashFunction f)
    {
        func = f;
        tab = new MyLinkedList[f.size()];
    }

    @Override
    public boolean put(Object key, Object val)
    {
        if (key == null || val == null) return false;
        int i = func.compute(key);

        if (tab[i] == null) tab[i] = new MyLinkedList();
        tab[i].insert(key, val);
        return true;
    }

    @Override
    public Object get(Object key)
    {
        if (key == null) return null;
        int i = func.compute(key);
        if (tab[i] == null) return null;
        MyLinkedList.Node x = tab[i].search(key);
        if (x != null) return x.getValue();
        else return null;
    }

    @Override
    public boolean remove(Object key)
    {
        if (key == null) return false;
        int i = func.compute(key);
        if (tab[i] == null) return false;
        else return tab[i].delete(key);
    }

    @Override
    public void dump()
    {
        for (int j = 0; j < func.size(); j++)
        {
            if (tab[j] != null)
            {
                tab[j].print(j);
            }
        }
    }
}
