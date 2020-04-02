package XieChen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName:T2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/1 下午8:40
 **/
public class T2 {

    static int calcMinStaff(ArrayList<int[]> arrayList) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int minTime = 0;
        int count = 0;
        for(int[] arr: arrayList){
            if(arr[0] <= minTime)
                count++;
            if(arr[1] < minTime){
                minTime = arr[1];
            }
        }
        return count;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        int res = in.nextInt();
        ArrayList<int[]> result = new ArrayList<>();
        for(int i=0;i<res;i++){
            String[] str = in1.nextLine().trim().split(",");
            int[] arr = new int[str.length];
            arr[0] = Integer.parseInt(str[0]);
            arr[1] = Integer.parseInt(str[1]);
            result.add(arr);
        }
        res = calcMinStaff(result);
        System.out.println(String.valueOf(res));

    }


}
