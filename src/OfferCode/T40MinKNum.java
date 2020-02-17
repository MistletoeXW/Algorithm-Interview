package OfferCode;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @ClassName: T40MinKNum
 * @Description: 在数组中找到最小的k个数
 *         思路一: 最直观的思路,先排序,时间复杂度最好为O(nlogn)
 *         思路二: 联想到快排中分治的思想,如果找到第k大的数,则其前面的数字就是最小的前k个数
 *                时间复杂度: O(N)
 *                这种方法的缺点很明显,会改变数组,而且不适合于海量数据,因为一次性要将海量数据装入内存,性能肯定受损
 *         思路三: 维护一个大小为K的最大堆,每次只需要读入一个数据,跟根节点进行比较,如果小于根节点则将根节点替换
 *                时间复杂度O(N*logK)
 *                这种方法不会改变原来的数组,而且适合与海量数据,不需要将海量数据一次性装入内存,每次只需要读入一个元素就行
 * @Author:xuwen
 * @Date: 2020/2/16 下午3:26
 **/
public class T40MinKNum {

    //思路三: 维护一个大小为K的大根堆
    //大根堆的向下调整
    public static void adjustDown(int[] arr,int k,int len){

        arr[0] = arr[k]; //arr[0]暂存k位置的值(对于数组中0位置要空出来)
        for(int i=2*k;i<=len;i*=2){

            if(i<len && arr[i]<arr[i+1]) //判断左孩子结点和右孩子结点的大小,取较大子结点的位置
                i++;
            if(arr[0] >= arr[i]) break; //如果根节点值比左右孩子中最大的值还要大则退出,不需要调整
            else {
                arr[k] = arr[i];
                k=i;
            }
        }
        arr[k] = arr[0];
    }

    //建立一个大根堆,这里数组中0位置处不使用
    public static void BuildMaxHeap(int[] arr){
        int len = arr.length-1;
        for(int i=len/2;i>0;i--)
            adjustDown(arr,i,len);
    }

    //这里开始遍历数组,找出前k小的数
    public static int[] findKNum(int[] arr,int k){

        if(k > arr.length)
            return arr;

        int[] maxHeap = new int[k+1];
        for(int i=0;i<k;i++){
            maxHeap[i+1] = arr[i];
        }
        //构建大根堆
        BuildMaxHeap(maxHeap);
        for(int i=k;i<arr.length;i++){
            if(arr[i] < maxHeap[1]){
                maxHeap[1] = arr[i];
                adjustDown(maxHeap,1, k);//向下调整

            }
        }
        return maxHeap;

    }

    //当然在面试过程中如果没有时间实现堆的结构,则可以考虑用java中的容器类
    //java中PriorityQueue通过二叉小顶堆实现，可以用一棵完全二叉树表示,我们需要将其变成大根堆
    public ArrayList<Integer> findKNum_2(int[] arr,int k){

        if(k>arr.length || k<=0){
            return new ArrayList<>();
        }
        //将小根堆变成大根堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(((o1, o2) -> o2-o1));
        for(int num: arr){
            maxHeap.add(num);
            //如果加入到堆中的值大于k就将堆顶出堆
            if(maxHeap.size() > k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);

    }


    public static void main(String[] args){

        System.out.print("请输入数组: ");
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int[] arr = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.print("请输入K值: ");
        int k = sc.nextInt();
        sc.close();
        System.out.print("前k小的数为: ");
        int[] num = findKNum(arr,k);
        for(int i=1;i < num.length;i++){
            System.out.print(num[i] + " ");
        }

    }




}
