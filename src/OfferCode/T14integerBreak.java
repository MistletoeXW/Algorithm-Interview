package OfferCode;

import javax.swing.*;
import java.util.Scanner;

/**
 * @ClassName: T14integerBreak
 * @Description: 剪绳子, 把一根绳子剪成多段 ,并且使得每段的长度乘积最大
 *          方法一: 动态规划
 *                 在剪第一刀的时候,我们有n-1种可能的选择,也就是剪出来的第一段绳子可能长度分别为1,2,...,n-1
 *                 因此,f(n)=max(f(i)*f(n-i)).这是一个从上至下的递归公式,由于递归会有很多重复的子问题,
 *                 从而有大量不必要的重复计算.一个更好的办法就是从下至上的顺序计算,并把子问题的最优解存储下来
 *                 所以时间复杂度为:O(N^2) 空间复杂度为:O(N)
 *
 *          方法二: 贪婪算法
 *                 尽可能多剪长度为3的绳子,并且不允许有长度为1的绳子出现.如果出现了,就从已经切好长度为3的绳子中
 *                 拿出一段与长度为1的绳子重新组合,把它们切成两段长度为2的绳子
 *                 证明: 当 n >= 5 时，3(n - 3) - n = 2n - 9 > 0, 且 2(n - 2) - n = n - 4 > 0.
 *                      因此在 n >= 5 的情况下，将绳子剪成一段为 2 或者 3，得到的乘积会更大
 *                      又因为 3(n - 3) - 2(n - 2) = n - 5 >= 0，
 *                      所以剪成一段长度为 3 比长度为 2 得到的乘积更大
 *                  所以尽可能的剪长度为3的绳子
 *
 * @Author:xuwen
 * @Date: 2020/2/5 上午10:45
 **/
public class T14integerBreak {

    //=======================方法一: 动态规划========================
    public int integerBreak_1(int n){
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;//绳子长度为1时,只有一种剪法最大值为1
        dp[2] = 2;
        dp[3] = 3;
        int max =0;
        for(int i=4;i<=n;i++){
            max = 0;
            for(int j=1;j<=i/2;j++){
                int products = dp[j]*dp[i-j];
                if(max < products)
                    max = products;
            }
            dp[n] = max;
        }

        return max;
    }

    //========================方法二:贪婪算法==========================
    public int integerBreak_2(int n){

        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        //绳子可以分成多少个3段
        int timesOf3 = n/3;
        //当绳子最后剩下的长度为4时,不能再去剪长度为3的绳子段
        //此时更好的办法是把从长度为3的段中抽出一段与1相拼接为4,再分为两个两段
        if(n-timesOf3*3 == 1)
            timesOf3--;
        int timesOf2 = (n-timesOf3*3) / 2;
        return (int)(Math.pow(3,timesOf3)) * (int)(Math.pow(2,timesOf2));
    }


    public static void main(String[] args){

        System.out.print("请输入绳子长度: ");
        Scanner sc = new Scanner(System.in);
        int length = sc.nextInt();
        sc.close();
        T14integerBreak object = new T14integerBreak();
        long start1 = System.currentTimeMillis();
        System.out.print("方法一:动态规划法绳子截断后乘积最大为:"+object.integerBreak_1(length)
                        +" 所花时间为:"+ + (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        System.out.print("\n方法二:贪婪法绳子截断后乘积最大为:"+object.integerBreak_2(length)
                +" 所花时间为:"+ + (System.currentTimeMillis() - start2));

    }

}
