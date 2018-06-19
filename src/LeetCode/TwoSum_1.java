package LeetCode;

/*
* 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
  你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
    给定 nums = [2, 7, 11, 15], target = 9
    因为 nums[0] + nums[1] = 2 + 7 = 9
    所以返回 [0, 1]
* */

public class TwoSum_1 {

    public int[] twoSum(int[] nums, int target){
        int num[] = new int[2];
        int i,j;
        for(i =0;i < nums.length;i++){
            for(j=i+1;j< nums.length;j++){
                if((nums[i] + nums[j]) == target) {
                    num[0] = i;
                    num[1] = j;
                }
            }
        }
        return num;
    }
    public static void main(String args[]){
        int [] num = new int[]{3,5,6,1};
        int target = 6;
        TwoSum_1 TwoSum = new TwoSum_1();
        int [] num1 = TwoSum.twoSum(num,target);
        for(int i:num1){
            System.out.println(i);
        }
    }
}

