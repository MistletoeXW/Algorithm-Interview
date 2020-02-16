package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T39FindHalfNum
 * @Description: 找出数组中出现次数超过一半的数字
 *         解法一: 一个超过数组一半的数字,换句话说,数组的中位数一定是该数字,所以此题可以转化为求中位数
 *                求中位数可以使用快排中分治的思想,
 *                首先在数组中选取一个元素,进行一趟快排,找到该数的位置,如果位置刚好是n/2的位置,则为中位数
 *                如果该位置大于n/2,则寻找范围缩小为左半部分, 如果小于n/2,则范围缩短到右部分,直到找到n/2的位置
 *                这种方法会修改数组中的值,时间复杂度为O(N)
 *        解法二:  数组中有一个数字出现次数超过数组长度的一半,说明它出现的次数比其他所有数字出现的次数的和还要多
 *              所以我们只需要一次遍历,在遍历过程中,定义两个变量,一个变量记录当前数字,一个变量记录次数
 *              初始从第一个数字开始,次数值设为1; 如果下一个数字等于当前值,则次数+1,否则就-1;
 *              如果次数值减到0,则记录值就变成下一个数字, 遍历到最后,记录的值的次数大于1则一定是出现超过一半的值
 * @Author:xuwen
 * @Date: 2020/2/16 下午2:06
 **/
public class T39FindHalfNum {
    //方法一: 快排中分治的思想,找到中位数
    public static int patition(int[] arr,int low,int high){

        if(arr == null || low > high)
            return -1;
        int pov = arr[low];
        while(low < high){

            while(low<high && arr[high] >= pov)
                high--;
            arr[low] = arr[high];
            while(low<high && arr[low] <= pov)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pov;
        return low;
    }

    public static int findHalfNum(int[] arr,int low,int high){

        if(arr==null)
            return -1;
        int midlen = (high+low)/2;
        int pos = patition(arr,low,high);
        while(pos != midlen){
            if(pos > midlen){
                pos = patition(arr,low,pos-1);
            }
            if(pos < midlen){
                pos = patition(arr,pos+1,high);
            }
        }
        return arr[pos];
    }

    //方法二:根据数字的特点找出值
    public static int findHalfNum_2(int[] arr){
        if(arr == null)
            return -1;
        int curNum = arr[0]; //记录当前值
        int count = 0; //记录次数值
        for(int i=1;i<arr.length;i++){
            if(count == 0){
                curNum = arr[i];
                count++;
            }else if(arr[i] == curNum){
                count++;
            }else {
                count--;
            }
        }
        //这里要加上对遍历后得到的结果判断是否出现次数大于一半的情况,因为我们不能确保
        //输入的数组中有出现次数大于一半的数字
        int times =0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == curNum)
                times++;
        }
        if(times*2 <= arr.length)
            return -1;

        return curNum;

    }



    public static void main(String[] args){

        System.out.print("请输入数组: ");
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int[] arr = new int[str.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        int num = findHalfNum_2(arr);
        System.out.print("出现次数超过一半的数字为: "+ num);

    }





}
