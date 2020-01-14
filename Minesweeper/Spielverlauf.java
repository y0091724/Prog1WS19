
public class Spielverlauf {

  private Spielfeld feld;

  public Spielverlauf(int n, int x, int v) {
      feld = new Spielfeld(n, x, v);
  }

  public void ausgabe() {
      System.out.println(" |A|B|C|D|E|F|G|H|I|J");
      for(int zaehler1 = 0; zaehler1 < feld.getSpielfeld().length; zaehler1++) {
          System.out.print(zaehler1);
          for(int zaehler2 = 0; zaehler2 < feld.getSpielfeld().length; zaehler2++) {
              System.out.print("|");
              if(feld.getSpielfeld()[zaehler1][zaehler2].getAufgedeckt() == true) {
                  if(feld.getSpielfeld()[zaehler1][zaehler2] instanceof Landmine) {
                      System.out.print("X");
                  }
                  else {
                      System.out.print(feld.getSpielfeld()[zaehler1][zaehler2].getAnzMin());
                  }
              }
              else {
                  System.out.print(" ");
              }
          }
          System.out.println();
      }
  }

  /*  public void ausgabeVoll() {
        System.out.println(" |A|B|C|D|E|F|G|H|I|J");
        for(int zaehler1 = 0; zaehler1 < feld.getSpielfeld().length; zaehler1++) {
            System.out.print(zaehler1);
            for(int zaehler2 = 0; zaehler2 < feld.getSpielfeld().length; zaehler2++) {
                System.out.print("|");
                if(feld.getSpielfeld()[zaehler1][zaehler2] instanceof Landmine) {
                    System.out.print("X");
                }
                else {
                    System.out.print(feld.getSpielfeld()[zaehler1][zaehler2].getAnzMin());
                }
            }
            System.out.println();
        }
    }
    */
}
