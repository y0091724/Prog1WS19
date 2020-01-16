/** Main-Klasse um die anderen Klassen zusammen zu fuehren
*@author Colin Engel y0099850
*@author Nico Schnieders y001724
*@version 1.4
*/
public class Main {

    public static void main(String[] args) {
        Spielverlauf spiel = new Spielverlauf(10, 23, 5);
        spiel.ausgabeVoll();
        System.out.println();
        spiel.ausgabe();
        while (spiel.spielzug() && !spiel.gewinnerUeberpruefen()) {
            spiel.ausgabe();
            System.out.println();
        }
        if (spiel.gewinnerUeberpruefen()) {
            System.out.println("Sie haben gewonnen!!");
        } else {
            System.out.println("Sie haben verloren, weil sie ein Feld mit Mine betreten haben.");
        }
    }

}
