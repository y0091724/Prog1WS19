/**Klasse zur Realisierung des Spielfeldes
*/
public class Spielfeld {

    private int n;  //Groesse
    private int x;  //verminte Felder
    private int v;  //initial aufgedeckten Felder
    private Feld[][] spielfeld;

/**Methode welche das Spielfeld initialisiert
*@param groesse fuer maximale anzahl der felder
*@param verminteFelder die Anzahl der verminten Felder
*@param aufgedeckteFelder die Anzahl der aufgedeckten Felder
*/
    public Spielfeld(int groesse, int verminteFelder, int aufgedeckteFelder) {
        n = groesse;
        x = verminteFelder;
        v = aufgedeckteFelder;
        erschaffeFeld();
    }

    public Feld[][] getSpielfeld() {
        return spielfeld;
    }

/**Methode um die tatsaechliche Initialisierung zu realisieren
*/
    public void erschaffeFeld() {
        spielfeld = new Feld[n][n];
        for (int zaehler1 = 0; zaehler1 < n; zaehler1++) {
            for (int zaehler2 = 0; zaehler2 < n; zaehler2++) {
                spielfeld[zaehler1][zaehler2] = new NormalesFeld();
            }
        }
        for (int zaehler = 1; zaehler <= x; zaehler++) {
            int zahl1 = (int) (Math.random() * 10);
            int zahl2 = (int) (Math.random() * 10);
            if (spielfeld[zahl1][zahl2] instanceof NormalesFeld) {
                mineSetzen(zahl1, zahl2);
            } else {
                zaehler--;
            }
        }
        for (int zaehler = 0; zaehler < v; zaehler++) {
            int zahl1 = (int) (Math.random() * 10);
            int zahl2 = (int) (Math.random() * 10);
            if (spielfeld[zahl1][zahl2] instanceof NormalesFeld && spielfeld[zahl1][zahl2].getAufgedeckt() == false) {
                spielfeld[zahl1][zahl2].setAufgedeckt(true);
            } else {
                zaehler--;
            }
        }
    }

/** Methode um die Anzahl der Minen in der Nähe in den Umgebenen Felder zu erhöhen
*@param hoehe zeile wo die Mine gesetzt wird
*@param breite spalte wo die Mine gesetzt wird 
*/
    public void mineSetzen(int hoehe, int breite) {
        spielfeld[hoehe][breite] = new Landmine();
        if (hoehe != 0) {
            spielfeld[hoehe - 1][breite].setAnzMin(spielfeld[hoehe - 1][breite].getAnzMin() + 1);
            if (breite != 0) {
                spielfeld[hoehe - 1][breite - 1].setAnzMin(spielfeld[hoehe - 1][breite - 1].getAnzMin() + 1);
            }
            if (breite != 9) {
                spielfeld[hoehe - 1][breite + 1].setAnzMin(spielfeld[hoehe - 1][breite + 1].getAnzMin() + 1);
            }
        }
        if (hoehe != 9) {
            spielfeld[hoehe + 1][breite].setAnzMin(spielfeld[hoehe + 1][breite].getAnzMin() + 1);
            if (breite != 0) {
                spielfeld[hoehe + 1][breite - 1].setAnzMin(spielfeld[hoehe + 1][breite - 1].getAnzMin() + 1);
            }
            if (breite != 9) {
                spielfeld[hoehe + 1][breite + 1].setAnzMin(spielfeld[hoehe + 1][breite + 1].getAnzMin() + 1);
            }
        }
        if (breite != 0) {
            spielfeld[hoehe][breite - 1].setAnzMin(spielfeld[hoehe][breite - 1].getAnzMin() + 1);
        }
        if (breite != 9) {
            spielfeld[hoehe][breite + 1].setAnzMin(spielfeld[hoehe][breite + 1].getAnzMin() + 1);
        }
    }

}
