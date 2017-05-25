package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class targetSum {

	public static void main(String args[]){
		targetSum p = new targetSum();
		int[] inp = {1,2,3,4,5,6};
		int target = 7;
		
		int[] res = new int[2];
		
		res = p.twoSum(inp,target);
		System.out.println("Indices are" + res[0] + " and " + res[1]);
	}

	public int[] twoSum(int[] inp, int target) {
		Map<Integer,Integer> map = new HashMap<> ();
		for(int i = 0; i < inp.length;i++){
			map.put(inp[i],i);
		}
		int compliment = 0;
		for(int i = 0; i < inp.length;i++){
			compliment = target - inp[i];
			if(map.containsKey(compliment) && map.get(compliment) != i){
				return new int[] {i,map.get(compliment)};
			}	
		}
		throw new IllegalArgumentException("No two sum solution");
	}
}
