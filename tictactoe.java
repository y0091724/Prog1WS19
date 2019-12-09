public class tictactoe {

    public static void main (String[] args) {
        char[][] feld = new char [5][5];
        feld[0][0] = 'O';
        feld[0][1] = 'O';
        feld[0][2] = 'O';
        feld[0][3] = 'O';
        feld[0][4] = 'O';
        if(ueberpruefen (feld))
        {
          System.out.println("Gewinner");
        }
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
