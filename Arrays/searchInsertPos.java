package dataStructures.Arrays;

public class searchInsertPos
{
    public int searchInsert(int[] nums, int target){
        int i;
        for(i = 0; i < nums.length; i++){
            if(nums[i] == target){
                return i;
            }
        }
        for(i = 0; i < nums.length; i++){
            if(nums[i] > target){
                return i;
            }
        }
        return i;
    }
    public static void main(String[] args){
        searchInsertPos pos = new searchInsertPos();
        int nums[] = {1, 3, 5, 6};
        int posi = pos.searchInsert(nums, 7);
        System.out.println(posi);
        posi = pos.searchInsert(nums, 5);
        System.out.println(posi);
    }
}
