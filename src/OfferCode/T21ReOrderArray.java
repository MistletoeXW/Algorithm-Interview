package OfferCode;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName: T21ReOrderArray
 * @Description: 调整数组的顺序使奇数位于偶数前面
 *          思路: 类似于一轮快排的思想,采用两个指针,
 *               low指针从数组头开始,往后遍历找偶数; high指针从数组尾部开始,往前找奇数
 *               如果找到low的值为偶数,HIgh的值为奇数,就交换low与HIgh的值
 *               当遍历到high指针小于low说明遍历完毕
 *
 *          如果考虑空间换时间的思路: 时间复杂度为O(n),空间复杂度为O(n)
 *               采用一个辅助数组,先统计出奇数个数,两个指针,奇数一个指针,偶数一个指针,奇数指针从开头开始存放,偶数从统计的奇数数开始
 *               如果不考虑元素的顺序的化,也可以定义奇数从头开始,偶数从尾部开始存
 * @Author:xuwen
 * @Date: 2020/2/8 下午2:34
 **/
public class T21ReOrderArray {

    public void reOrderArray_1(int[] array){
        int low = 0;
        int high = array.length-1;
        while(low<high){
            //向后移动low直到找到偶数
            while(low<high && array[low]%2 !=0 )
                low++;
            //向前移动high直到找到奇数
            while (low<high && array[high]%2 == 0)
                high--;
            if(low < high){
                int tmp = array[low];
                array[low] = array[high];
                array[high] = tmp;
            }
        }
    }

    public void reOrderArray_2(int[] array){
        int low =0;
        int high = 0;
        for(int x:array){
            if(x%2 != 0)
                high++;
        }
        int[] copy = array.clone();
        int i=low,j=high;
        for(int num: copy){
            if(num%2 == 1)
                array[i++] = num;
            else
                array[j++] = num;
        }

    }

    //======================牛客网=======================

    //如果不要求排序后与之前原数组的顺序关系
    public void reOrderArray(int[] array){

        if(array.length == 0)
            return;
        int low = 0;
        int high = array.length-1;
        while (low < high){

            while ((low < high) && (array[high] %2 ==0)){
                high--;
            }
            while ((low<high) && (array[low] %2 !=0)){
                low++;
            }
            int tmp = array[low];
            array[low] = array[high];
            array[high] = tmp;
        }

    }

    //如果考虑先后顺序: 使用一个辅助的数组,首先统计出奇数个数,然后一个奇数指针和偶数指针分别进行存放
    //如果不考虑先后顺序,则可以将奇数指针定义从投开始存,定义偶数指针从尾部开始存
    public void reOrderArray3(int[] array){
        if(array.length == 0)
            return;
        int[] result = new int[array.length];
        int low = 0;
        int high = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]%2 != 0)
                high++;
            result[i] = array[i];
        }
        for(int i=0;i<result.length;i++){
            if(result[i] %2 != 0){
                array[low++] = result[i];
            }else {
                array[high++] = result[i];
            }
        }
    }



}
