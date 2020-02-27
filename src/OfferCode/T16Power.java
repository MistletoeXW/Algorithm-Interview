package OfferCode;

/**
 * @ClassName: T16Power
 * @Description: 浮点数的整数次方,
 *               给定一个 double 类型的浮点数 base 和 int 类型的整数 exponent，求 base 的 exponent 次方。
 *         一般做法: 此题中,在面试中最大的问题就是容易漏掉特殊情况
 *                  比如当指数为负整数时: 此时可能会想到,先把指数变为正整数,然后在求次方,最后把结果求倒
 *                  但是在求导时要注意一点,底数是否为0
 *                  所以此题是细节题,在面试时遇见类似问题要考虑全面
 *         优化做法:  (x*x)^(n/2) 可以通过递归求解，并且每次递归 n 都减小一半，因此整个算法的时间复杂度为 O(logN)。
 *                  时间复杂度就优化为O(logn)
 * @Author:xuwen
 * @Date: 2020/2/6 上午9:53
 **/
public class T16Power {

    public double Power_1(double base,int exponent){
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        boolean isNegative = false;
        if(exponent < 0){
            exponent = -exponent;
            isNegative=true;
        }
        double result = 1.0;
        for(int i=0;i<=exponent;i++)
            result *=base;
        return isNegative ? 1 / result : result;

    }

    public double Power_2(double base,int exponent){
        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        boolean isNegative = false;
        if(exponent < 0){
            exponent = -exponent;
            isNegative=true;
        }

        //这里计算(x*x)^2/n  如果n为奇数,则将数再乘一个x
        double pow = Power_2(base*base,exponent/2);
        if(exponent%2 != 0)
            pow = pow*base;
        return isNegative ? 1 / pow : pow;
    }







    //======================牛客网===============
    //方法一: 普通方法
    public double Power_11(double base,int exponent){

        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        boolean mark = false;
        if(exponent < 0){
            exponent = -exponent;
            mark = true;
        }
        double result = 1.0;
        for(int i=0;i<exponent;i++){
            result *= base;
        }
        return mark ? 1 / result : result;

    }

    //方法二: 优化方案 使用x = (x*x)^n/2
    public double Power_22(double base,int exponent){

        if(exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        boolean mark = false;
        if(exponent < 0){
            exponent = -exponent;
            mark = true;
        }
        double result = Power_22(base*base,exponent/2);
        if(exponent % 2 !=0){
            result = result*base;
        }
        return mark ? 1/result : result;

    }


}
