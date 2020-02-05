package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T10_1Fibonacci
 * @Description: 斐波那契数递归与非递归的求解及比较,求斐波那契数列的第n项,n <= 39
 *         方法一: 递归法 (时间复杂度以n的指数的方式递增)
 *                如果使用递归求解,可以通过递归画出递归树,发现会产生很多重复的结点
 *                而且重复的结点会随着n的增大而急剧增加,
 *                例如，计算 f(4) 需要计算 f(3) 和 f(2)，
 *                计算 f(3) 需要计算 f(2) 和 f(1)，可以看到 f(2) 被重复计算了
 *                所以我们要设法避免重复计算
 *         方法二: 动态规划,递归是将一个问题划分成多个子问题求解，动态规划也是如此，
 *                但是动态规划会把子问题的解缓存起来，从而避免重复求解子问题。
 *                时间复杂度为O(N),空间复杂度O(n)
 *         方法三: 考虑到第 i 项只与第 i-1 和第 i-2 项有关，因此只需要存储前两项的值就能求解第 i 项，
 *                从而将空间复杂度由 O(N) 降低为 O(1)。
 *                时间复杂度为O(N),空间复杂度O(1)
 *
 *
 *         递归的显著缺点:
 *                递归由于是函数调用自身,而函数调用是有时间和空间的消耗的:
 *                每一次函数调用,都要在内存栈中分配空间以保存参数,返回地址,及临时变量
 *                而且往栈;里压入数据和弹出数据都需要时间
 * @Author:xuwen
 * @Date: 2020/2/3 上午11:14
 **/
public class T10_1Fibonacci {

    /*
     * @Author: xw
     * @Description: 方法一:递归法//TODO
     * @Date: 上午11:26 2020/2/3
     * @Param: [n]
     * @Return: int
     **/
    public static int Fibonacci_1(int n){

        if(n<=0)
            return 0;
        if(n == 1)
            return 1;
        return Fibonacci_1(n-1)+Fibonacci_1(n-2);
    }

    /*
     * @Author: xw
     * @Description: 方法二:动态规划//TODO
     * @Date: 上午11:31 2020/2/3
     * @Param: [n]
     * @Return: int
     **/
    public static int Fibonacci_2(int n){

        if(n<=1)
            return n;
        int[] fib = new int[n + 1]; //将子问题缓存起来
        fib[1] = 1;
        for(int i=2;i<=n;i++)
            fib[i] = fib[i-1] + fib[i-2];
        return fib[n];
    }

    /*
     * @Author: xw
     * @Description: 对动态规划缓存的优化//TODO
     * @Date: 上午11:35 2020/2/3
     * @Param: [n]
     * @Return: int
     **/
    public static int Fibonacci_3(int n){
        if (n<=1)
            return n;
        // 考虑到第i项只与第i-1和第i-2项有关,
        // 因此只需要存储前两项的值就能求解第i项
        int pre2 = 0;
        int pre1 = 1;
        int fib = 0;
        for(int i=2;i<=n;i++){
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.print("请输入要查找的斐波那契数第n项:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long start1 = System.currentTimeMillis();
        System.out.print("方法一: 第"+n+"项的Fibonacci数为:"+Fibonacci_1(n)+
                "  所用时间为:"+ (System.currentTimeMillis() - start1));

        long start2 = System.currentTimeMillis();
        System.out.print("\n方法二: 第"+n+"项的Fibonacci数为:"+Fibonacci_2(n)+
                "  所用时间为:"+ (System.currentTimeMillis() - start2));

        long start3 = System.currentTimeMillis();
        System.out.print("\n方法三: 第"+n+"项的Fibonacci数为:"+Fibonacci_3(n)+
                "  所用时间为:"+ (System.currentTimeMillis() - start3));

    }


}
