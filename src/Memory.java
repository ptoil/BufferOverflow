import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;


public
class Memory {
	
	private char[] memoryArray;
	private boolean[] freeMemory;
	private final char MEMORY_SIZE = 200;
	
	public Memory() {
		memoryArray = new char[MEMORY_SIZE];
		freeMemory = new boolean[MEMORY_SIZE];
		initializeMemory();
	}
	
	private void initializeMemory() {
		for (int i = 0; i < memoryArray.length; i++) {
			memoryArray[i] = 'j';
			freeMemory[i] = false;
		}
	}
	
	public char[] readMemory(int address, int size) {
//		return Arrays.copyOfRange(memArray, address, address+size);
		char[] a = new char[size];
		for (int i = 0; i < size; i++) {
			a[i] = memoryArray[address + i];
		}
		return a;
	}
	
	public void writeMemory(int address, String buffer) {
		for (int i = 0; i < buffer.length(); i++) {
			memoryArray[address + i] = buffer.charAt(i);
		}
	}
	
	public int interpret(int address) {
		Library lib = new Library(this);
		Method method = null;
		try {
			method = lib.getClass().getMethod(Character.toString(memoryArray[address]), int.class);
		} catch (SecurityException e) {  }
		  catch (NoSuchMethodException e) {  }
		try {
			return (int) method.invoke(lib, address);
		} catch (NullPointerException e) { //if method is null, then there is no method with the specified name
			System.out.println("ERROR: " + memoryArray[address] + " is not a function");
		}
		  catch (IllegalArgumentException e) {  }
		  catch (IllegalAccessException e) {  }
		  catch (InvocationTargetException e) {  }
		return -1; //Java requires this, but it should never be run
	}
	
	public void runMemory() {
		int currentAddress = 0;
		while (currentAddress < MEMORY_SIZE && currentAddress >= 0) {
			currentAddress = interpret(currentAddress);
		}
		
	}
	
	public char[] getMemArray() {
		return memoryArray;
	}
	
	public static void main(String[] args) {
		Memory RAM = new Memory();
		RAM.writeMemory(20, "p2hi");
		RAM.writeMemory(30, "p6waltuh");
//		RAM.interpret(20);
//		RAM.interpret(30);
		RAM.runMemory();
		RAM.writeMemory(34, "p3lol");
		RAM.runMemory();
	}
}
//Output:
/*
hi
waltuh
hi
wap3lo
ERROR: l is not a function 
*/


