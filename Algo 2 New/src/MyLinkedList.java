public class MyLinkedList
{

    // Knoten
    public class Node
    {
        private Object key, value;
        private Node prev, next;

        public Node (Object k, Object v)
        {
            key = k;
            value = v;
            prev = null;
            next = null;
        }

        public Object getValue()
        {
            return value;
        }

    }

    private Node head;

    // public MyLinkedList(Object k, Object v)
    // {
    //     head = new Node(k, v);
    // }

    public MyLinkedList()
    {
        head = null;
    }

    public Node search(Object k)
    {
        Node x = head;
        while (x != null && !x.key.equals(k))
        {
            x = x.next;
        }
        return x;
    }

    public void insert(Object k, Object v)
    {
        Node y = head;
        while (y != null && !y.key.equals(k))
        {
            y = y.next;
        }

        if (y == null) // einfügen
        {
            Node x = new Node(k, v);
            x.next = head;

            if (head != null) head.prev = x;
            head = x;
            x.prev = null;
        }
        else // ersetzen
        {
            y.value = v;
        }
    }

    public boolean delete(Object k)
    {
        Node x = head;
        while (x != null && !x.key.equals(k))
        {
            x = x.next;
        }
        if (x == null) return false;

        if (x.prev != null) x.prev.next = x.next;
        else head = x.next;

        if (x.next != null) x.next.prev = x.prev;

        return true;
    }

    public void print(int index)
    {
        Node x = head;
        while (x != null)
        {
            System.out.println(index + " " + x.key + " " + x.value);
            x = x.next;
        }
    }


}
