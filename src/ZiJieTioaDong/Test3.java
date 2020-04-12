package ZiJieTioaDong;

import javax.script.ScriptEngine;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Scanner;

/**
 * @ClassName:Test3
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/12 下午8:10
 **/
public class Test3 {

    public static boolean judge(int[] arr1,int[] arr2){

        if(arr1.length != arr2.length)
            return false;

        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i])
                return false;
        }
        return true;
    }

    public static boolean opt(int[] arr1,int[] arr2){
        int low =0;
        while(low < arr1.length){
            if(arr1[low] == arr2[low]){
                low++;
            }
            else
                break;
        }
        if(low > arr1.length-1)
            return true;
        int high = low+1;
        while(high < arr1.length){
            if(arr1[high] == arr2[high]){
                break;
            }
            else
                high++;
        }
        int num = arr1[low] - arr2[low];
        for(int i=low;i<high;i++){
            int gap = arr1[i] - arr2[i];
            if(gap != num)
                return false;
            arr1[i] = arr2[i];
        }

        if(! judge(arr1,arr2)){
            return false;
        }

        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<int[]>> arrayLists = new ArrayList<>();
        int n = sc.nextInt();
        if(n<1 || n>10)
            return;
        for(int i=0;i<n;i++){
            ArrayList<int[]> arrayList = new ArrayList<>();
            int size = sc.nextInt();
            for(int k=0;k<2;k++){
                int[] arr = new int[size];
                for(int j=0;j<size;j++){
                    arr[j] = sc.nextInt();
                }
                arrayList.add(arr);
            }
            arrayLists.add(arrayList);
        }
        for(ArrayList<int[]> arr1 : arrayLists){
            if(opt(arr1.get(0),arr1.get(1))){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
