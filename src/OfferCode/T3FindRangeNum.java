package OfferCode;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @ClassName: T3FindRangeNum
 * @Description: 题目三: 在长度为n的数组中的所有数字都在0~(n-1)的范围内.数组中有唯一的数字是重复的
 *                      请找到数组中重复的数字
     *               方法一: Hash法,时间复杂度为O(n),空间复杂度为O(n)
     *               方法二: 排序法,先进行排序,再进行遍历, 使用快排或者归并或者堆排序时间复杂度为O(nlogn),空间复杂度看情况
     *               方法三: 数据映射法 时间复杂度为O(n) 空间复杂度为O(1)
 *                          将数组中的值作为数组下标进行遍历,同时将对应下标的值改为相反数,
     *                      如果遍历到相应位置的值为负数,则表示此数字重复
 *               上述方法中,都需要改变数组, 如果不想改变数组值也只能另外开辟一个数组空间
 *
 *               以下给出不改变数组的方法: 二分查找法
 *                          以长度为8的数组{2,3,5,4,3,2,6,7}为例分析查找过程
 *                          1. 首先根据题目要求,这长度为8的数组要求里面的元素都在1~7范围内
 *                          2. 求出中间数字4, 把1~7分为分为两段,一段是1~4,另一段是5~7
 *                          3. 接下来统计1~4这4个数字在数组中出现的次数,它们共出现了5次,因此1~4必有重复
 *                          4. 接下来再把1~4一分为二,一段是1~2,一段是3~4
 *                          5. 接下来统计两者,发现3和4总共出现了3次,所以重复法数字肯定在3和4中,我们再统计3和4的出现的次数
 *                             可以得出重复的数字
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
    /*
     * @Author: xw
     * @Description: 在遍历的过程中,将数组中的值作为数组下标进行遍历,同时将对应下标的值改为相反数,
     *               如果遍历到的位置为负数,则说明此数重复,如果不为负数则将此位置的数变为负数//TODO
     * @Date: 下午4:06 2020/2/1
     * @Param: [arr]
     * @Return: int
     **/
    public static int findRangeNum_3(int[] arr){

        int len = arr.length;
        int i=0;
        while(i<len){
            if(arr[i] < 0)
                break;
            arr[i] *= -1;
            //下一个遍历的位置为数组中的值为下标的位置
            i = -1*arr[i];
        }
        return i;
    }

    //======================方案四:二分查找法===========================
    /*
     * @Author: xw
     * @Description: 统计范围中的元素出现的次数//TODO
     * @Date: 下午5:33 2020/2/1
     * @Param: [arr, start, end]
     * @Return: int
     **/
    public static int countRange(int[] arr,int start,int end){
        int count = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] >= start && arr[i] <= end)
                count++;

        }
        return count;
    }
    /*
     * @Author: xw
     * @Description: 二分查找法进行判断找出重复元素//TODO
     * @Date: 下午5:39 2020/2/1
     * @Param: [arr]
     * @Return: int
     **/
    public static int findRangeNum_4(int[] arr){

        int start =1;
        int end = arr.length-1;
        while (start <= end){

            int middle = (start+end) / 2;
            int count = countRange(arr,start,middle);
            if(start == end){
                if(count > 1)
                    return start;
                else
                    break;
            }

            if(count > (middle-start+1))
                end = middle;
            else
                start = middle+1;

        }
        return -1;

    }


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

        int num = findRangeNum_4(arr);
        if (num != -1) {
            System.out.print("重复的数字为: " + num+"\n");
        }else
            System.out.print("数组中没有重复的数字\n");

    }

}
