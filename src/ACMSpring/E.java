package ACMSpring;

import java.util.Scanner;

/**
 * @ClassName:E
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/18 下午12:38
 **/
public class E {

    public static long findMaxSum(int[] arr){
        int low = 0;
        int high = arr.length-1;

        long sum = 0;
        int count =0;
        while(low <= high){
            if(arr[low] >= arr[high]){
                sum += arr[low];
                sum -= count;
                low ++;
                count++;
            }else {
                sum += arr[high];
                sum -= count;
                high--;
                count++;
            }
        }
        return sum;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 1){
            return;
        }
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(findMaxSum(arr));
    }

}
