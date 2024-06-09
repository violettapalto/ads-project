**Universität Klagenfurt** - 
Artificial Intelligence und Cybersecurity - 
*M. El-Kholany & M. Morak*

UE Algorithmen und Datenstrukturen - 
SS 2024 - 
Übungstermine: siehe Moodle

# Abgabe 2

Abgabe: 16.06.2024

## Ziel der Aufgabe

In dieser praktischen Programmieraufgabe sind die vorgegebenen Java-
Interfaces zu implementieren, gemäß der in den Java-Kommentaren spezifizierten Beschreibung:

- `Ab2` Dieses Interface stellt ein Factory-Pattern zur Erstellung der restlichen Interfaces
bereit.

- `AuDHashSetDieses` Interface spezifiziert eine simplifizierte Hashtabelle.

- `AuDQueueDieses` Interface spezifiziert eine simplifizierte FIFO- bzw. LIFO-Warteschlange.

- `AuDTreeSetDieses` Interface spezifiziert die Datenstruktur eines sortierten Baumes.

Die Punkteaufteilung ergibt sich wie folgt: 4 Punkte für die Hashtabelle, 4 Punkte für die Implementierung der Warteschlange, sowie 7 Punkte für die Implementierung des sortierten
Baumes.

## Vorbereitung

Laden Sie die in Moodle bereitgestellte Ab2-ZIP-Datei herunter. Es wird das Build-Toolgradleverwendet, welches Sie beim Arbeiten und auch beim Erzeugen Ihrer hochzuladenden ZIP-Datei unterstützt. Die ZIP-Datei enthält folgende Bestandteile:

- Interface `Ab2` im Java-Paket `ab2`, sowie weitere zu implementierende Interfaces.
- “Leere” Implementierung (als Grundgerüst) des oben genannten `Ab2`-Interfaces im Paket
    `ab2.impl.Nachnamen` (im Folgenden _Implementierungspaket_ genannt). Ihre Aufgabe
    besteht in der Implementierung des entsprechenden Interfaces.
- Eine Testklasse `Ab2Tests` im Paket `ab2`, mit der Sie Ihre Implementierungen testen können.
    Diese Testklasse (mit zusätzlichen Testfällen) wird auch zur Bewertung Ihrer Abgabe
    verwendet (siehe Punkt “Testen”).

## Integration in Ihre IDE (optional)

Sie können (zB in Eclipse bzw. IntelliJ) den Inhalt der
ZIP-Datei als Gradle-Projekt importieren. Ihre IDE hat damit alle nötigen Informationen.

## Durchführung

Die Programmieraufgabe kann in Gruppen bis zu 3 Personen bearbeitet
werden. Alle Namen müssen in der Abgabe enthalten sein (siehe Punkte “Abgabe” unten).
Die geforderten Algorithmen sind im Implementierungspaket (impl) ohne Verwendung von
Java-Bibliotheken und Systempaketen (außer `java.lang`) zu implementieren. Insbesondere darf
das `java.util` Paket nicht verwendet werden. An den vorgegebenen Interfaces und an der
Testklasse dürfen, bis auf die Umbenennung Ihres Implementierungspakets, keine Änderungen
vorgenommen werden. Ändern Sie ausschließlich die Datei “Ab2Impl.java” (bzw., wenn benötigt, können auch neue Dateien im Ordner “ab2/impl” erstellt werden). Bei Unklarheiten bezüglich
der Aufgabenstellung kontaktieren Sie bitte Ihren LV-Leiter.


## Testen

Rufen Sie `./gradlew` test bzw. `gradlew.bat` testauf um die Testfälle durchlaufen
zu lassen. Alternativ können Sie die Tests auch in Ihrer Entwicklungsumgebung laufen lassen.
Zum Bewerten Ihrer Abgabe werden zusätzliche, nicht ausgegebene Testfälle verwendet. Es ist
daher von Vorteil, wenn Sie selbst zusätzliche Testfälle implementieren, und Ihre Lösung damit
testen.

## Abgabe

Rufen sie `./gradlew` zip bzw. `gradlew.bat` zip auf. Sie finden nun die hochladbare
ZIP-Datei im Ordnerbuild. Geben Sie die ZIP-Datei via Moodle ab. Pro Gruppe ist nur eine
Abgabe nötig. Benennen Sie vor der Abgabe das Paket `ab2.impl.Nachnamen` entsprechend
um, indem Sie Nachnamen durch die Nachnamen Ihrer Gruppenmitglieder ersetzen (z.B.
`ab2.impl.HuberMeierMueller`).

## Bewertung

Diese Programmieraufgabe wird mit maximal 15 Punkten bewertet. Die erreichte
Punktezahl wird allen Gruppenmitgliedern gleichermaßen angerechnet. Bei mehr als 3 Personen
werden die erreichten Punkte anteilsmäßig pro Person reduziert. Die Bewertung ergibt sich aus
folgenden Komponenten:

- Funktionalität Ihres Codes. Die Anzahl erfolgreicher Unit-Tests sind hierführ
    ausschlaggebend. Beachten Sie, dass für die Bewertung nicht nur die Testfälle der
    ausgegebenen Testklasse verwendet werden, sondern auch zusätzliche, erweiterte Testfälle.
    Beim Testen wird aus Ihrer ZIP-Datei nur das Implementierungspaket verwendet.
- Qualität Ihres Quellcodes (Inspektion). Achten Sie auf kommentierten, gut verständlichen
    und effizienten Quellcode. Die Verwendung vonSystem.outist nicht gestattet.
- Ehrlichkeit: Falls Sie unzulässige Java-Bibliotheken (siehe oben) verwenden, oder Sie den
    selben Quellcode wie eine andere Gruppe abgeben, kann Ihre Abgabe mit 0 Punkten
    bewertet werden.
- Formatierung: Formatieren Sie Ihren Code (Standard-Formatierung Ihrer IDE ist
    ausreichend) und achten Sie darauf, dass sie keine nicht verwendeten Imports verwenden.


