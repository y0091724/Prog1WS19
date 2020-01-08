
public class Spielfeld {

    private int n;  //Groesse
    private int x;  //verminte Felder
    private int v;  //initial aufgedeckten Felder
    Feld[][] spielfeld;

    Spielfeld(int groesse, int verminteFelder, int aufgedeckteFelder) {
        n = groesse;
        x = verminteFelder;
        v = aufgedeckteFelder;
    }

    public Feld[][] getSpielfeld() {
        return spielfeld;
    }

    public void erschaffeFeld() {
        spielfeld = new Feld[n][n];
        for(int zaehler1 = 0; zaehler1 < n; zaehler1++) {
            for(int zaehler2 = 0; zaehler2 < n; zaehler2++) {
                spielfeld[zaehler1][zaehler2] = new NormalesFeld(0);
            }
        }
        for(int zaehler = 1; zaehler <= x; zaehler++) {
            int zahl1 = (int) (Math.random() * 10);
            int zahl2 = (int) (Math.random() * 10);
            if(spielfeld[zahl1][zahl2] instanceof NormalesFeld) {
                zaehler++;
            }
            else {
                mineSetzen(zahl1, zahl2);
            }
        }
    }

    public void mineSetzen(int hoehe, int breite) {
        spielfeld[hoehe][breite] = new Landmine();
        if(hoehe != 0) {
            spielfeld[hoehe - 1][breite].setAnzMin(spielfeld[hoehe - 1][breite].getAnzMin() + 1);
            if(breite - 1 >= 0) {
                spielfeld[hoehe - 1][breite - 1].setAnzMin(spielfeld[hoehe - 1][breite - 1].getAnzMin() + 1);
            }
            if(breite + 1 >= 0) {
                spielfeld[hoehe - 1][breite + 1].setAnzMin(spielfeld[hoehe - 1][breite + 1].getAnzMin() + 1);
            }
        }
        if(hoehe != 10) {
            spielfeld[hoehe + 1][breite].setAnzMin(spielfeld[hoehe + 1][breite].getAnzMin() + 1);
            if(breite - 1 >= 0) {
                spielfeld[hoehe + 1][breite - 1].setAnzMin(spielfeld[hoehe - 1][breite - 1].getAnzMin() + 1);
            }
            if(breite + 1 >= 0) {
                spielfeld[hoehe - 1][breite + 1].setAnzMin(spielfeld[hoehe - 1][breite + 1].getAnzMin() + 1);
            }
        }
        if(breite != 0) {
            spielfeld[hoehe][breite - 1].setAnzMin(spielfeld[hoehe][breite - 1].getAnzMin() + 1);
        }
        if(breite != 10) {
            spielfeld[hoehe][breite + 1].setAnzMin(spielfeld[hoehe][breite + 1].getAnzMin() + 1);
        }
    }
}
