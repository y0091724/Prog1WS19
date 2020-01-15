import java.util.Scanner;

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

  public boolean gewinnerUeberpruefen() {
      for(int zaehler1 = 0; zaehler1 < feld.getSpielfeld().length; zaehler1++) {
          for(int zaehler2 = 0; zaehler2 < feld.getSpielfeld().length; zaehler2++) {
              if(feld.getSpielfeld()[zaehler1][zaehler2].getAufgedeckt() == false) {
                return false;
              }
          }
      }
      return true;
  }

  public boolean spielzug() {
      Scanner eingabeKo = new Scanner(System.in);
      System.out.println("Geben sie die nächsten Koordinaten ein (z.B. H4): ");
      eingabeKo.useDelimiter("");
      Koordinaten ko = new Koordinaten(eingabeKo.next().charAt(0), eingabeKo.nextInt());
      while(!ko.korrektheit()) {
          eingabeKo = new Scanner(System.in);
          System.out.println("Etwas stimmt mit ihren Eingaben nicht. Versuchen sie es erneut: ");
          System.out.println("Geben sie die nächsten Koordinaten ein (z.B. H4): ");
          eingabeKo.useDelimiter("");
          ko = new Koordinaten(eingabeKo.next().charAt(0), eingabeKo.nextInt());
      }
      System.out.println("Geben sie ihre naechste Aktion ein (1 für 'aufdecken', 2 fuer 'entschaerfen'): ");
      eingabeKo = new Scanner(System.in);
      int akt = eingabeKo.nextInt();
      if(akt == 1) {
          int ergebnis = aufdecken(ko);
          if(ergebnis == 0) {
              return false;
          }
          if(ergebnis == 2) {
              System.out.println("An dieser Stelle ist schon aufgedeckt. Es passiert nichts.");
              return true;
          }
      }
      if(akt == 2) {
          int ergebnis = entschaerfen(ko);
          if(ergebnis == 1) {
              return true;
          }
          if(ergebnis == 2) {
              System.out.println("An dieser Stelle ist schon aufgedeckt. Es passiert nichts.");
          }
          if(ergebnis == 0) {
              System.out.println("An dieser Stelle ist keine Mine.");
          }
      }
      return true;
  }

  public int aufdecken(Koordinaten ko) {
      int spalte = ko.getSpalte();
      int reihe = ko.getReihe();
      if(feld.getSpielfeld()[reihe][spalte] instanceof Landmine) {
          return 0;
      }
      if(feld.getSpielfeld()[reihe][spalte].getAufgedeckt() == false) {
          feld.getSpielfeld()[reihe][spalte].setAufgedeckt(true);
          return 1;
      }
      if(feld.getSpielfeld()[reihe][spalte].getAufgedeckt() == true) {
          return 2;
      }
      return 2;
  }

  public int entschaerfen(Koordinaten ko) {
      int spalte = ko.getSpalte();
      int reihe = ko.getReihe();
      if(feld.getSpielfeld()[reihe][spalte].getAufgedeckt() == true) {
          return 2;
      }
      if(feld.getSpielfeld()[reihe][spalte] instanceof Landmine) {
          feld.getSpielfeld()[reihe][spalte].setAufgedeckt(true);
          return 1;
      }

      return 0;
  }

    public void ausgabeVoll() {
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

}
