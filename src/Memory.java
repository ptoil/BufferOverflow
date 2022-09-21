import java.util.Arrays;

public class Memory {
	
	private char[] memArray;
	private final char MEMORY_SIZE = 200;
	
	public Memory() {
		memArray = new char[MEMORY_SIZE];
	}
	
	public char[] readMemory(int address, int size) {
		return Arrays.copyOfRange(memArray, address, address+size);
	}
	
	public void writeMemory(int address, char[] buffer) {
		for (int i = 0; i < buffer.length; i++) {
			memArray[address + i] = buffer[i];
		}
	}
	
	public int getIndex(char[] buffer) {
		return 0;
	}
}
