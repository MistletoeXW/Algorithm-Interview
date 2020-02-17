package OfferCode;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName: T41_1GetMidNum
 * @Description: 得到数据流中的中位数
 *         思路:
 *         方法一: 对于没有排序的数组,可以运用改造后的Partition函数,运用快排分治思想,找到第k位置的值
 *                此方法时间复杂度为O(n),但是不适用于海量数据,所有数据必须一次性读入内存
 *         方法二: 可以维护一棵平衡二叉树,最终根节点的位置就是中位数,平衡二叉树插入的时间复杂度为O(logn),性能是最优的
 *                但是平衡二叉树在java中没有函数库实现,所以要实现一棵平衡二叉树相对困难
 *         方法三: 运用最大堆和最小堆, 将容器分割为左右两部分,左边维护最大堆,右边维护最小堆,两边都不需要排序,
 *                只需要得到左边的最大值和右边的最小值
 *                首先要保证数据平均分配到两个堆中,为实现平均分配,可以在数据总数为偶数时把新的数据插入最小堆,否则插入最大堆
 *                为实现左部分最大堆的值要小于右部分值,如果我们插入的新值要插入右部分但是比左部分的部分值要小怎么办?
 *                我们可以先插入到左部分,将堆中的最大值插入到右部分中
 *                同理插入到左部分时操作类似
 * @Author:xuwen
 * @Date: 2020/2/17 下午1:49
 **/
public class T41_1GetMidNum {

    //===========================方法一: 未排序的数组,使用类快排的操作=======================
    public static int partition(int[] arr,int low,int high){

        if(arr==null || low > high)
            return -1;
        int pov = arr[low];
        while(low < high){
            while(low<high && arr[high]>=pov)
                high--;
            arr[low] = arr[high];
            while(low<high && arr[low]<=pov)
                low++;
            arr[high] = arr[low];
        }
        arr[low] = pov;
        return low;
    }

    public static Double getMidNum_1(int[] arr,int low,int high){

        if(arr==null)
            return -1.0;
        int mid = (low+high) / 2;
        int pos = partition(arr,low,high);
        while(pos != mid){
            //当找到的位置大于中间位置,说明中位数在左部分
            if(pos > mid){
                pos = partition(arr,low,pos-1);
            }else{//当找到的位置小于于中间位置,说明中位数在右部分
                pos = partition(arr,pos+1,high);
            }
        }
        if(arr.length %2 != 0)
            return (double) arr[pos];
        else{
            int index = partition(arr,pos+1,high);
            while (index != (mid+1)){
                //当找到的位置大于中间位置,说明中位数在左部分
                if(index > mid+1){
                    index = partition(arr,pos+1,index-1);
                }else{//当找到的位置小于于中间位置,说明中位数在右部分
                    index = partition(arr,index+1,high);
                }
            }
            return (double)(arr[pos]+arr[index])/2;
        }

    }

    //==========================方法三:维护最大堆和最小堆========================
    //这里直接使用java库中的PriorityQueue优先队列来实现最大堆和最小堆

    //最大堆,存储左半部分元素
    private static PriorityQueue<Integer> left = new PriorityQueue<>(((o1, o2) -> o2-o1));
    //最小堆,存储右半部分元素
    private static PriorityQueue<Integer> rigth = new PriorityQueue<>();
    //当前数据流读入的元素个数
    private static int N =0;

    public static void Insert(Integer num){
        //要保证两个堆处于平衡状态
        if(N%2==0){

            //N为偶数的情况下插入到右半边
            //因为右半边元素都要大于左半边元素,但是新插入的元素不一定比左半边元素大
            //因此这时候需要先将元素插入到左半边,再把最大堆堆顶元素插入右半边
            left.add(num);
            rigth.add(left.poll());
        }
        else {
            rigth.add(num);
            left.add(rigth.poll());
        }
        N++;
    }

    public static double getMidNum_3(int[] arr){
        for(int i=0;i<arr.length;i++){
            Insert(arr[i]);
        }
        if(! left.isEmpty() && !rigth.isEmpty())
            if(N%2==0)
                return (left.peek()+rigth.peek()) / 2.0;
            else
                return (double) rigth.peek();
        else {
            return -1.0;
        }

    }


    public static void main(String[] args){

        System.out.print("请输入数组: ");
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        sc.close();
        int[] arr = new int[str.length];
        for (int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        //方法一
        double midNum_1 = getMidNum_1(arr,0,arr.length-1);
        System.out.print("方法一所的的中位数为: "+ midNum_1);

        //方法三
        double midNum_3 = getMidNum_3(arr);
        System.out.print("\n方法一所的的中位数为: "+ midNum_3);


    }



}
