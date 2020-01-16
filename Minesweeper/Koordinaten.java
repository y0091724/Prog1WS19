/** Klasse zum Speichern und Ueberpruefen der Koordinateninformation
*@author Colin Engel y0099850
*@author Nico Schnieders y001724
*@version 1.4
*/
public class Koordinaten {

    private int spalte;
    private int reihe;

/**Konstruktor um die Zeilen/Spalteninformationen zu importieren
*@param spalte Spalteninformation
*@param reihe Zeileninformation
*/

    public Koordinaten(char spalte, int reihe) {
        this.spalte =  (int) spalte - 65;
        this.reihe = reihe;
    }

/**Methode um zu Ueberpruefen, ob die Eingaben den Anforderungen entsprechen
*@return false falls Eingaben falsch sind, ansonsten true
*/
    public boolean korrektheit() {
        if (reihe <= 9 && reihe >= 0 && spalte <= 9 && spalte >= 0) {
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
