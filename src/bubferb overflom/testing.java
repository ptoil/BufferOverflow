package seniorProject;



public class testing {
	
	
	public static char setAddress (int val) {
		   char nVal = (char) val;
		   return nVal;
		}
	
	public static int getAddress (char val) {
		   int nVal = (int) val;
		   return nVal;
		}
	
	public static void main(String[] args) {
		//int[] fuck = new int[255];
		char[] wack = new char[10];
		
		for (int i = 0 ; i<10 ; i++) {
			wack[i] = (char) i;
		}
		
		System.out.println("Without: " + wack[7]);
		System.out.println("GetAdd: " + getAddress(wack[7]));
		
		//wack[6] = modAddress(10);
		System.out.println("Without: " + wack[6]);
		System.out.println("GetAdd: " + getAddress(wack[6]));
		
		
		
		/*
		for (int i = 0 ; i<255 ; i++) {
			fuck[i] = i;
			char ch = (char) fuck[i];
			System.out.println(ch + " ");
		}*/		
	}
}
