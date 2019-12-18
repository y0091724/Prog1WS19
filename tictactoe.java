import java.util.Scanner;


/** Tictactoe-Spiel für zwei Spieler
*
*@author Nico Schnieders y0091724
*@author Colin Engel y0099850
*@version 1.3
*/
public class Tictactoe {

    private static String[] spielbrett; 

    public static void main(String[] args) {
        spielbrett = new String[25]; //array als spielbrett
        String spieler = "X"; //string um festzuhalten, welcher spieler am zug ist
        String gewinner = null; //string um festzuhalten, wer gewonnen hat (am anfang niemand, daher null)
        Scanner sc1 = new Scanner(System.in); //scanner fuer eingabe der reihe
        Scanner sc2 = new Scanner(System.in); //scanner fuer eingabe der spalte
        int zeile = 0; //int fuer die x-achse des bretts
        int spalte = 0; //into fuer die x-achse des bretts
        brettFuellen(spielbrett);
        feldAusgeben(spielbrett);
        while (gewinnerUeberprufen() == null) {
            System.out.println("Jetzt am Zug: " + spieler);
            System.out.println("Bitte die Koordinate (Zeile und Spalte, jeweils 1-5) eingeben:");
            zeile = sc1.nextInt() - 1;
            spalte = sc2.nextInt() - 1;
            if (eingabeUeberpruefen(zeile, spalte)) {
                spielbrett[zeile * 5 + spalte] = spieler;
                feldAusgeben(spielbrett);
                spieler = spielerWechsel(spieler);
            }
        }
        feldAusgeben(spielbrett);
        if (gewinnerUeberprufen().equals("unentschieden")) {
            System.out.println("Unentschieden!"); 
	    } else {
            spieler = spielerWechsel(spieler);
            System.out.println("Gewonnen hat Spieler " + spieler);
        }
    }

/** Method zur Ausgabe des 1-dimensionalen arrays als Brett mit Zeilenversatz
*@param spielbrett das array, welches das Spielbrett beschreibt
*/
    public static void feldAusgeben(String[] spielbrett) { 
        System.out.println("|" + spielbrett[0] + "|" + spielbrett[1] + "|" + spielbrett[2] + "|" + spielbrett[3] + "|" + spielbrett[4] + "|");
        System.out.println("-----------");
        System.out.println("|" + spielbrett[5] + "|" + spielbrett[6] + "|" + spielbrett[7] + "|" + spielbrett[8] + "|" + spielbrett[9] + "|");
        System.out.println("-----------");
        System.out.println("|" + spielbrett[10] + "|" + spielbrett[11] + "|" + spielbrett[12] + "|" + spielbrett[13] + "|" + spielbrett[14] + "|");
        System.out.println("-----------");
        System.out.println("|" + spielbrett[15] + "|" + spielbrett[16] + "|" + spielbrett[17] + "|" + spielbrett[18] + "|" + spielbrett[19] + "|");
        System.out.println("-----------");
        System.out.println("|" + spielbrett[20] + "|" + spielbrett[21] + "|" + spielbrett[22] + "|" + spielbrett[23] + "|" + spielbrett[24] + "|");
        System.out.println();
    }
/** Methode welche die einzelnen Eintraege des Brettes initialisiert
*@param spielbrett array des spielbrettes
*/
	public static void brettFuellen(String[] spielbrett) {  
        for (int a = 0; a < 25; a++) {
        	spielbrett[a] = " ";
        }
    }
/** Methode um den Spieler nach dem Spielzug zu wechseln
*@param spieler string welcher den spieler speichert
*@return X wenn X am Zug ist, 0 wenn 0 am Zug ist
*/
    public static String spielerWechsel(String spieler) {
        if (spieler.equals("X")) {
            spieler = "O";
        } else {
            spieler = "X";
        }
        return spieler;
    }
/** Methode welche checkt, ob die Eingaben dem entspricht, was fuers spiele benoetigt wird
*@param zeile zur ueberpruefung der zeileneingabe
*@param spalte zur ueberpruefung der spalteneingabe
*@return true fuer korrekte eingabe, ansonsten false
*/
    public static boolean eingabeUeberpruefen(int zeile, int spalte) {
        if (zeile >= 5 || spalte >= 5) {
            System.out.println("Etwas stimmt mit deinen Eingaben nicht.");
            return false;
        }
        if (zeile < 0 || spalte < 0) {
            System.out.println("Etwas stimmt mit deinen Eingaben nicht.");
            return false;
        }
        if (spielbrett[zeile * 5 + spalte] != (' ')) {
            System.out.println("Diese Stelle ist schon besetzt. 	 ");
            return false;
        }
        return true;
    }
/** Methode zur durchfuerung von spielzuegen
*@param spielbrett das feld auf welchem gespielt wird
*@param zeile die zeileneingabe
*@param spalte die spalteneingabe
*@param spieler welcher den spieler speichert
*/
    public static void spielzug(String[] spielbrett, String spieler, int zeile, int spalte) {
        spielbrett[zeile * 5 + spalte] = spieler;
    }
/**
*Methode zur ueberpruefung des gewinners
*@param detektor in welchem je nach switch case der horizontale, vertikale oder diagonale 
zustand des bretts gespeichert ist
@return X fuer X hat gewonnen, 0 fuer 0 hat gewonnen, unentschieden fuer unentschieden,
null fuer niemand hat bis jetzt gewonnen
*/
    public static String gewinnerUeberprufen(detektor) {  
        for (int a = 0; a < 13; a++) {
            String detektor = "";
       		switch (a) {
                case 1:
            		detektor = spielbrett[0] + spielbrett[1] + spielbrett[2] + spielbrett[3] + spielbrett[4];
            		break;
            	case 2:
                    detektor = spielbrett[5] + spielbrett[6] + spielbrett[7] + spielbrett[8] + spielbrett[9];
                	break;
            	case 3:
                    detektor = spielbrett[10] + spielbrett[11] + spielbrett[12] + spielbrett[13] + spielbrett[14];
                	break;
            	case 4:
                    detektor = spielbrett[15] + spielbrett[16] + spielbrett[17] + spielbrett[18] + spielbrett[19];
                	break;
            	case 5:
                    detektor = spielbrett[20] + spielbrett[21] + spielbrett[22] + spielbrett[23] + spielbrett[24];
                	break;
            	case 6:
                    detektor = spielbrett[0] + spielbrett[5] + spielbrett[10] + spielbrett[15] + spielbrett[20];
                	break;
            	case 7:
                    detektor = spielbrett[1] + spielbrett[6] + spielbrett[11] + spielbrett[16] + spielbrett[21];
                	break;
            	case 8:
            	    detektor = spielbrett[2] + spielbrett[7] + spielbrett[12] + spielbrett[17] + spielbrett[22];
                	break;
            	case 9:
                    detektor = spielbrett[3] + spielbrett[8] + spielbrett[13] + spielbrett[18] + spielbrett[23];
                	break;
            	case 10:
                    detektor = spielbrett[4] + spielbrett[9] + spielbrett[14] + spielbrett[19] + spielbrett[24];
                	break;
            	case 11:
                    detektor = spielbrett[0] + spielbrett[6] + spielbrett[12] + spielbrett[18] + spielbrett[24];
                	break;
            	case 12:
                    detektor = spielbrett[4] + spielbrett[8] + spielbrett[12] + spielbrett[16] + spielbrett[20];
                	break;
            }
        	if (detektor.equals("XXXXX")) {
        		return "X";
          	} else {
                if (detektor.equals("OOOOO")) {
            		return "O";
    			}
            }
        }
     	for (int a = 0; a < 24; a++) {  
            if (spielbrett[a] == (" ")) {
    		    break;
            } else {
                if (a == 23) {
                    return "unentschieden";
                }
            }
        }
    	return null;
    }


}
