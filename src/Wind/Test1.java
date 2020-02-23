package Wind;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: Test1
 * @Description: 输入一个递增排序的数组nums和一个数字target，在数组中查找两个数，使得它们的和正好是target。如果有多对数字的和等于target，输出全部组合。
 *          输入: nums = [1,2,4,7,8,11,15], target = 15
 *          输出: [4,11]， [7,8]
 * @Author:xuwen
 * @Date: 2020/2/23 下午10:03
 **/
public class Test1 {

    public static List<int[]> getNum(int[] arr,int target){
        List<int[]> resultList = new ArrayList<>();
        int low = 0;
        int high = arr.length-1;

        while(low < high){

            if((arr[low]+arr[high]) < target){
                low++;
            }else if((arr[low]+arr[high]) > target){
                high--;
            }else {
                int[] list = new int[2];
                list[0] = arr[low];
                list[1] = arr[high];
                resultList.add(list);
                low++;
                high--;
            }
        }
        return resultList;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int[] arr = new int[str.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
        int target = sc.nextInt();
        sc.close();

        List<int[]> result = getNum(arr,target);
        if(result.size() == 0){
            System.out.println("[-1,-1]");
        }else {
            for(int i=0;i<result.size()-1;i++){
                System.out.print("["+result.get(i)[0]+","+result.get(i)[1]+"]"+",");
            }
            System.out.println("["+result.get(result.size()-1)[0]+","+result.get(result.size()-1)[1]+"]");
        }


    }


}
