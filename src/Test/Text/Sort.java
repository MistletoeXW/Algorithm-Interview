package Test.Text;

import java.util.ArrayList;
import java.util.List;


/**
 * @ClassName: Sort
 * @Description: 快排. 堆的实现 . 归并排序
 * @Author:xuwen
 * @Date: 2020/2/19 下午3:27
 **/
public class Sort {

    //===================快排=================
    public static int partition(int[] arr,int low,int high){

        if(arr == null)
            return -1;
        if(low < high){

            int pov = arr[low];
            while(low < high){
                while (low<high && arr[high]>=pov)
                    high--;
                arr[low] = arr[high];
                while (low<high && arr[low]<=pov)
                    low++;
                arr[high] = arr[low];
            }
            arr[low] = pov;
        }
        return low;

    }

    public static void QuickSort(int[] arr,int low,int high){
        if(arr == null || low > high)
            return;
        int pos = partition(arr,low,high);
        if(low<high){
            QuickSort(arr,low,pos-1);
            QuickSort(arr,pos+1,high);
        }

    }

    //=============字典序比较==========
    //单词比较,这里不考虑单词大小写
    public static int compare(String str1,String str2){
        int length1 = str1.length();
        int length2 = str2.length();

        int limit = Math.min(length1, length2);

        char a[] = str1.toCharArray();
        char b[] = str2.toCharArray();

        for(int i = 0;i<limit;i++){
            char c1 = (char) (a[i]>='a'?a[i]:(a[i]+32));
            char c2 = (char) (b[i]>='a'?b[i]:(b[i]+32));
            if(c1 != c2){
                return c1-c2;
            }
        }

        return length1-length2;

    }

    //字典排序，采用插入排序的方法
    public static List<String> sortword(String string){
        int length = string.length();
        int k =0;
        List<String> sortedList = new ArrayList<>();

        for(int i = 0;i<length;i++){
            if(string.charAt(i)==' '){
                String word = string.substring(k, i);
                addAword(sortedList,word);
                k=i+1;
            }
        }
        String word = string.substring(k);
        addAword(sortedList,word);

        return sortedList;

    }

    //插入排序实现
    public static void addAword(List<String> sortedList,String string){

        if(string == null || string.length()==0){
            return;
        }
        String temp = string;
        boolean bigger = false;
        for(int i=0;i<sortedList.size();i++){
            String s = sortedList.get(i);
            if(bigger || compare(string,s)<0){
                sortedList.set(i, temp);
                temp = s;
                bigger = true;
            }else if(!bigger && compare(string,s) == 0){
                return;
            }
        }
        sortedList.add(temp);

    }


}
