
abstract public class Feld {

    private int anzMin;
    private boolean aufgedeckt = false;

    public int getAnzMin() {
        return anzMin;
    }
    abstract public void setAnzMin(int x);

    public boolean getAufgedeckt() {
        return aufgedeckt;
    }

    public boolean setAufgedeckt(boolean x) {
        aufgedeckt = x;
        return aufgedeckt;
    }
}
