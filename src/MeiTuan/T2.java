package MeiTuan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: T2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/12 下午6:35
 **/
public class T2 {


    public static int getNum(int[] arr,int num){
        if(arr == null)
            return 0;
        HashMap<Integer,Integer> arrMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){

            if(! arrMap.containsKey(arr[i])){
                arrMap.put(arr[i],1);
            }else {
                int count = arrMap.get(arr[i]);
                arrMap.put(arr[i],count+1);
            }
        }
        int maxcount = 0;
        for(HashMap.Entry<Integer,Integer> entry: arrMap.entrySet()){
            int result = num | entry.getKey();
            if(arrMap.containsKey(result) && result != entry.getKey()){
                int count = arrMap.get(result);
                int res = count + entry.getValue();
                if(res > maxcount){
                    maxcount = res;
                }
            }else {
                if(maxcount < entry.getValue()){
                    maxcount = entry.getValue();
                }
            }
        }
        return maxcount;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int len = Integer.parseInt(str[0]);
        int num = Integer.parseInt(str[1]);
        if(len <0 || len >100000 || num<0 || num > 1000)
            return;
        String[] arrStr = sc.nextLine().trim().split(" ");
        if(arrStr.length != len)
            return;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[i] = Integer.parseInt(arrStr[i]);
            if(arr[i] <0 || arr[i] > 1000)
                return;
        }

        int result = getNum(arr,num);
        System.out.print(result);

    }




}
