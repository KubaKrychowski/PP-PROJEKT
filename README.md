
# Aplikacja do Formatowania
## Opis

Aplikacja ta przyjmuje plik wejściowy i formatuje go zgodnie z określonymi zasadami. Zasady formatowania zapewniają spójność i czytelność poprzez standaryzację spacji wokół różnych znaków oraz poziomów wcięć. Aplikacja przetwarza pliki tekstowe i stosuje poniższe zasady formatowania.
## Zasady formatowania
- Formatowanie przecinków:

Po każdym przecinku musi występować spacja.
Przykład: lorem,ipsum,dolor staje się lorem, ipsum, dolor.
- Formatowanie nawiasów okrągłych:

Przed i po każdym nawiasie okrągłym musi występować spacja.
Przykład: loremipsumdolor(sitamet)sitamet staje się loremipsumdolor ( sitamet ) sitamet.
- Formatowanie nawiasów kwadratowych:

Wewnątrz nawiasów kwadratowych musi występować spacja po otwarciu nawiasu i przed jego zamknięciem.
Przykład: loremipsum[dolorsit]amet staje się loremipsum[ dolorsit ]amet.
- Formatowanie operatorów:

Przed i po każdym operatorze matematycznym (+, -, *, /, &, =), logicznym (>=, <=, ==, &&, ||) oraz bitowym (|, &, <>) musi występować spacja.
- Formatowanie nawiasów klamrowych:

Nawiasy klamrowe ({}) muszą być jedynymi znakami w linii (otoczone znakami nowej linii).
- Średnik kończący linię:

Średnik kończy linię.
Wyjątek: Średnik nie kończy linii, jeśli jest otoczony nawiasami okrągłymi.
- Zamiana tabulatorów na spacje:

Wszystkie tabulatory na początku linii są zamieniane na cztery spacje.
- Podwójne spacje:

Poza początkiem linii, nie mogą występować podwójne spacje.
Przykład: lorem ipsum staje się lorem ipsum.
- Obsługa wcięć:

Jeden poziom wcięcia to cztery spacje.
Otwarcie nawiasu klamrowego zwiększa poziom wcięcia o jeden w następnej linii.
Zamknięcie nawiasu klamrowego zmniejsza poziom wcięcia w linii z nawiasem.
## Użycie
### Instalacja:

- Skopiuj pliki projektu na swój komputer.

### Uruchomienie:
- Uruchomienie za pomocą dowolnego IDE obsługującego Gradle, lub za pomocą kompilatora javy.
- Jako argument wejściowy podaje się nazwę pliku tekstowego z rozszerzeniem (domyślnie foo.txt)

## Wymagania
- JDK : corretto-19 (Amazon Corretto Version 19.0.2)

## Autor

- Kuba Krychowski

