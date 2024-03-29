package seniorProject;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


@SuppressWarnings("unused")
public
class Memory {
	
	private char[] memoryArray;
	private boolean[] freeMemory;
	public final char MEMORY_SIZE = 50;
	public static int SSP = 50;
	
	public Memory() {
		memoryArray = new char[MEMORY_SIZE];
		freeMemory = new boolean[MEMORY_SIZE];
		initializeMemory();
	}
	
	private void initializeMemory() {
		for (int i = 0; i < memoryArray.length; i++) {
			memoryArray[i] = 'j';
			freeMemory[i] = true;
		}
	}
	
	public char[] readMemory(int address, int size) {
		char[] a = new char[size];
		for (int i = 0; i < size; i++) {
			a[i] = memoryArray[address + i];
		}
		return a;
	}
	
	public void writeMemory(String word, String intention) {
		int empt = findEmpty(this);
		word = intention + word; // Should be equal to or less than 7 for full effect. 3 spaces will be reserved in Call Stack (At the end of memory)
								 // To denote the return address.
		if (empt != -1) {
			if (word.length() > 7) {
				System.out.println("We've entered grounds of fucking things up");
			}
		for (int i = 0; i < 7; i++) {
			memoryArray[empt + i] = word.charAt(i);
			freeMemory[empt + i] = false;
		}
	}
}
	
	public void writeMemory(String word) {
		int empt = findEmpty(this);
		for (int i = 0; i < word.length(); i++) {
			memoryArray[empt + i] = word.charAt(i);
			freeMemory[empt + i] = false;
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
	
	public int emptyPointer() {
		for (int i = 0; i < MEMORY_SIZE; i++) {
			System.out.println(i);
			System.out.println(freeMemory[i]);
			if (freeMemory[i] == true) {
				return i;
			}
		}
		return -1;
	}
	
	public char[] getMemArray() {
		return memoryArray;
	}
	
	public int findEmpty(Memory f) {
		int check = f.emptyPointer();
		return check;
	}
	
	public void push(String input){ // char for the sake of memory being in characters
		if (Memory.SSP == 29) {
			throw null;
		}
		Memory.SSP = Memory.SSP - 5;    // pushing such that the top 5 addresses are now occupied
		   char[] toBePushed = input.toCharArray();
		   int tempSSP = Memory.SSP;
		   	for (int i  = 0 ; i<input.length() ; i++){
		   		memoryArray[tempSSP] = toBePushed[i];
		   		freeMemory[tempSSP] = false;
		   		tempSSP++;
		   	}
		   	
		   }
		
	public void pop(){
		   	Memory.SSP = Memory.SSP + 5;
		   }
	
		@SuppressWarnings("null")
	public char[] RETURNPOP(int target){
		   	char[] HERE = new char[5];
		   	int tempSSP = target; // Memory.SSP;
		   	for (int i  = 0 ; i<5 ; i++){
		   		HERE[i] = memoryArray[tempSSP];
		   		System.out.println(memoryArray[tempSSP]);
		   		freeMemory[tempSSP] = true;
		   		tempSSP++;
		   	}
		   	Memory.SSP = Memory.SSP + 5;
		   	return HERE;
		   }		
}
