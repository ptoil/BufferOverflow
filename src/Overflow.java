
public class Overflow {
	public static void main(String[] args) {
		Memory RAM = new Memory();
		/*RAM.writeMemory(20, "p2hi");
		RAM.writeMemory(30, "p6waltuh");
//		RAM.interpret(20);
//		RAM.interpret(30);
		RAM.runMemory();
		RAM.writeMemory(34, "p3lol");
		RAM.runMemory();
		*/
		GUI gui = new GUI(RAM);
		gui.display();
	}
}