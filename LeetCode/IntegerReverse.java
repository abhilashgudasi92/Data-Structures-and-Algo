package Leetcode;

public class IntegerReverse {
	public static void main(String args[]){
		int inp = 10023;
		System.out.println("Reveresed integer is: " + revInt(inp));
	}

	private static int revInt(int inp) {
		    long reversedNum = 0;

		    long input_long = inp;

		    while (input_long != 0)
		    {
		        reversedNum = reversedNum * 10 + input_long % 10;
		        input_long = input_long / 10;
		    }

		    if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
		    {
		        throw new IllegalArgumentException();
		    }
		    return (int)reversedNum;
	}
}
