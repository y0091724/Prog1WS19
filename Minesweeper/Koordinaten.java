
public class Koordinaten {

    private int spalte;
    private int reihe;

    public Koordinaten(char spalte, int reihe) {
        this.spalte =  (int) spalte - 65;
        this.reihe = reihe;
    }

    public boolean korrektheit() {
        if(reihe <= 9 && reihe >= 0 && spalte <= 9 && spalte >= 0) {
            return true;
        }
        return false;
    }

    public int getSpalte() {
        return spalte;
    }

    public int getReihe() {
        return reihe;
    }


}
