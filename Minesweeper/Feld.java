
abstract public class Feld {

    private boolean aufgedeckt;
    protected int anzMin = 0;

    abstract public void setAnzMin(int x);
    abstract public int getAnzMin();

    public boolean getAufgedeckt() {
        return aufgedeckt;
    }

    public void setAufgedeckt(boolean x) {
        aufgedeckt = x;
    }

    /*
    private int anzMin = 0;
    private boolean aufgedeckt = false;

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
    */

}
