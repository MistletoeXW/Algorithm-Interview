package Wind;

import java.util.Scanner;

/**
 * @ClassName: T2
 * @Description: 输入一个正数target，打印出所有和为target的连续正数序列（至少含有两个数）。
 *               例如输入15，由于1＋2＋3＋4＋5＝4＋5＋6＝7＋8＝15，所以结果打印出3个连续序列1～5、4～6和7～8
 * @Author:xuwen
 * @Date: 2020/2/23 下午10:30
 **/
public class T2 {

    public static void printSumList(int target){

        int low = 1;
        int high = 2;
        int mid = target/2;
        while(low <= mid){
            int sum = 0;
            for(int i=low;i<=high;i++){
                sum += i;
            }
            if(sum < target){
                high++;
            }else if(sum > target){
                low++;
            }else {
                System.out.println(low+"~"+high);
                high++;
            }
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        printSumList(target);


    }



}
