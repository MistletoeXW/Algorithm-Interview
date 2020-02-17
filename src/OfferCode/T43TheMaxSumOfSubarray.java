package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T43TheMaxSumOfSubarray
 * @Description: 寻找数组的最大子数组的和,并输出子数组的起始位置
 *          思路: 对数组进行一次遍历,当计算sum的值小于0,说明子数组的头部就要重新开始
 * @Author:xuwen
 * @Date: 2020/2/17 下午3:48
 **/
public class T43TheMaxSumOfSubarray {

    private static int maxSum =Integer.MIN_VALUE;
    private static int start =0;
    private static int end = 0;

    public static void findMaxSum(int[] arr){

        if(arr == null)
            return;
        int sum=0;
        int nstart=0;
        for(int i=0;i<arr.length;i++){

            if(sum >= 0){
                sum = sum + arr[i];
            }else {
                sum = arr[i];
                nstart = i;
            }

            if(sum > maxSum){
                maxSum = sum;
                start = nstart;
                end = i;
            }
        }
    }

    public static void main(String[] args){

        System.out.print("请输入数组: ");
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        sc.close();
        int[] arr = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        findMaxSum(arr);
        System.out.print("数组的连续子数组的最大和为: "+maxSum);
        System.out.print("\n子数组的起始位置为: "+start+","+end);

    }


}
