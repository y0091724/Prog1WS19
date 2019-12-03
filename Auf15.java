public class Auf15{

static int breite = 0; //breite der Landschaft (entspricht der x-Achse)
static int höhe = 0; //höhe der Landschaft (entspricht der y-Achse)

    public static void main (String []args){
      if (prüfeAufGültigkeit (args)){
        char[][] landschaft = arrayErstellen(args);
        arrayFüllen(landschaft, args);
        arrayAusgabe(landschaft);
        System.out.println("Die Menge an Wasser beträgt " + wasserBerechnen(landschaft));
        arrayAusgabe(landschaft);
      }
    }

    /**
    *Prüft die Gültigkeit des Kommandozeilenparameter. Also ob das erste Element gleich der Länge von dem Array im Parameter - 1 ist,
    *weil das erste Element die breite der Landschaft beschreibt.
    *@param kommPara Die Kommandozeilenparameter
    *@return Wahr für eine gültige Kommandozeilenparameter und falsch für einen nicht gültigen Kommandozeilenparameter
    */


    //Im folgenenden Code wurde kommPara als abkürzung für Kommandozeilenparameter verwendet.

    public static boolean prüfeAufGültigkeit (String [] kommPara){ //Also wird hier beim Aufruf der Methode im Parameter der Kommandozeilenparamter (args) erwartet.
      breite = Integer.parseInt(kommPara [0]);
      if(breite == (kommPara.length - 1)){
        return true;
      }
      System.out.println("Die angegebene Größe stimmt mit der Anzahl der Elemente nicht ein. Bitte überprüfen sie ihr eingaben.");
      return false;
    }

    /**
    *Gibt ein 2d-Array aus mit den Eingaben aus dem Kommandozeilenparameter.
    *@param kommPara Die Kommandozeilenparameter
    *@return Ein 2d Array vom Typ char mit der im Kommandozeilenparameter Breite und der Höhe vom größten angegeben Element(außer dem ersten)
    */

    public static char[][] arrayErstellen(String [] kommPara){
      höhe = 0;
      for (int x = 1; x < kommPara.length; x++){ //Ermittlung des größten Elements mit die Größe des Arrays klar ist.
        int i = Integer.parseInt(kommPara[x]);
        if (höhe < i){
          höhe = i;
        }
      }
      char[][] landschaft = new char [breite][höhe];
      return landschaft;
    }

    /**
    *Füllt ein Array vom Typ char mit 'X', wenn das entsprechende Element von kommPara kleiner oder gleich groß ist und mit ' ', wenn es größer ist
    *@param landschaft Das Array vom Typ char was gefüllt werden soll
    *@param kommPara Enspricht dem Kommandozeilenparameter. Damit wird das Array landschaft gefüllt
    */

    public static void arrayFüllen(char[][] landschaft, String[] kommPara){
      for(int x = 0; x < breite; x++){
        int inhalt = Integer.parseInt(kommPara[x+1]); //x+1, weil das erste Element in dem Kommandozeilenparameter die Breite angibt und kein Inhalt von der Landschaft ist
        for(int y = 0;y < höhe; y++){
          if(inhalt > y){
            landschaft[x][y] = 'X'; //'X' für einen Block s. Abb. 2
          }
          else{
            landschaft[x][y] = ' '; //' ' für keinen Block
          }
        }
      }
    }

    /**
    *Gibt das im Parameter angegebene Array in Matrix Form aus.
    *@param landschaft Ein Array vom Datentyp char welches das im Kommandoteilenparameter angegebene Landschaft beschreibt.
    */

    public static void arrayAusgabe(char[][] landschaft){
      for(int y = landschaft[0].length - 1; y >= 0; y--){
        for(int x = 0; x < landschaft.length; x++){
          System.out.print(landschaft[x][y] + " ");
        }
        System.out.println();
      }
    }

    /**
    *Berechnet wie viel Wasser in die im Parameter angegebene Lanschaft passt. Fügt in dem Array '~' ein, wo Wasser sein könnte.
    *@param landschaft Ein Array vom Datentyp char welches das im Kommandozeilenparameter angegebene Landschaft beschreibt.
    *@return Die Menge an Wasser die in die Landschaft reinpasst.
    */

    public static int wasserBerechnen(char[][] landschaft){
      int wasser = 0;     //feststehendes Wasser
      if (breite <= 2){   //schließt den Fall aus dass das Array nur 2 Breit ist, wo die Wassermenge = 0 ist
        return 0;
      }
      for (int x = 0; x + 2 < breite; x++){   //x + 2 weil wenn wir x überprüfen ob dort ein Block ist muss x+2 noch in dem Bereich vom Array liegen
        for (int y = 0; y < höhe; y++){
          if(landschaft[x][y] == 'X' && landschaft[x+1][y] == ' '){     //wenn [x][y] ein Block ist und der Block rechts daneben [x + 1][y] kein Block ist
            int möglichesWasser = 0;
            int zählerRechts = 0;
            while(x + 1 + zählerRechts < breite && landschaft[x + 1 + zählerRechts][y] == ' '){   //solange x + 1 + unseren Zähler noch im Bereich unseres Array liegt und [x + 1 + z][y] kein Block ist
              möglichesWasser++;    //wird unser mögliches Wasser erhöht
              zählerRechts++;                  //und unser Zähler wie wir uns nach rechts bewegen erhöht
            }        //nun wurde die While-Schleife entweder abgebrochen, weil wir außerhalb des Arrays sind oder wir einen Block erreicht haben [x + 1 + z][y] = 'X'
            if(x + 1 + zählerRechts < breite){  //wenn wir noch im Bereich des Arrays sind
              for(int a = x + 1; a < x + zählerRechts + 1;a++){  //hier setzten wir nun im Array '~' ein wo Wasser ist
                  landschaft[a][y] = '~';
              }
              wasser = wasser + möglichesWasser;    //das festehende Wasser wird erhöht
            }
          }
        }
      }
      return wasser;
    }

}
