/** abstrakte Klasse für die einzelnen Feldtypen, da per Interface keine Attribute übergeben werden
*/
abstract public class Feld {

    private boolean aufgedeckt;
    protected int anzMin = 0;

/**Methode um die Anzahl Minen in der Naehe zu veraendern
@param x anzahl der minen
*/
    abstract public void setAnzMin(int x);

/**Methode um die Anzahl der Minen zurueckzugeben
@return Anzahl der Minen in der Naehe
*/
    abstract public int getAnzMin();

/**Methode um den Status vom Feld, aufgedeckt oder nicht aufgedeckt, zurueckzugeben
*@return aufgedeckte Anahl Felder
*/
    public boolean getAufgedeckt() {
        return aufgedeckt;
    }

/**Methode um den Status vom Feld, aufgedeckt oder nicht aufgedeckt, zu ändern
*@param x true fuer aufgedeckt und false für unaufgedeckt
*/

    public void setAufgedeckt(boolean x) {
        aufgedeckt = x;
    }

}
