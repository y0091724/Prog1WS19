
abstract public class Feld {

    protected int anzMin = 0;
    private boolean aufgedeckt = false;
    //abstract public void setAnzMin(int x);
    //abstract public int getAnzMin();

    public int getAnzMin() {
        return anzMin;
    }

    public void setAnzMin(int x) {
        anzMin = x;
    }

    public boolean getAufgedeckt() {
        return aufgedeckt;
    }

    public boolean setAufgedeckt(boolean x) {
        aufgedeckt = x;
        return aufgedeckt;
    }
}
