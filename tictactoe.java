import java.util.Scanner;

public class tictactoe {

         static String[] spielbrett;

    public static void main (String[] args) {
         spielbrett = new String[25];
         String spieler = "X";
         String gewinner = null;
         Scanner sc1 = new Scanner (System.in);
         Scanner sc2 = new Scanner (System.in);
         int reihe = 0;
         int spalte = 0;
         brettFuellen(spielbrett);
         feldAusgeben(spielbrett);
         while(gewinnerUeberprufen() == null) {
            System.out.println("Jetzt am Zug: " + spieler);
            System.out.println("Bitte die Koordinate (Reihe und Spalte, jeweils 0-4) eingeben:");
            reihe = sc1.nextInt();
            spalte = sc2.nextInt();
            if (eingabeUeberpruefen(reihe, spalte)) {
                spielbrett[reihe * 5 + spalte] = spieler;
                feldAusgeben(spielbrett);
                spieler = spielerWechsel(spieler);
            }
         }
         feldAusgeben(spielbrett);
         if(gewinnerUeberprufen().equals("unentschieden")) {
            System.out.println("Unentschieden!");
         }
         else {
            spieler = spielerWechsel(spieler);
            System.out.println("Gewonnen hat Spieler " + spieler);
         }
    }


    public static void feldAusgeben (String[] spielbrett) { //* gibt das Brett in 5x5 Form aus
        System.out.println ("|" + spielbrett[0] + "|" + spielbrett[1] + "|" + spielbrett[2] + "|" + spielbrett[3] + "|" + spielbrett[4] + "|");
        System.out.println ("-----------");
        System.out.println ("|" + spielbrett[5] + "|" + spielbrett[6] + "|" + spielbrett[7] + "|" + spielbrett[8] + "|" + spielbrett[9] + "|");
        System.out.println ("-----------");
        System.out.println ("|" + spielbrett[10] + "|" + spielbrett[11] + "|" + spielbrett[12] + "|" + spielbrett[13] + "|" + spielbrett[14] + "|");
        System.out.println ("-----------");
        System.out.println ("|" + spielbrett[15] + "|" + spielbrett[16] + "|" + spielbrett[17] + "|" + spielbrett[18] + "|" + spielbrett[19] + "|");
        System.out.println ("-----------");
        System.out.println ("|" + spielbrett[20] + "|" + spielbrett[21] + "|" + spielbrett[22] + "|" + spielbrett[23] + "|" + spielbrett[24] + "|");
        System.out.println();
    }

	public static void brettFuellen (String[] spielbrett) {  //* nummeriert die einzelnen Felder des Spielfeldes
        	for (int a = 0; a < 25; a++) {
        	spielbrett[a] = " ";
          }
  }

  public static String spielerWechsel (String spieler) {
      if (spieler.equals("X")) {
          spieler = "O";
      }
      else{
          spieler = "X";
      }
      return spieler;
  }

  public static boolean eingabeUeberpruefen (int reihe, int spalte) {
      if (reihe >= 5 || spalte >= 5) {
          System.out.println("Etwas stimmt mit deinen Eingaben nicht.");
          return false;
      }
      if (reihe < 0 || spalte < 0) {
        System.out.println("Etwas stimmt mit deinen Eingaben nicht.");
        return false;
      }
      if (spielbrett[reihe * 5 + spalte] != " "){
        System.out.println("Diese Stelle ist schon ");
        return false;
      }
      return true;
  }

  public static void spielzug (String[] spielbrett, String spieler, int reihe, int spalte) {
        spielbrett[reihe * 5 + spalte] = spieler;
  }

    public static String gewinnerUeberprufen() {  //* Methode welche den Gewinner oder unentschieden als string zurück gibt, sonst null
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
                		detektor = spielbrett[4] + spielbrett[8] + spielbrett[12] + spielbrett[16] + spielbrett [20];
                		break;
              }
        			if (detektor.equals("XXXXX")) {
        				return "X";
          		}
    				  else {
                  if (detektor.equals("OOOOO")) {
            			return "O";
    					    }
              }
        }
     		for (int a = 0; a < 24; a++){  //* auf unentschieden pruefen
            if (spielbrett[a] == " ") {
    		          break;
            }
        		else {
                if (a == 23) {
                    return "unentschieden";
                }
            }
        }
    		return null;
      }


	}
