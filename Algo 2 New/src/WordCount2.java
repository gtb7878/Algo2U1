import java.util.Scanner;


// Erweitertes Testprogramm.
class WordCount2
{
    // Aufruf mit folgenden Kommandozeilenargumenten:
    // 1) Buchstabe c (chaining), l (linear probing),
    //    q (quadratic probing) oder d (double hashing).
    // 2) Buchstabe d (Divisionsrestmethode)
    //    oder m (Multiplikationsmethode).
    // 3) Größe N der Streuwerttabelle (bei Divisionsrestmethode)
    //    oder Anzahl p von Bits (bei Multiplikationsmethode).
    // 4) Parameter s (nur bei Multiplikationsmethode).
    public static void main (String [] args)
    {
        // Größe N der Streuwerttabelle oder Anzahl p von Bits.
        int Np = Integer.parseInt(args[2]);

        // Scanner initialisieren.
        Scanner scanner = new Scanner(System.in);

        // Streuwertfunktion mit Einschränkung des Wertebereichs
        // gemäß Divisionsrest- oder Multiplikationsmethode.
        HashFunction f;
        switch (args[1])
        {
            case "d":
                f = new DivisionMethod(Np);
                break;
            case "m":
                int s = Integer.parseInt(args[3]);
                f = new MultiplicationMethod(Np, s);
                break;
            default:
                return;
        }

        // Streuwerttabelle mit Verkettung oder offener Adressierung.
        HashTable tab;
        if (args[0].equals("c"))
        {
            tab = new HashTableChaining(f);
        }
        else {
            HashSequence s;
            switch (args[0])
            {
                case "l":
                    s = new LinearProbing(f);
                    break;
                case "q":
                    s = new QuadraticProbing(f);
                    break;
                case "d":
                    // Als zweite Streuwertfunktion für doppelte Streuung
                    // wird eine Funktion verwendet, die immer eine
                    // ungerade Zahl zwischen 1 und N-1 liefert.
                    // Wenn die Tabellengröße N dann entweder eine Primzahl
                    // (ratsam bei Divisionsrestmethode) oder eine
                    // Zweierpotenz (automatisch bei Multiplikationsmethode)
                    // ist, sind alle Werte der Funktion teilerfremd zu N.
                    class HashFunction2 extends AbstractHashFunction
                    {
                        public HashFunction2 (int N)
                        {
                            super(N);
                        }
                        public int compute (Object key)
                        {
                            int h = Math.abs(key.hashCode()) % (size - 1);
                            if (h % 2 == 0) h++;
                            return h;
                        }
                    }
                    s = new DoubleHashing(f, new HashFunction2(f.size()));
                    break;
                default:
                    return;
            }
            tab = new HashTableOpenAddressing(s);
        }

        boolean check;

        while (true)
        {
            String op = scanner.next();
            String word = scanner.next();
            if (op == null) break;


            // Überprüfen, ob die Tabelle bereits einen Eintrag mit
            // Schlüssel word enthält.
            // Wenn nicht, wird word mit Wert 1 neu eingetragen.
            // Ansonsten wird der vorhandene Eintrag durch einen neuen
            // Eintrag mit altem Wert plus 1 ersetzt.
            // (int-Werte werden bei Bedarf automatisch in Integer-
            // Objekte umgewandelt und umgekehrt.)
            // Inhalt der Tabelle ausgeben.
            switch (op)
            {
                case "+" -> {
                    Integer count = (Integer) tab.get(word);
                    if (count == null) count = 0;
                    check = tab.put(word, count + 1);
                    if (!check) System.out.println("Tabelle voll.");
                    System.out.println("-----");
                    tab.dump();
                    System.out.println("-----");
                }
                case ("=") -> {
                    System.out.println("-----");
                    tab.dump();
                    System.out.println("-----");
                }
                case "-" -> {
                    check = tab.remove(word);
                    if (!check) System.out.println("Schlüssel wurde nicht gefunden.");
                    System.out.println("-----");
                    tab.dump();
                    System.out.println("-----");
                }
                default -> System.out.println("Eingabefehler.");
            }


        }


    }
}

