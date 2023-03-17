package rewriting;

public class RoPRun {
	
	public static void main(String[] args) {
		
		fullMemory cunt = new fullMemory();
		
		cunt.putNewData(3, "print statement1", 0);
		cunt.putNewData(4, "print statement2", 1);
		cunt.putNewData(5, "print statement3", 2);
		cunt.putNewData(1, "print statement4", 3);
		cunt.putNewData(2, "print statement5", 4);
		cunt.putNewData(15, "print statement6", 5);
		
		cunt.putNewData(16, "3", 15);
		cunt.putNewData(17, "+", 16);
		cunt.putNewData(17, "7", 17);
		
		System.out.println(cunt.runProgram());
		
		fullMemory sys = new fullMemory();
		sys.putNewData(1, "the", 0);
		sys.putNewData(2, "at", 1);
		sys.putNewData(3, "toad", 2);
		sys.putNewData(4, "rock", 3);
		sys.putNewData(5, "off", 4);
		sys.putNewData(6, "fell", 5);
		sys.putNewData(7, "landed", 6);
		sys.putNewData(8, "died", 7);
		sys.putNewData(9, "lived", 8);
		sys.putNewData(9, "of", 9);
		System.out.println(sys.runProgram());
		
		
		fullMemory tur = new fullMemory();
		tur.putNewData(3, "the", 0);
		tur.putNewData(2, "at", 1);
		tur.putNewData(2, "toad", 2);
		tur.putNewData(5, "rock", 3);
		tur.putNewData(9, "off", 4);
		tur.putNewData(4, "fell", 5);
		tur.putNewData(6, "landed", 6);
		tur.putNewData(7, "died", 7);
		tur.putNewData(8, "lived", 8);
		tur.putNewData(9, "of", 9);
		System.out.println("\n\n\n" + tur.runProgram());
		
	}
}
