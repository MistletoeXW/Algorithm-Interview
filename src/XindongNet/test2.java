package XindongNet;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: test2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/2/28 下午6:55
 **/
public class test2 {

    public static boolean numInList(int[] arr,int num){

        if(arr == null)
            return false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == num)
                return true;
        }
        return false;
    }

    public static boolean judgeSum(int[] arr1,int[] arr2){

        if(arr1 == null || arr2 == null)
            return false;
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0;i<arr1.length;i++){
            sum1 += arr1[i];
        }
        for(int i=0;i<arr2.length;i++) {
            sum2 += arr2[i];
        }
        if(sum1 == sum2){
            return true;
        }

        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr2.length;j++){
                if(sum1-arr1[i]==sum2 || sum2-arr2[j]==sum1 || sum1-arr1[i]==sum2-arr2[j])
                    return true;
            }
        }
        return false;

    }

    public static void main(String[] args){
        ArrayList<int[]> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n==0){
            return;
        }
        for(int i = 0; i < n; i++){
            int len = sc.nextInt();
            int[] arr = new int[len];
            for(int j = 0; j < len; j++){
                arr[j] = sc.nextInt();
            }
            list.add(arr);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0;i<list.size();i++){
            int count =0;
            for(int j=0;j < list.size();j++){
                if(judgeSum(list.get(i),list.get(j))){
                    count++;
                }
            }
            if(count > max){
                max = count;
            }
        }
        System.out.print(max);


    }


}
