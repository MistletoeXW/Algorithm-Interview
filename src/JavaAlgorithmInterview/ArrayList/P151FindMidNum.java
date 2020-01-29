package JavaAlgorithmInterview.ArrayList;

import java.util.Scanner;

/**
 * @ClassName:P151FindMidNum
 * @Description: 在不排序的情况下求数组的中位数
 *           方法: 使用类快速排序算法,分割元素的下标为pos
 *              1. 当pos > length/2时,说明中位数在数组左半部分,那么继续在左半部分查找
 *              2. 当pos = length/2时,说明找到该中位数,返回A[pos]即可
 *              3. 当pos < length/2时,说明中位数在数组的右半部分,那么继续在数组右半部分查找
 *           以上此数组长度默认为奇数,如果为偶数,则调用上诉方法两次,找到中间的两个数求平均;
 *           这种方法时间复杂度为O(n),如果采用先排序再找中位数,时间复杂度最低为O(n*log n)
 * @Author:xuwen
 * @Date: 2020/1/29 下午12:08
 **/
public class P151FindMidNum {

    private static int pos=0;

    //类似快排的分治思想
    private static void partition(int arr[],int low,int high){

        int key = arr[low]; //以最低位为分段点
        while(low < high){

            while(low<high && arr[high]>key){
                high--;
            }
            arr[low] = arr[high];
            while(low<high && arr[low]<key){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = key;
        pos = low;
    }

    public static int getMid(int[] arr){

        int low = 0;
        int n = arr.length;
        int high = n-1;
        int mid = (low+high) / 2;
        while (true){
            //以arr[low]为基准把数组分为两部分
            partition(arr,low,high);
            if(pos == mid)  //如果找到中位数则退出
                break;
            else if(pos >mid)  //如果位置大于中间位置,则继续在右半部分寻找
                high = pos -1;
            else              //如果位置小于中间位置,则继续在左半部分寻找
                low = pos + 1;
        }
        //如果数组长度是奇数,中位数为中间的元素,否则就是中间两个数的平均值
        if(n%2 !=0 )
            return arr[mid];
        else
            return (arr[mid]+arr[mid+1]) / 2;
    }

    public static void main(String[] args){

        System.out.print("输入数组值:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] arr = new int[a.length];
        for(int i=0;i<a.length;i++){
            arr[i] = Integer.parseInt(a[i]);
        }

        int midNum = getMid(arr);

        System.out.print("中位数为:"+midNum);


    }


}
