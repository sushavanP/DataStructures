package dataStructures.Arrays;
//Kadane's Algorithm

public class maxSumSubArray
{
    public int subArray(int[] nums){
        int maxSum = nums[0];
        int currentSum = maxSum;
        for(int i = 0; i < nums.length; i++){
            currentSum = Math.max(nums[i] + currentSum, nums[i]);
            maxSum = Math.max(currentSum, maxSum);
        }
        System.out.println(maxSum);
        return maxSum;
    }
    public static void main(String [] args){
        maxSumSubArray ms = new maxSumSubArray();
        int nums[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        ms.subArray(nums);
    }
}
