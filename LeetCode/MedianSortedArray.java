package Leetcode;

public class MedianSortedArray {
		public static void main(String args[]){
			int[] ar1;
			ar1 = new int[] {2,4,6,8,9};
			int[] ar2;
			ar2 = new int[] {1,3,5,7,9};
			System.out.println("Median:"+ Median(ar1,ar2));
		}
		
		public static int Median(int[] a,int[] b){
			int Median = 0;
			int len1 = a.length;
			int len2 = b.length;
			int i = 0,j = 0,k = 0;
			int [] result = new int[len1+len2];
			while(i < len1 || j < len2){
				if(i == len1){
					result[k++] = b[j++];
					continue;
				}
				else if(j == len2){
					result[k++] = a[i++];
					continue;
				}
				
				if(a[i] <= b[j]){
					result[k++] = a[i++];
				}
				else
					result[k++] = b[j++];
			}
			int mid = (len1+len2)/2;
			if((len1%2 == 0 && len2%2 == 0) || (len1%2 != 0 && len2%2 != 0))
				Median = (result[mid] + result[mid-1])/2;
			else if ((len1%2 == 0 && len2%2 != 0) || (len1%2 != 0 && len2%2 == 0))
				Median = result[mid];
			return Median;
		}
}
