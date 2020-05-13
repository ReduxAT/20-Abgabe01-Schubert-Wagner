# 20-Abgabe01-Schubert-Wagner
Repository zu Verwaltung der Uebung 1, der Lehrveranstaltung Konfigurationsmanagement.

## Übersicht über Projekt

In dem Projekt gibt es die abstrakte Klasse Drinks, von welcher mehrere Subklassen abgeleitet werden. Anschließend soll zum Projekt ein Testing erstellt werden.
Grundsätzlich soll mit diesem Projekt der Umgang mit GitHub, JavaDocs und Testing erlernt werden. Dafür arbeitet man in Gruppen über GitHub, kommentiert alle Methoden und Klassen mithilfe von JavaDocs und schreibt anschließend ein Testing, dass 100 % des Projektes abdeckt.

## SoftDrinks als Unterklasse von SimpleDrinks
### Variable
 - [x] Variable (Set?) BehälterTyp (Plastik Flasche, Glas Flasche, Dose)
 - [x] Collection (Map?) Nährwerte
 - [x] String Farbe

### Methoden - Ideen
 - [x] Map hat Nährwerte pro 100g und Methode berechnet Nährwerte auf das Volumen bezogen
### Custom Exception
 - [x] Es soll die Exception "EmptyDrink" auftreten wenn die Nährwerte berechnet werden und das Volumen 0 ist.

## Relevante Code Schnipsel
### Methode - nutritionValueTotal

Diese methode berechnet die Nährwerte gesamt, basierend auf der Map nutritionValue und dem Volumen.

```
public Map nutritionValueTotal() throws EmptyDrinkException {
        Map<String, Double> nutritionsToVolume = new HashMap<>();
        // If drink is empty throw an exception
        if (this.getVolume() == 0) {
            throw new EmptyDrinkException();
        }

        // Iterate nutrionalValue based on Keys
        for (String key : nutritionalValue.keySet()) {
            // Add nutritionValue/volume to returned map
            nutritionsToVolume.put(key,
                    nutritionalValue.get(key).doubleValue() * (((double) this.getVolume()) / 0.1));
        }
        return nutritionsToVolume;
    }
```

### Test - SimpleDrink Konstruktor

Dieser Code ist ein Ausschnitt aus der Klasse SimpleDrinkTest und überprüft, ob der Konstruktor für ein nicht alkoholisches Getränk korrekt funktioniert.

```
@Test
    @DisplayName("Testing constructor non alcoholic (water based)")
    public void testConstructorNonAlcoholic(){
        assertEquals(lN.getVolume(), 0.7, 0.001);
        assertEquals(lN.getAlcoholPercent(), 0, 0.001);
    }
```