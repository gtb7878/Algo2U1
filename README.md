# Hash-Tables (Streuwerttabellen)
Es werden mehrere Verfahren zur Berechnung und Verteilung von Werten in einer Tabelle implementiert.

## Parameterwahl
### Erster Parameter
* c - Chaining
* l - Linear Probing
* q - Quadratic Probing
* d - Double Hashing

### Zweiter Parameter
* d - Divisionsrestmethode
* m - Multiplikationsmethode

### Dritter Parameter
* bei Divisionsrestmethode: Größe N der Streuwerttabelle
* bei Multiplikationsmethode: Anzahl p von Bits

### Vierter Parameter
* bei Multiplikationsmethode: Parameter s

### Beispiele
> java WordCount q d 4 < words


> java WordCount l m 2 3 < words

## Ausgabe
Index | Wort | Anzahl
