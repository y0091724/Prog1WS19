import java.util.Scanner
	

public class coordinates {
  	public string[] coords = new string[1];
	Scanner xCoordsSc = new Scanner(System.in);
	Scanner yCoordsSc = new Scanner(System.in);
  	private int xCoords;

  	public void getcoordinates() {
  	System.out.println ("Geben Sie Ihre X-Koordinate (A-J) an");
	coords[0] = xCoordsSc.nextLine();
	System.out.println ("Geben Sie Ihre Y-Koordinate (0-9) an"); 
	coords[1] = yCoordsSc.nextLine();
		}



	public static boolean checkInput() {
	if (coords[0] < 0 || coords[1] > 9) {
	System.out.println("Etwas stimmt mit deinen Eingaben nicht");
	return false;
	}
	if (coords 0 > 9 || coords[1] < 0) {
	System.out.println("Etwas stimmt mit deinen Eingaben nicht");
	return false;
	}
	return true;
	}
