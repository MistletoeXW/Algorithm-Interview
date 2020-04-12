package ZiJieTioaDong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName:Test1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/12 下午4:10
 **/
public class Test1 {

    public static int[] findHighNum(int[] arr){
        int[] result = new int[arr.length];
        for(int i=0;i<arr.length;i++){

            int count =0;
            int low = i-1;
            int high = i+1;
            while(low >=0){
                if(arr[low] <= arr[i]){
                    count ++;
                    low--;
                }
                else
                    break;

            }
            while(high < arr.length){
                if(arr[high] <= arr[i]){
                    count ++;
                    high++;
                }
                else
                    break;
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> arrList = new ArrayList<>();
        int n = sc.nextInt();
        if(n<1 || n>10)
            return;
        for(int i=0;i<n;i++){
            int size = sc.nextInt();
            int[] arr = new int[size];
            for(int j=0;j<size;j++){
                arr[j] = sc.nextInt();
            }
            arrList.add(arr);
        }
        for(int j=0;j<arrList.size()-1;j++){
            int [] arr = arrList.get(j);
            int [] result = findHighNum(arr);
            for(int i=0;i<arr.length;i++){
                System.out.print(result[i] + " ");
            }
            System.out.println();
        }
        int[] last =arrList.get(arrList.size()-1);
        int [] resultlast = findHighNum(last);
        for(int i=0;i<resultlast.length;i++){
            System.out.print(resultlast[i] + " ");
        }

    }


}
