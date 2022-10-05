
public class Overflow {
	public static void main(String[] args) {
		Memory RAM = new Memory();
		RAM.writeMemory(20, "p5hello");
		RAM.writeMemory(30, "p6world!");
//		RAM.interpret(20);
//		RAM.interpret(30);
		RAM.runMemory();
		
		GUI gui = new GUI(RAM);
		gui.display();
	}
}