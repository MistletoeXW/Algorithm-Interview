package OfferCode;

import java.awt.geom.QuadCurve2D;
import java.sql.BatchUpdateException;
import java.util.Queue;

/**
 * @ClassName: T15SortAndSearch
 * @Description: 本题中要求写出重要的查询和排序程序: 二分查找,快排,归并排序,堆排序
 *
 * @Author:xuwen
 * @Date: 2020/2/5 下午2:48
 **/
public class T15SortAndSearch {

    //========================二分查找算法===============
    //在数组中运用二分查找的方法找出数在数组中的位置
    public int searchNumInList(int[] arr,int data){
        int low = 0;
        int high = arr.length-1;
        while(low<high){

            int mid = (low+high)/2;
            if(arr[mid] > data)
                high = mid-1;
            else if(arr[mid] < data)
                low = mid+1;
            else
                return arr[mid];

        }
        return -1;
    }

    //=========================快速排序=======================
    public int patition(int[] arr,int low,int high){

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

    public void QuickSort(int[] arr,int low,int high){

        int pos = patition(arr,low,high);
        if(low<high){
            QuickSort(arr,low,pos-1);
            QuickSort(arr,pos+1,high);
        }
    }

    //===========================归并排序==========================
    //数组arr的两段arr[low..mid] 和 arr[mid+1...high]各自有序,将他们合并为一个有序的数组
    public void Merge(int[] arr,int low,int high){
        int[] b = new int[arr.length];//归并需要另外开辟一个数组空间,将数组的值放入其中进行归并
        int mid = (low+high) / 2;
        //将数组元素放入到辅助的数组空间
        for(int i=low;i<=high;i++)
            b[i] = arr[i];
        //在数组b中进行归并,找出较小的值放入到arr中
        int i,j,k;
        for(i=low,j=mid+1,k=i;i<=mid&&j<=high;k++){
            if(b[i] <= b[j])
                arr[k] = b[i++];
            else
                arr[k] = b[j++];
        }
        while(i<=mid) arr[k++] = b[i++];//若第一个表未检测完,则将剩下的元素遍历放入arr数组中
        while(j<=mid) arr[k++] = b[j++];//若第二个表未检测完,则将剩下的元素遍历放入arr数组中
    }

    public void MergeSort(int[] arr,int low,int high){

        if(low<high){
            int mid=(low+high) / 2;
            MergeSort(arr,low,mid);
            MergeSort(arr,mid+1,high);
            Merge(arr,low,high);
        }
    }

    //===========================大根堆排序=======================
    //向下调整函数
    public void AdjustDown(int[] arr,int k,int len){
        arr[0] = arr[k];
        for(int i=2*k;i<=len;i*=2){
            //比较左右子结点的值,找出较大的结点
            if(i<len && arr[i]<arr[i+1])
                i++;
            if(arr[0]>arr[i]) break; //如果双亲大于孩子中的最大值,则退出
            else {
                arr[k] = arr[i]; //将arr[i]调整到双亲结点上
                k=i;
            }
        }
        arr[k] = arr[0];
    }

    //建立大根堆
    void BuildMaxHeap(int[] arr,int len){
        for(int i=len/2;i>0;i--)
            AdjustDown(arr,i,len);
    }

    public void HeapSort(int[] arr,int len){
        BuildMaxHeap(arr,len);//建立初始堆
        for(int i=len;i>1;i--){
            int temp = arr[1];
            arr[1] = arr[i];
            arr[i] = temp;
            AdjustDown(arr,1,i-1);
        }
    }


}
