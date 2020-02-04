package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T10_2JumpFloor
 * @Description: 青蛙跳台阶问题
 *          一只青蛙一次可以跳上1级台阶,也可以跳上2级.求一只青蛙跳上n级的台阶总共有多少种跳法
 *          1. 当n=1时,只有一种跳法
 *          2. 当n=2时,有两种跳法
 *          3. 跳n阶台阶, 可以先跳1阶台阶,再跳n-1阶台阶; 或者先跳2阶台阶,再跳n-2阶台阶
 *             而n-1和n-2阶台阶的跳法可以看成是子问题,该问题的递归公式为:
 *             f(n) =   1  , n=1
 *                      2  , n=2
 *                      f(n-1)+f(n-2) , n > 2
 * @Author:xuwen
 * @Date: 2020/2/3 下午5:33
 **/
public class T10_2JumpFloor {

    public static int JumpFloor(int n){

        if(n<=2)
            return n;
        int pre2=1,pre1=2;
        int result=0;
        for(int i=2;i<n;i++){
            result = pre2+pre1;
            pre2 = pre1;
            pre1 = result;

        }
        return result;

    }

    public static void main(String[] args){

        System.out.print("请输入台阶数: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.print("总共的跳法为: "+JumpFloor(n));

    }



}
