import java.util.Scanner;

public class tictactoe {
 

         static String spielzug;
         static String[] spielbrett;
         static String gewinner; 
         static Scanner eingabe
    public static void main (String[] args) {
         spielbrett = new String[24];	
         spielzug = 'X'
         gewinner = null;
         System.out.println("Spieler X fängt an, danach ist Spieler 0 dran");
         System.out.println("                                             ");
 

        
    public static void feldAusgeben (String[] spielbrett) { //* gibt das Brett in 5x5 Form aus 
    System.out.println ("| "spielbrett[0]" | "spielbrett[1]" | "spielbrett[2]" | "spielbrett[3]" | "spielbrett[4]" |");
    System.out.println ("----------------");
    System.out.println ("| "spielbrett[5]" | "spielbrett[6]" | "spielbrett[7]" | "spielbrett[8]" | "spielbrett[9]" |");
    System.out.println ("----------------");
    System.out.println ("| "spielbrett[10]" | "spielbrett[11]" | "spielbrett[12]" | "spielbrett[13]" | "spielbrett[14]" |");
    System.out.println ("----------------");
    System.out.println ("| "spielbrett[15]" | "spielbrett[16]" | "spielbrett[17]" | "spielbrett[18]" | "spielbrett[19]" |");
    System.out.println ("----------------");
    System.out.println ("| "spielbrett[20]" | "spielbrett[21]" | "spielbrett[22]" | "spielbrett[23]" | "spielbrett[24]" |");
}
    }
	public static void brettFuellen(String[] spielbrett) {  //* nummeriert die einzelnen Felder des Spielfeldes
        	for (int a = 0, a < 25, a++) {
        	spielbrett[a] = String.valueOf[a+1];
}
}
    public static String() gewinnerUeberprufen {  //* Methode welche den Gewinner oder unentschieden als string zurück gibt, sonst null
    	for (int a = 0, a < , a++) {
    		String detektor = null;
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
				else if (detektor.equals("00000")) {				
				return "0"; 
					}
				
 		 for (int a = 0, a < 24, a++)  //* auf unentschieden pruefen
                  if (array.asList(spielfeld)contains(String.valueOf(a+1))) {
		  break;
		}
		else if (a == 23) return "unentschieden";
		}
		System.out.println(zug + "ist dran, setze" + Zug + "auf eine Nummer");
		return null;
		}        
	}