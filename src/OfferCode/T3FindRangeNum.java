package OfferCode;

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: T3FindRangeNum
 * @Description: 题目三: 在长度为n的数组中的所有数字都在0~(n-1)的范围内.数组中有唯一的数字是重复的
 *                      请找到数组中重复的数字
     *               方法一: Hash法,时间复杂度为O(n),空间复杂度为O(n)
     *               方法二: 排序法,先进行排序,再进行遍历, 使用快排或者归并或者堆排序时间复杂度为O(nlogn),空间复杂度看情况
     *               方法三: 数据映射法, 将数组中的值作为数组下标进行遍历,同时将对应下标的值改为相反数,
     *                      如果遍历到相应位置的值为负数,则表示此数字重复
 * @Author:xuwen
 * @Date: 2020/2/1 下午2:40
 **/
public class T3FindRangeNum {

    //======================方案一:Hash法===========================

    /*
     * @Author: xw
     * @Description: 方法一:Hash法找到重复的数字//TODO
     * @Date: 下午2:54 2020/2/1
     * @Param: [arr]
     * @Return: int
     **/
    public static int findRangeNum_1(int[] arr){
        //开辟一个Hash表
        HashSet<Integer> hashSet = new HashSet<Integer>();
        for(int i=0;i<arr.length;i++){

            if(hashSet.contains(arr[i])){
                return arr[i];
            }else {
                hashSet.add(arr[i]);
            }

        }
        return -1;
    }

    //======================方案二:排序法===========================

    //快排
    public static int patition(int[] arr,int low,int high){

        int piovt = arr[low];

        while(low < high){

            while((low < high) && (arr[high] >= piovt))
                high--;
            arr[low] = arr[high];
            while((low < high) && (arr[low] <= piovt))
                low++;
            arr[high] = arr[low];
        }

        arr[low] = piovt;
        return low;

    }

    public static void QuickSort(int[] arr, int start,int end){

        if(start<end){
            int pos = patition(arr,start,end);
            QuickSort(arr,start,pos-1);
            QuickSort(arr,pos+1,end);
        }

    }


    /*
     * @Author: xw
     * @Description: 首先经过快排,再遍历循环找出重复数字//TODO
     * @Date: 下午3:13 2020/2/1
     * @Param: [arr]
     * @Return: int
     **/
    public static int findRangeNum_2(int[] arr){

        //首先对数组进行快排
        QuickSort(arr,0,(arr.length-1));
        //将数组进行排序后,对数组进行遍历
        for(int i=0;i < arr.length-1; i++){

            if(arr[i] == arr[i+1]){
                return arr[i];
            }

        }
        return -1;

    }

    //======================方案三:数据映射法===========================




    //==============================主函数===============================
    public static void main(String[] args){

        System.out.print("请输入只含唯一重复元素的数组: ");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        sc.close();
        int[] arr = new int[a.length];
        for(int i=0;i<a.length;i++){
            arr[i] = Integer.parseInt(a[i]);
        }

        int num = findRangeNum_2(arr);
        if (num != -1) {
            System.out.print("重复的数字为: " + num+"\n");
        }else
            System.out.print("数组中没有重复的数字\n");



    }




}
