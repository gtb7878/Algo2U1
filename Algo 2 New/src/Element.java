public class Element
{
    private Object key;
    private Object value;

    public Element(Object k, Object v)
    {
        key = k;
        value = v;
    }

    public Object getKey()
    {
        return key;
    }

    public Object getValue()
    {
        return value;
    }

    public void setKey(Object key)
    {
        this.key = key;
    }

    public void setValue(Object value)
    {
        this.value = value;
    }

    public String toString()
    {
        return key.toString() + " " + value.toString();
    }
}
