
public class Library {

	Memory RAM;
	
	public Library (Memory r) {
		RAM = r;
	}
	
	public int p (int address) {
		char len = RAM.readMemory(address+1, 1)[0];
		int length = Character.getNumericValue(len);
		char[] output = RAM.readMemory(address+2, length);
		System.out.println(output);
		return address + 2 + length;
	}
	
	public int e (int address) {
		return -1;
	}
	
	public int j (int address) { //jump to next address
		return address + 1;
	}
}
