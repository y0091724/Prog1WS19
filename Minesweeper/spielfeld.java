
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

    public void erschaffeFeld() {
        spielfeld = new Feld[n][n];
    }

    public  zufaelligsetzen ()
}
