package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T11FindminNumInRotateArray
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾,我们称为数组的旋转
 *               输入一个非递减排序的数组的一个旋转,输出旋转数组的最小元素
 *         解题误区: 此问题最直观的解法就是遍历找出最小的元素,时间复杂度为O(n)
 *                  但是此方法没有;利用旋转数组的特点
 *         解题思路:
 *                  将旋转数组对半分可以得到一个包含最小元素的新旋转数组,以及一个非递减排序的数组.
 *                  新的旋转数组的数组元素是原数组的一半,从而将问题规模减少一半
 *                  这种折半性质的算法的时间复杂度为O(logn)
 *                  例如: 数组{3,4,5,1,2} 其中,最小值将数组分割为旋转数组{1,2}和递增数组{3,4,5}
 *                  此问题的关键在于确定对半分得到的两个数组哪一个是旋转数组,哪一个是递增数组
 *                  我们很容易知道非递减数组的第一个元素一定小于等于最后一个元素
 *             步骤: 通过修改二分查找算法进行求解
 *                  1. 当num[mid] <= num[high]時, 表示[mid,high]区间内的数组是非递减数组
 *                     [low,mid]区间内的数组是旋转数组,此时令high=mid
 *                  2. 否则[mid+1,high]区间内的数组是旋转数组,令low=mid+1
 *
 * @Author:xuwen
 * @Date: 2020/2/4 上午11:00
 **/
public class T11FindMinNumInRotateArray {

    public static int minNumInRotateArray(int[] nums){
        if(nums.length == 0)
            return 0;
        int low=0,high=nums.length-1;
        while(low < high){

            int mid = (low+high) / 2;
            if(nums[mid] <= nums[high])
                high = mid;
            else
                low = mid+1;
        }
        return nums[low];

    }

    public static void main(String[] args){

        System.out.print("请输入旋转数组: ");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] nums = new int[s.length];
        sc.close();
        for(int i=0;i<s.length;i++){
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.print("此数组中的最小值为: "+minNumInRotateArray(nums));


    }


}
