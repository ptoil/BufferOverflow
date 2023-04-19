
import java.util.Scanner;
import java.util.HashMap;


class checkClib{
	public static boolean checkClibValue(String val) {
		switch (val) {
		case "55555":
			return true;
		case "66666":
			return true;
		case "77777":
			return true;	
		case "88888":
			return true;
		case "99999":
			return true;
		}
		return false;
	}
}

public class Overflow {	
	public static void main(String[] args) {
		Memory RAM = new Memory();
		boolean OFF = false;
		boolean RAF = false;
		boolean WTFF = false;
		boolean SOF = false;
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter desired input: ");
	    String input = scanner.nextLine();
	   

		//RAM.writeMemory("CLIB:SSSSS:END");
	    RAM.writeMemory("pRetard");
		RAM.runMemory();
		
		RAM.push("ABCDE");
		RAM.push("FGHIJ");
		RAM.push("KLMNO");
		RAM.pop();
		RAM.push(input);
	
		char[] squanto = RAM.RETURNPOP(40);
		
		System.out.println(Memory.SSP);
		String squinto = "";
		for (int i = 0; i<squanto.length;i++) {
			squinto = squinto + squanto[i];
		}
		System.out.println(squinto);
		
		
	    if (input.length() > RAM.MEMORY_SIZE) {
			WTFF = true;
		}
		if (input.length() > 5) {
			OFF = true;
		}
		if (squinto != "?????" || WTFF == true) {
			SOF = false;
		} 
		if (!squinto.contentEquals("FGHIJ")) {
			RAF = true;
		}
		if (RAF == true && WTFF == false && OFF == true && (squinto.contentEquals("?????") || squinto.contentEquals("SSSSS"))){
			SOF = true;
		}

		boolean LBC = checkClib.checkClibValue(squinto);
		System.out.println("Return Address Flag: " + RAF);
		System.out.println("Overflow Flag: " + OFF);
		System.out.println("Success Flag: " + SOF);
		System.out.println("LibC Flag: " + LBC);
		
		HashMap<String, Boolean> flags = new HashMap<String, Boolean>();
		flags.put("Return Address Flag", RAF);
		flags.put("Overflow Flag", OFF);
		flags.put("Success Flag", SOF);
		flags.put("LibC Flag", LBC);
		
		GUI gui = new GUI(RAM, flags);
		gui.display();
	}
}
	
	
