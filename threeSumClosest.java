import java.util.*;
public class HelloWorld{

     public static void main(String []args){
        int[] nums = {1,6,3,5,8,2};
        
        int result = threeSumClosest(nums,20);
        System.out.println(result);
     }
     
     public static int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
          int j = i + 1;
          int k = nums.length - 1;
          while (j < k) {
            int sum = nums[i] + nums[j] + nums[k];
            int diff = Math.abs(sum - target);

            if(diff == 0) return sum;

            if (diff < min) {
              min = diff;
              result = sum;
            }
            if (sum <= target) {
              j++;
            } else {
              k--;
            }
          }
        }
    	  return result;
      }
}
