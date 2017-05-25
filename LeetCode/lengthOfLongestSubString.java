package Leetcode;

import java.util.HashMap;

public class lengthOfLongestSubString {
	
	public static void main(String []args){
		lengthOfLongestSubString p = new lengthOfLongestSubString();
		String inp = "abcabcdab";
		System.out.println("Input string:" + inp);
		System.out.println("Length of Longest substring is: " + p.longSub(inp));
	}

	public int longSub(String inp) {
		if(inp.length() == 0) 
			return 0;
		int max = 0;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0,j=0;i<inp.length();i++){
			if(map.containsKey(inp.charAt(i))){
				j = Math.max(j, map.get(inp.charAt(i))+1);
			}
			map.put(inp.charAt(i),i);
			max = Math.max(max, i-j+1);
		}
		return max;
	}
}
