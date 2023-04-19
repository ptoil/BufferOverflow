

public class Library {

	Memory RAM;
	
	public Library (Memory r) {
		RAM = r;
	}
	
	/* All methods take the memory address they were run from as input
	 * and return the next memory address to run.
	 */
	public int p (int address) {
		//char len = RAM.readMemory(address+1, 6)[0]; //next value after p is how many characters to print
		char[] output = RAM.readMemory(address+1, 6); //get characters to print from memory
		System.out.println(output);
		return address + 7; //return address after p and the characters that are printed //2 is to include 'p' and the length digit
	}
		
	public int e (int address) { //empty data, dont jump anywhere
		return -1;
	}
	
	public int j (int address) { //jump to next address
		return address + 1;
	}
	
	
	
}