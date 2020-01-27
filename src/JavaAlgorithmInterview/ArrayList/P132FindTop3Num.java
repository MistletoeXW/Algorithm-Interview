package JavaAlgorithmInterview.ArrayList;

import java.util.Scanner;
/**
 * @ClassName:P132FindTop3Num
 * @Description: 找出数组中的前3名大的值,要求时间复杂度为O(n)
 *           分析: 如果没有时间复杂度的限定,可以使用先快排再遍历的方法
 *           要求时间复杂度为O(n),具体算法思想为:
 *              首先初始化前三名: r1,r2,r3为最小整数,然后开始遍历数组
 *              1. 如果当前值tmp大于r1: r3=r2,r2=r1,r1=tmp
 *              2. 如果当前值tmp大于r2且不等于r1: r3=r2,r2=tmp
 *              3. 如果当前值tmp大于r3且不等于r2: r3=tmp
 * @Author:xuwen
 * @Date: 2020/1/27 上午11:46
 **/
public class P132FindTop3Num {

    /*
     * @Author: xw
     * @Description: 找出数组中前3名大的值,时间复杂度为O(n)//TODO
     * @Date: 上午11:55 2020/1/27
     * @Param: [arr]
     * @Return: void
     **/
    public static void findTop3Num(int[] arr){
        //初始化三个数,定义为最小值
        int r1,r2,r3;
        r1=r2=r3=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >r1){ //如果当前值大于r1: r3=r2,r2=r1,r1=tmp
                r3=r2;
                r2=r1;
                r1=arr[i];
            }else if(arr[i] > r2 && arr[i]!=r1){
                r3 = r2;
                r2 = arr[i];
            }else if(arr[i]>r3 && arr[i]!=r2){
                r3=arr[i];
            }
        }
        System.out.print("前3名分别为:"+r1+","+r2+","+r3);
    }

    public static void main(String[] args){

        System.out.print("请输入数组值: ");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] arr = new int[a.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(a[i]);
        }
        sc.close();

        findTop3Num(arr);

    }



}
