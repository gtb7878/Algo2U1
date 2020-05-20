public class Element
{
    private Object key;
    private Object value;
    private boolean marker;

    public Element(Object k, Object v)
    {
        key = k;
        value = v;
        marker = false;
    }

    public Object getKey()
    {
        return key;
    }

    public Object getValue()
    {
        return value;
    }

    public void setMarker(boolean marker)
    {
        this.marker = marker;
    }

    public boolean getMarker()
    {
        return marker;
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

    public boolean equals(Object other)
    {
        if (!(other instanceof Element)) return false;

        Element that = (Element)other;

        return this.key.toString().equals(that.key.toString()) && this.value.toString().equals(that.value.toString());
    }
}
