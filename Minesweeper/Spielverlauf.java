import java.util.Scanner;
//Klasse um den Spielverlauf zu implementieren

public class Spielverlauf {

    private Spielfeld feld;

/**Methode um den momentanen Spielzustand festzuhalten
@param n Anzahl der Felder des Brettes
@param x Anzahl der Minen
@param v Anzahl der aufgedeckten Felder
*/
    public Spielverlauf(int n, int x, int v) {
        feld = new Spielfeld(n, x, v);
    }

/** Methode zum Ausgeben des Feldes
*/
    public void ausgabe() {
        System.out.println(" |A|B|C|D|E|F|G|H|I|J");
        for (int zaehler1 = 0; zaehler1 < feld.getSpielfeld().length; zaehler1++) {
            System.out.print(zaehler1);
            for (int zaehler2 = 0; zaehler2 < feld.getSpielfeld().length; zaehler2++) {
                System.out.print("|");
                if (feld.getSpielfeld()[zaehler1][zaehler2].getAufgedeckt() == true) {
                    if (feld.getSpielfeld()[zaehler1][zaehler2] instanceof Landmine) {
                        System.out.print("X");
                    } else {
                        System.out.print(feld.getSpielfeld()[zaehler1][zaehler2].getAnzMin());
                    }
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

/**Methode zum ueberpruefen ob gewonnen wurde
*@return true falls gewonnen wurde, false wenn verloren wurde
*/

    public boolean gewinnerUeberpruefen() {
        for (int zaehler1 = 0; zaehler1 < feld.getSpielfeld().length; zaehler1++) {
            for (int zaehler2 = 0; zaehler2 < feld.getSpielfeld().length; zaehler2++) {
                if (feld.getSpielfeld()[zaehler1][zaehler2].getAufgedeckt() == false) {
                    return false;
                }
            }
        }
        return true;
    }

/**Methode um den Spielzug durchzufueren
*@return true falls der Spielzug korrekt durchgefuehrt wurde, false falls man auf eine Mine trat
*/

    public boolean spielzug() {
        Scanner eingabeKo = new Scanner(System.in);
        System.out.println("Geben sie die nächsten Koordinaten ein (z.B. H4): ");
        eingabeKo.useDelimiter("");
        Koordinaten ko = new Koordinaten(eingabeKo.next().charAt(0), eingabeKo.nextInt());
        while (!ko.korrektheit()) {
            eingabeKo = new Scanner(System.in);
            System.out.println("Etwas stimmt mit ihren Eingaben nicht. Versuchen sie es erneut: ");
            System.out.println("Geben sie die nächsten Koordinaten ein (z.B. H4): ");
            eingabeKo.useDelimiter("");
            ko = new Koordinaten(eingabeKo.next().charAt(0), eingabeKo.nextInt());
        }
        System.out.println("Geben sie ihre naechste Aktion ein (1 für 'aufdecken', 2 fuer 'entschaerfen'): ");
        eingabeKo = new Scanner(System.in);
        int akt = eingabeKo.nextInt();
        if (akt == 1) {
            int ergebnis = aufdecken(ko);
            if (ergebnis == 0) {
                return false;
            }
            if (ergebnis == 2) {
                System.out.println("An dieser Stelle ist schon aufgedeckt. Es passiert nichts.");
                return true;
            }
        }
        if (akt == 2) {
            int ergebnis = entschaerfen(ko);
            if (ergebnis == 1) {
                return true;
            }
            if (ergebnis == 2) {
                System.out.println("An dieser Stelle ist schon aufgedeckt. Es passiert nichts.");
            }
            if (ergebnis == 0) {
                System.out.println("An dieser Stelle ist keine Mine.");
            }
        }
        return true;
    }

/**Methode zum Aufdecken des betretenen Feldes
*@return 0 falls man eine Mine aufdeckte, 1 falls man ein normales Feld aufdeckte, 2 falls das Feld schon aufgedeckt ist
*@param ko fuer die Koordinaten des momentanen Feldes
*/

    public int aufdecken(Koordinaten ko) {
        int spalte = ko.getSpalte();
        int reihe = ko.getReihe();
        if (feld.getSpielfeld()[reihe][spalte] instanceof Landmine) {
            return 0;
        }
        if (feld.getSpielfeld()[reihe][spalte].getAufgedeckt() == false) {
            feld.getSpielfeld()[reihe][spalte].setAufgedeckt(true);
            return 1;
        }
        if (feld.getSpielfeld()[reihe][spalte].getAufgedeckt() == true) {
            return 2;
        }
        return 2;
    }

/**Methode zum Entschaerfen einer Mine
@param ko fuer die Koordiaten des momentanen Feldes
@return 2 falls das Feld schon aufgedeckt ist, 1 wenn das Feld eine Mine enthaelt,0 wenn das Feld keine Mine enthaelt
*/
    public int entschaerfen(Koordinaten ko) {
        int spalte = ko.getSpalte();
        int reihe = ko.getReihe();
        if (feld.getSpielfeld()[reihe][spalte].getAufgedeckt() == true) {
            return 2;
        }
        if (feld.getSpielfeld()[reihe][spalte] instanceof Landmine) {
            feld.getSpielfeld()[reihe][spalte].setAufgedeckt(true);
            return 1;
        }

        return 0;
    }

/**Methode um das komplette Feld auszugeben
*/

    public void ausgabeVoll() {
        System.out.println(" |A|B|C|D|E|F|G|H|I|J");
        for (int zaehler1 = 0; zaehler1 < feld.getSpielfeld().length; zaehler1++) {
            System.out.print(zaehler1);
            for (int zaehler2 = 0; zaehler2 < feld.getSpielfeld().length; zaehler2++) {
                System.out.print("|");
                if (feld.getSpielfeld()[zaehler1][zaehler2] instanceof Landmine) {
                    System.out.print("X");
                } else {
                    System.out.print(feld.getSpielfeld()[zaehler1][zaehler2].getAnzMin());
                }
            }
            System.out.println();
        }
    }

}
