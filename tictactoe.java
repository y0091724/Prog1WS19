import java.util.Scanner;

public class tictactoe {

    public static void main (String[] args) {
        char[][] feld = new char [5][5];
        feld = start();
        int spieler = 25;
        /*for(int x = 0; x < 5; x ++)
        {
          for(int y = 0; y < 5; y ++)
          {
            System.out.println(feld[x][y]);
          }
        */
        while (!ueberpruefen(feld)) {
            zug(feld, spieler);
            feldAusgeben(feld);
        }
        System.out.println("Gewonnen");
    }

    public static void feldAusgeben (char[][] feld) {
        System.out.print("-----------");
        for (int x = 0; x < 5; x++) {
            System.out.println();
            for (int y = 0; y < 5; y++) {
                System.out.print("|" + feld[x][y]);
            }
            System.out.println("|");
            System.out.print("-----------");

        }
        System.out.println();
    }

    public static char[][] start () {
        char[][] feld = new char[5][5];
        for (int x = 0; x < 5; x++) {
          for (int y = 0; y < 5; y++) {
            feld[x][y] = ' ';
          }
        }
        return feld;
    }

    public static boolean ueberpruefen (char[][] feld) {
        for (int x = 0; x < 5; x++) {
            if (feld[x][0] == 'X' || feld[x][0] == 'O'){
                int zähler = 1;
                while (feld[x][zähler] == feld[x][0] && zähler < 5) {
                    zähler++;
                }
                if (zähler == 5) {
                    return true;
                }
            }
        }
        for (int y = 0; y < 5; y++) {
            if (feld[0][y] == 'X' || feld[0][y] == 'O'){
                int zähler = 1;
                while (feld[zähler][y] == feld[0][y] && zähler < 5) {
                    zähler++;
                }
                if (zähler == 5) {
                    return true;
                }
            }
        }
        if(feld[0][0] == 'X' || feld[0][0] == 'O') {
            int x = 1;
            int y = 1;
            int zähler = 0;
            while (feld[x][y] == feld[0][0] && x < 5) {
                zähler++;
            }
            if (zähler == 5) {
                return true;
            }
        }
        if(feld[0][0] == 'X' || feld[0][0] == 'O') {
            int x = 1;
            int y = 1;
            int zähler = 0;
            while (feld[x][y] == feld[0][0] && x < 5) {
                zähler++;
            }
            if (zähler == 5) {
                return true;
            }
        }
      return false;
    }
}
