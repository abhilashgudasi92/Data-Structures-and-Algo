import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        int[] nums = {1,6,3,5,8,2};
        
        ArrayList<Integer> result = twoSumClosest(nums,15);
        System.out.println(result);
     }
     
     private static ArrayList<Integer> twoSumClosest(int[] nums,int target){
         Arrays.sort(nums);
         int result = 0;
         ArrayList<Integer> li = new ArrayList<Integer>(2); 
         li.add(0);
         li.add(0);
         int min = Integer.MAX_VALUE;
         for (int i = 0; i < nums.length; i++) {
            int k = nums.length-1;
            int sum = nums[i] + nums[k];
            int diff = Math.abs(sum - target);
            
            if(diff == 0){
                li.set(0,nums[i]);
				        li.set(1,nums[k]);
				        return li;
            } 
            
            if (diff < min) {
				        min = diff;
                result = sum;
                li.set(0,nums[i]);
                li.set(1,nums[k]);
            }
            if (sum <= target) {
              i++;
            } else {
              k--;
            } 
         }
         return li;
     }
}
