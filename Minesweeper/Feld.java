/** abstrakte Klasse für die einzelnen Feldtypen, da per Interface keine Attribute übergeben werden
*/ 
abstract public class Feld {

    private boolean aufgedeckt;
    private int anzMin = 0;

/**Methode um die Anzahl Minen zu veraendern
@param x anzahl der minen
*/
    abstract public void setAnzMin(int x); 
/**Methode um die Anzahl der Minen zu exportieren
@return Anzahl der Minen
*/    
    abstract public int getAnzMin();
/**Methode um die Anzahl der aufgedeckten Felder zu exportieren
*@return aufgedeckte Anahl Felder
*/
    public boolean getAufgedeckt() {
        return aufgedeckt; x
    }

    public void setAufgedeckt(boolean x) {
        aufgedeckt = x;
    }
}
 
