package JavaAlgorithmInterview.ArrayList;

import java.util.Scanner;

/**
 * @ClassName: P156
 * @Description: 对数组进行循环移位: 把一个含有n个元素的数组循环右移K位,
 *                                要求时间复杂度为O(N),并且只允许使用两个附加的变量
 *           方法:翻转法
 *                  将数组分为两部分,首先将两个部分分别翻转,再将整个数组一起翻转,翻转的操作理解为转置的操作
 *               例: 将123456向右移两位
 *               1.首先将数组分为两部分: 1234 和 56
 *               2.翻转1234(转置): 1234--->4321
 *               3.翻转56(转置): 56--->65
 *               4.翻转432165: 432165--->561234
 *
 * @Author:xuwen
 * @Date: 2020/1/30 上午10:29
 **/
public class P156RightShiftList {

    /*
     * @Author: xw
     * @Description: 翻转的操作//TODO
     * @Date: 下午12:16 2020/1/30
     * @Param: [arr, start, end]
     * @Return: void
     **/
    public static void reverse(int[] arr,int start,int end){

        while(start<end){
            //首尾指针将首尾元素进行交换
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    /*
     * @Author: xw
     * @Description: 对数组进行循环右移k个位置//TODO
     * @Date: 下午12:19 2020/1/30
     * @Param: [arr, k]
     * @Return: void
     **/
    public static void rightShift(int[] arr,int k){

        int len = arr.length;
        k %= len; //将数组分为两部分
        reverse(arr,0,len-1-k);
        reverse(arr,len-k,len-1);
        reverse(arr,0,len-1);
    }


    public static void main(String[] args){

        System.out.print("请输入数组:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] arr = new int[a.length];
        for(int i=0;i<a.length;i++){
            arr[i] = Integer.parseInt(a[i]);
        }
        System.out.print("请输入向右移动的位数:");
        int k = sc.nextInt();
        sc.close();
        rightShift(arr,k);
        System.out.print("向右移动"+ k + "位后的数组为:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
    }

}
