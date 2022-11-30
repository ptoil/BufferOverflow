//package seniorProject;
import java.util.Scanner;

public class Overflow {	
	public static void main(String[] args) {
		Memory RAM = new Memory();
		boolean OFF = false;
		boolean RAF = false;
		boolean WTFF = false;
		boolean SOF = false;
		
		Scanner scanner = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter desired input: ");
	    String input = scanner.nextLine();
	    
	    if (input.length() > RAM.MEMORY_SIZE) {
			WTFF = true;
		}
		
		if (input.length() > 5) {
			OFF = true;
		}

		RAM.writeMemory("Toast", 5, "p");
		RAM.writeMemory("Toast", 5, "p");
		RAM.writeMemory("Toast", 5, "p");
		RAM.runMemory();
		
		RAM.push("ABCDE");
		RAM.push("FGHIJ");
		RAM.push("KLMNO");
		RAM.pop();
		RAM.push(input);
	
		char[] squanto = RAM.RETURNPOP(40);
		
		System.out.println(Memory.SSP);
		String squinto = "";
		for (int i = 0; i<squanto.length;i++) {
			squinto = squinto + squanto[i];
		}
		System.out.println(squinto);
		GUI gui = new GUI(RAM);
		gui.display();
		
		if (squinto != "?????" || WTFF == true) {
			SOF = false;
		} 
		
		if (!squinto.contentEquals("FGHIJ")) {
			RAF = true;
		}
		
		if (RAF == true && WTFF == false && OFF == true && squinto.contentEquals("?????")){
			SOF = true;
		}
		
		System.out.println("Return Address Flag: " + RAF);
		System.out.println("Overflow Flag: " + OFF);
		System.out.println("Way To Far Flag: " + WTFF);
		System.out.println("Success Flag: " + SOF);
	}
}
	
	/*	  
	  //RAM.push("11111111111111111111"); // 20 1's. 21 1's would result in a crash / out of bounds.
		
		/*
		 We can probably simulate flags by using try/catch exceptions to throw errors and shit if things get fucked
		 or deviate from the norm.
		 
		 Things to think about:
		 
		 Flags that act as the criteria (true or false with their own conditional checkers and shit) 
		 to check and see whether or not the overflow is a genuine overflow, the right overflow, or a half ass
		 fuckin retarded overflow that didn't do its job correctly (what a fuck up).
		 
		 
		 Too Far Flag (Did the overflow do more than it needed to? Check to see the next segment after the designated RETURNPOP
		 			   has deviated whatsoever. For instance, is "KLMNO" touched at all? If so, this flag does its job of becoming
		 			   "TRUE.")
		 ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
		 Removed for Convenience.
		 
		 So flags: 
		 
		 Overflow Flag (Did the thing overflow? Check and see if input length is 5<)
		 
		 Return Address Flag (Did the overflow at least reach the return address? Check and see if the return address deviates
		 					  Usually preset to fit the problem. In this case, if the RAF isn't "FGHIJ" exactly, then this flag
		 					  gets triggered to show that its intended return address was effected by the input.)
		 
		 Way Too Far Flag (WTFF means you've overflown the entire fuckin' memory, dude. Check to see if input is greater than 
		 				   the size of the memory. If true, signal this flag.)
		 
		 Successful Overflow Flag (Did the overflow actually overried what it need to completely? Check to see if the new RETURNPOP
		 						   value is equivalent to the desired overflow (or answer in this case). Then, check this flag.
		 						   This flag, if TRUE, means that it was a success! It's a culmination of all the other flags 
		 						   and itself. So let's go through what the conditions should be 
		 						   
		 						   Our desired overflow is: ?????
		 						   So, we check:
		 						   Is our RETURNPOP equal to desired overflow? If yes, there are a few other things:
		 						   
		 						   Overflow Flag: TRUE
		 						   Return Address Flag: TRUE
		 						   Way Too Far Flag: FALSE
		 						   
		 						   If these deviate in any way (With the exception of the TFF), then the flag is not to be given.
		 						   
		 						   If they don't, this flag is TRUE and you've successfully overflown the shit.)
	
	// Push and Pop increment / decrement by 5. We could easily just have a pointer that reads through the five indexes before compiling them into
	// another register that conveys them as a sort of output. 
	// SR = Stack Reader (Reads through increments of 5 before pumping them out)
	
	// SSP = System Stack Pointer, tells us where the top of the stack is, increments up and down by 5 depending on push/pop
		// Integer variable stored wherever the Stack class is.
		
	   int SSP = 50;
	
	// PUSH is generically pushing information onto the stack - pushes 5 but who gives a shit	
		// Automatically increments the SSP by 5.
		 
	   private void push(String input){ // char for the sake of memory being in characters
	   char[] toBePushed = String.toCharArray(input)
	   int tempSSP = Memory.SSP;
	   	for (int i  = 0 ; i<intput.length ; i++){
	   		Memory[tempSSP] = toBePushed[i];
	   		tempSSP-1;
	   	{
	   	
	   	Memory.SSP = Memory.SSP - 5     // pushing such that the top 5 addresses are now occupied
	   }
	
	// POP is generically popping information from the stack - removes 5 fuck it
		// Automatically decrements the SSP 5.
	
	private void pop(){
	   	Memory.SSP = Memory.SSP + 5
	   }
	
	
	// JUMP-TO-SUBROUTINE command PUSHES the return address onto the stack - SPECIFIC to the RETURN ADDRESS
		// Automatically increments the SSP by 5.
		// Reads all positions of the variable before pushing them to the stack as a STRING. for instance, 500 becomes [00500] (always read left 
		// to right for the sake of consistency) and is seen in the GUI in that way. 
	
	// RETURN-FROM-SUBROUTINE command POPS a command as a return address - THE ONLY METHOD THAT MATTERS FOR RETURNING A VALUE
		// Integer.parseInt() WORKS for our purposes of reading and deriving a proper INTEGER return address to compare the equivalence to.
		
	private char[] RETURNPOP(){
	   	char[] HERE;
	   	int tempSSP = Memory.SSP;
	   	for (int i  = 0 ; i<5 ; i++){
	   		Memory[tempSSP] = HERE[i];
	   		tempSSP+1;
	   	{
	   	Memory.SSP = Memory.SSP + 5
	   	return HERE;
	   }
		
	// There are generic pushes and pops, and RETURN ADDRESS specific pushes and pops.
	
	*/
