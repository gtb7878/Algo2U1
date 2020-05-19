package Übungen;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Elem //  für LinkedList.
{
    String word;
    int count;
    Elem next;

    Elem(String w, Elem n)
    {
        word = w;
        count = 1;
        next = n;
    }
}

public class WordCountVL
{
    public static void main(String[] args) throws IOException
    {

        BufferedReader r =
                new BufferedReader(new InputStreamReader(System.in));

        Elem head = null;

        String word;
        while((word = r.readLine()) != null)
        {
            // Wort word in der Liste suchen.

            Elem p = null;
            for (p = head; p != null; p = p.next)
            {
                if (p.word.equals(word))
                {
                    p.count++;
                    break;  // oder continue mit Label input (-> Skript)
                }

            }

            if(p == null)
            {
                head = new Elem(word, head);
            }



        }


        //Ausgabe
        for (Elem p = head; p != null; p = p.next)
        {
            System.out.println(p.count + " " + p.word);
        }

    }
}
