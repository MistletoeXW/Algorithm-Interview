package JavaAlgorithmInterview.ArrayList;

import java.util.Scanner;

/**
 * @ClassName: P130FindSmallK
 * @Description: 找出数组中第K小的数,给定一个数组,要求快速的找出数组中第K小的数
 *          方法一: 排序法,使用快排对数组进行排序,然后再遍历,时间复杂度是O(nlogn)
 *          方法二: 部分排序法,可以对数组进行K趟选择排序或者堆排序,时间复杂度是O(n*k)
 *
 * @Author:xuwen
 * @Date: 2020/1/27 上午10:42
 **/
public class P130FindSmallK {

    //==========================快排算法=====================
    public static int paition(int[] arr,int low,int high){
        int povit = arr[low];
        while(low<high){

            while (low<high && arr[high] >= povit)
                high--;
            arr[low] = arr[high];
            while (low<high && arr[low] <= povit)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = povit;
        return low;
    }

    public static void QuickSort(int[] arr,int low,int high){

        int pos = paition(arr,low,high);

        if(low<high){
            QuickSort(arr,low,pos-1);
            QuickSort(arr,pos+1,high);
        }

    }


    //==========================方法一:排序法,使用快速排序=====================
    /*
     * @Author: xw
     * @Description: 方法一,对数组进行快排//TODO
     * @Date: 上午10:59 2020/1/27
     * @Param: [arr]
     * @Return: int
     **/
    public static int findSmallKNum(int[] arr,int k){
        //对数组进快排序
        QuickSort(arr,0,arr.length-1);
        int i=0;
        //对排序后的数组进行遍历
        while(i<k)
            i++;
        return arr[i];
    }

    //==========================方法二:部分排序法=====================




    public static void main(String[] args) {

        System.out.print("请输入数组的值:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] ary = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ary[i] = Integer.parseInt(a[i]);
        }
        System.out.print("请输入K值:");
        int k = sc.nextInt();
        sc.close();

        //=============测试快排算法=================
//        QuickSort(ary,0,ary.length-1);
//        System.out.print("快速排序的结果为:");
//        for(int i=0;i<ary.length;i++)
//            System.out.print(ary[i]+" ");

        //=============方法一=================
        int num = findSmallKNum(ary,k);
        System.out.print("数组中第k小的数为:" + num);
    }


}
