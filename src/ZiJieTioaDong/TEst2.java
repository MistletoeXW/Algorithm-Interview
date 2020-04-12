package ZiJieTioaDong;

import sun.security.krb5.SCDynamicStoreConfig;

import java.util.Scanner;

/**
 * @ClassName:TEst2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/12 下午4:10
 **/
public class TEst2 {

    public static int findMinGap(int[] arr1,int num){
        int min =1000000;
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] <= num){
                int gap = num-arr1[i];
                if(gap < min){
                    min = gap;
                }
            }
        }
        return min;
    }

    public static int money(int[] arr1,int[] arr2){
        int count =0;

        for(int i=0;i<arr2.length;i++){
            int gap = findMinGap(arr1,arr2[i]);
            if(gap < 1000000)
                count += gap;
            else
                count += arr2[i];
        }
        return count;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[] arr1 = new int[n];
        String[] str1 = sc.nextLine().trim().split(" ");
        for(int i=0;i<n;i++){
            arr1[i] = Integer.parseInt(str1[i]);
        }

        int[] arr2 = new int[m];
        String[] str2 = sc.nextLine().trim().split(" ");
        for(int i=0;i<m;i++){
            arr2[i] = Integer.parseInt(str2[i]);
        }

        int result = money(arr1,arr2);

        System.out.print(result);


    }

}
