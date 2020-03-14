package Baidu;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName: T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/14 下午6:55
 **/
public class T1 {

    public static class hashwater{
        int mark;
        int count;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int num = Integer.parseInt(str[0]);
        int sort = Integer.parseInt(str[1]);
        String[] str1 = sc.nextLine().trim().split(" ");
        int[] arr = new int[num];
        for(int i=0;i<num;i++){
            arr[i] = Integer.parseInt(str1[i]);
        }
        sc.close();
        HashMap<Integer,hashwater> hashMap = new HashMap<>();
        for(int i=0;i<arr.length;i++){

            if(hashMap.containsKey(arr[i])){
                if(hashMap.get(arr[i]).mark==1){
                    hashMap.get(arr[i]).mark=0;
                }else {
                    hashMap.get(arr[i]).count++;
                    hashMap.get(arr[i]).mark=1;
                }
            }else {
                hashwater hs = new hashwater();
                hs.mark=1;
                hs.count=1;
                hashMap.put(arr[i],hs);
            }
        }
        int result=0;
        for(HashMap.Entry<Integer,hashwater> entry: hashMap.entrySet()){
            result += entry.getValue().count;
        }
        System.out.print(result);

    }


}
