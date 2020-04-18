package ACMSpring;

import java.util.Scanner;

/**
 * @ClassName:T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/18 上午9:58
 **/
public class T1 {

    public static int findmingap(int[] arr){

        if(arr == null || arr.length<4){
            return -1;
        }
        int gap1 = Math.abs(arr[0]+arr[1]-arr[2]-arr[3]);
        int gap2 = Math.abs(arr[0]+arr[2]-arr[1]-arr[3]);
        int gap3 = Math.abs(arr[0]+arr[3]-arr[1]-arr[2]);
        int min = gap1;
        if(gap1 > gap2){
            min = gap2;
        }

        return Math.min(gap3,min);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int[] arr = new int[str.length];
        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        System.out.print(findmingap(arr));

    }


}
