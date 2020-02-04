package OfferCode;

import java.util.Arrays;

/**
 * @ClassName: T10_3JumpFloorII
 * @Description: 变态跳台阶
 *               一只青蛙一次可以跳上1级台阶,也可以跳上2级...它也可以跳上n级
 *               求该青蛙跳上一个n级的台阶总共有多少种跳法?
 *          方法一: 动态规划
 *          方法二: 数学推导
 *                 1. 跳上n-1阶台阶,可以从n-2级跳1上去,也可以从n-3跳2级上去...
 *                    那么: f(n-1) = f(n-2) + f(n-3) + ... + f(0)
 *                 2. 同样跳上n级台阶,可以从n-1级跳1上去,也可以从n-2级跳2级上去...
 *                    那么: f(n) = f(n-1) + f(n-2) + ... + f(0)
 *                 3. 综上所述: f(n) - f(n-1) = f(n-1)
 *                    即: f(n) = 2*f(n-1)
 * @Author:xuwen
 * @Date: 2020/2/4 上午9:47
 **/
public class T10_3JumpFloorII {

    //======================方法一: 动态规划=======================
    public static int JumpFloorII_1(int n){

        int[] dp = new int[n];
        Arrays.fill(dp,1);//将dp数组所有元素填充为1
        for(int i=1;i<n;i++)
            for(int j=0;j<i;j++)
                dp[i] += dp[j];
        return dp[n-1];
    }

}
