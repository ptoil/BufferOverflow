import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public
class Memory {
	
	private char[] memArray;
	private final char MEMORY_SIZE = 200;
	
	public Memory(int size) {
//		memArray = new char[MEMORY_SIZE];
		memArray = new char[size];
		initializeMemory();
	}
	
	private void initializeMemory() {
		for (int i = 0; i < memArray.length; i++) {
			memArray[i] = '0';
		}
	}
	
	public char[] readMemory(int address, int size) {
//		return Arrays.copyOfRange(memArray, address, address+size);
		char[] a = new char[size];
		for (int i = 0; i < size; i++) {
			a[i] = memArray[address + i];
		}
		return a;
	}
	
	public char[] getMemArray() {
		return memArray;
	}
	
	public void writeMemory(int address, String buffer) {
		for (int i = 0; i < buffer.length(); i++) {
			memArray[address + i] = buffer.charAt(i);
		}
	}
	
	public int getIndex(String buffer) {
		return 0; //temp
	}
	
	public static void a() {
		System.out.println("a was run");
	}
	
	public static void b() {
		System.out.println("b was run");
	}
	
	public static void c() {
		System.out.println("c was run");
	}
	
	public static void main(String[] args) {
		Memory RAM = new Memory(10);
		System.out.println(RAM.getMemArray());
		RAM.writeMemory(2, "hi");
		System.out.println(RAM.getMemArray());
		RAM.writeMemory(3, "yo");
		System.out.println(RAM.getMemArray());
		System.out.println(RAM.readMemory(2, 3));
		
		String methodName = "b";
		java.lang.reflect.Method method = null;
		try {
			method = RAM.getClass().getMethod(methodName);
		} catch (SecurityException e) {  }
		  catch (NoSuchMethodException e) {  }
		try {
			method.invoke(RAM);
		} catch (IllegalArgumentException e) {  }
		  catch (IllegalAccessException e) {  }
		  catch (InvocationTargetException e) {  }
	}
}
