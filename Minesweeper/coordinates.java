import java.util.Scanner
	

public class coordinates {
  	public char[] coords = new char[1];
	Scanner CoordsSc = new Scanner(System.in);
  	private String xCoords;

  	public void getcoordinates() {
  	System.out.println ("Geben Sie Ihre Koordinaten in der Form A0 an (A-J, 0-9)");
	String xCoords = CoordsSc.nextLine();
	coords[0] = xCoords.charAt(0);
	coords[1] = xCoords.charAt(1);
		}



	public static boolean checkInput() {
	if (Integer.valueOf(coords[0]) < 65 || Integer.valueOf(coords[0] > 74) {
	System.out.println("Deine Eingaben sind nicht korrekt (A-J,0-9)");
	return false;			
	}
	if (Integer.valueOf(coords[1]) < 48 || Integer.valueOf(coords[1] > 57) {
	System.outprintln("Deine Eingaben sind nicht korrekt(A-J,0-9)");
	return false;
	}
	return true;
	} 
	
