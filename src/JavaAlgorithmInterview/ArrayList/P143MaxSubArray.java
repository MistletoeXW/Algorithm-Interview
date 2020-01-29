package JavaAlgorithmInterview.ArrayList;

import java.util.Scanner;

/**
 * @ClassName:P143MaxSubArray
 * @Description: 求数组中连续最大和,有一个元素值可以是正数也可以是负数的数组,数组中连续的一个或者多个元素可以组成一个连续的子数组,
 *               求子数组中元素和的最大值
 *           例如: 对于数组{1 -2 4 8 -4 7 -1 -5}而言,奇最大和的子数组为{4,8,-4,7},最大值为15
 *           方法一: 蛮力法
 *                  找出所有的子数组,然后求出子数组的和,在所有子数组和中取最大值
 *           方法二: 动态规划法
 *           可以采用动态规划的方法来降低算法的时间复杂度,思路如下:
 *           首先可以根据数组的最后一个元素arr[n-1]与最大子数组的关系分为以下三种情况讨论
 *                  1. 最大子数组包含arr[n-1],即最大子数组以arr[n-1]结尾
 *                  2. arr[n-1]单独构成最大子数组
 *                  3. 最大子数组不包含arr[n-1],那么求arr[1...n-1]的最大子数组可以转换为求arr[1...n-2]的最大子数组
 *           通过上述分析可以得出结论: 假设已经计算出arr[1...i-2]的最大子数组和All[i-2],
 *           同时也计算出arr[0...i-1]中包含arr[0...i-1]中包含arr[i-1]的最大的子数组和为End[i-1]
 *           则可以得出如下关系: All[i-1] = max{End[i-1,arr[i-1],All[i-2}
 *
 *
 * @Author:xuwen
 * @Date: 2020/1/28 下午2:50
 **/
public class P143MaxSubArray {

    //=========================方法一:蛮干法=======================

    /*
     * @Author: xw
     * @Description: 蛮干法,找出数组所有的子数组,在所有的子数组和中找出最大值//TODO
     * @Date: 下午2:55 2020/1/28
     * @Param: [arr]
     * @Return: int
     **/
    public static int findMaxSubArray_1(int[] arr){

        int ThisSum;
        int MaxSum =0;
        //外层循序点定义第一个边界i
        for(int i=0;i<arr.length;i++){
            //内层循环定义第二个边界j
            for(int j=i;j<arr.length;j++) {

                ThisSum = 0;
                //定义k从边界i遍历到边界j,计算两边界之间的值的和,并与最大和的值进行比较
                for (int k = i; k < j; k++)
                    ThisSum += arr[k];
                if (ThisSum > MaxSum){
                    MaxSum = ThisSum;
                }
            }

        }
        return MaxSum;
    }

    //=========================方法二:动态规划法=======================

    /*
     * @Author: xw
     * @Description: 动态规划方法求解//TODO
     * @Date: 下午3:29 2020/1/28
     * @Param: [arr]
     * @Return: int
     **/
    public static int findMaxSubArray_2(int[] arr){

        int n = arr.length;
        int nAll = arr[0]; //最大子数组和
        int nEnd = arr[0];//包含最后一个元素的最大子数组和
        for(int i=1;i<n;i++){
            nEnd = Integer.max(nEnd+arr[i],arr[i]);
            nAll = Integer.max(nEnd,nAll);
        }
        return nAll;

    }



    public static void main(String[] args){

        System.out.print("请输入数组:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");

        int[] arr = new int[a.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(a[i]);
        }

        //=========================方法一:蛮干法=======================
        int maxSum = findMaxSubArray_2(arr);

        System.out.print("数组中最大子数组的最大和值为:"+maxSum);



    }







}
