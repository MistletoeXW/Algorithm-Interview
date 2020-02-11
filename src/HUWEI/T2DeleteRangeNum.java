package HUWEI;

import java.util.TreeSet;

/**
 * @ClassName: T2DeleteRangeNum
 * @Description: 数字去重排序
 *          题目描述: 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，
         *          他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，
         *          把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，
         *          按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
 *
 *          方案一: 1. 排序: 使用快排 时间复杂度O(nlogn)
 *                 2. 去重复: 双指针遍历,时间复杂度O(n)
 *          方法二: 空间换时间: 将数据存入TreeSet
 * @Author:xuwen
 * @Date: 2020/2/11 下午3:12
 **/
public class T2DeleteRangeNum {

    //====================方法一==========================
    //快排
    public int position(int[] arr,int low,int high){

        int povit = arr[low];
        while(low < high){

            while (low<high && arr[high] >= povit)
                high--;
            arr[low] = arr[high];
            while(low<high && arr[low] <= povit)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = povit;
        return low;
    }

    public void QuickSort(int[] arr,int low,int high){

        int pos = position(arr,low,high);

        if(low<high){
            QuickSort(arr,low,pos-1);
            QuickSort(arr,pos+1,high);
        }

    }

    //去重复
    public int[] DeleteRange_1(int[] arr){
        //定义快慢两个指针
        int low = 0;
        int high = 1;
        while (high<arr.length){
            //当high指针找到不与low指针相等的值时,令low+1处的值等于high的值
            if(arr[low] != arr[high])
                arr[++low] = arr[high];
            //快指针进行遍历
            high++;
        }
        int[] result = new int[low+1];
        for(int i=0;i<=low;i++){
            result[i] = arr[i];
        }
        return result;
    }

    //==============================方法二: hashset的方法===================
    //将数组的值放入到TreeSet中,自动去重排序
    public void DeleteRange_2(int[] arr){

        TreeSet<Integer> set = new TreeSet<>();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        for(Integer num: set){
            System.out.print(num+" ");

        }


    }



    public static void main(String[] args){

        System.out.println("数组中的值为: ");
        int[] arr = {23,13,54,14,18,13,4,1,2,3,4,2,1,3,5,7,5,4,9,1,2,4,5,32,12,43,20,12,15,20,10,5,9,23,13,12,11};
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        T2DeleteRangeNum object = new T2DeleteRangeNum();
        System.out.println("\n方法二: 排序去重后的数组为: ");
        object.DeleteRange_2(arr);
        System.out.println("\n方法一: 排序去重后的数组为: ");
        object.QuickSort(arr,0,arr.length-1);
        arr = object.DeleteRange_1(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }

}
