package Leetcode;

public class anyBasetoDecimal {
	public static void main(String args[]){
		String inp = "1100";
		int base = 2;
		System.out.println("Conversion of input" + inp + "from base " + base +"to decimal is " + convertDecimal(inp,base));
	}

	//Function to convert string input to integer
	@SuppressWarnings("unused")
	private static int val(char c){
		if(c>= '0' && c <='9'){
			return c - '0';
		}
		else
			return c -'A' + 10;
	}
	
	// Function to convert given number (base) to decimal equivalent
	private static int convertDecimal(String inp, int base) {
		int pow =1,num = 0,i;
		
		for(i = inp.length()-1;i>=0;i--){
			if(val(inp.charAt(i)) >= base){
				System.out.println("Invalid number");
				return -1;
			}
			num += val(inp.charAt(i)) * pow;
			pow *= base;
		}
		return num;
	}

}
