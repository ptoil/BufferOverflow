package rewriting;

public class fullMemory {

	private DATA[] data;
	private final int RoPSet = 25;
	
	public fullMemory() {
		data = new DATA[RoPSet];
	}
	
	public String runProgram(int address, String output) {
		if (address > 20 || address == data[address].getAddress()) {
			return output + "\n" + data[address].getInfo();
		}
		return runProgram(data[address].getAddress(), output + "  \n" + data[address].getInfo());
	}
	
	public String runProgram() {
		return runProgram(0, "Start: ");
	}
	
	public void putNewData(int address, String info, int location) {
		data[location] = new DATA(address, info);
	}
	
}
