package Leetcode;

public class productArray {
	public static void main(String args[]){
		int[] arr = new int[10];
		for(int i =0;i<arr.length;i++){
			arr[i] = i+1;
		}
		for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
		System.out.println();
		product(arr);
	}

	private static void product(int[] arr) {
		int[] prod = new int[arr.length];
		
		/* Initialize the product array as 1 */
        for(int j=0;j<arr.length;j++)
            prod[j]=1;
 
        /* In this loop, temp variable contains product of
           elements on left side excluding arr[i] */
		int temp = 1;
		for(int i = 0;i<arr.length;i++){
			prod[i] = temp;
			temp *= arr[i];
		}
		
		/* In this loop, temp variable contains product of
        elements on right side excluding arr[i] */
		temp = 1;
		for(int i = arr.length-1;i>=0;i--){
			prod[i] *= temp;
			temp *= arr[i];
		}
		
		for (int i = 0; i < arr.length; i++)
            System.out.print(prod[i] + " ");
	}
}
