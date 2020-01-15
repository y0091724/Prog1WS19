
public class main {

  public static void main(String args[]) {
      Spielverlauf spiel = new Spielverlauf(10, 23, 5);
      spiel.ausgabeVoll();
      spiel.ausgabe();
      while(spiel.spielzug() && !spiel.gewinnerUeberpruefen()) {
          spiel.ausgabe();
      }
      if(spiel.gewinnerUeberpruefen()) {
        System.out.println("Sie haben gewonnen!!");
      }
      System.out.println("Sie haben verloren, weil sie ein Feld mit Mine betreten haben.");
  }

}
