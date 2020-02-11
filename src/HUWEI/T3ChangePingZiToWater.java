package HUWEI;

import java.util.Scanner;

/**
 * @ClassName: T3ChangePingZiToWater
 * @Description: 空瓶子换水
 *          题目描述: 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水."
 *                   小张手上有十个空汽水瓶,他最多可以换多少瓶水?
 *          答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4
 *                   个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
 *                   然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。
 *                   如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 *         思路: 对于手中的瓶子数除以3所得商为换得的瓶子数,换的瓶子数再加上余数即为换的汽水后总的瓶子数
 *               若此时手里的瓶子数小于2个,则不能再换,否则可以再换
 * @Author:xuwen
 * @Date: 2020/2/11 下午3:55
 **/
public class T3ChangePingZiToWater {

    public static int change(int num){

        int sum=0;//换得的饮料数
        int re,s;

        while (num >= 2){

            if(num==2)
                num=num+1;
            re = num%3; //换完瓶子后的余数
            s = num/3; //手中的瓶子数除以3所得商为换得的瓶子数
            num = re+s; //换完瓶子后,加上剩下的余数得到当前手上的瓶子数
            sum = sum + s;
        }
        return sum;
    }

    public static void main(String[] args){

        System.out.print("请输入瓶子数: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();


        System.out.println("所换得的汽水数为: "+ change(num));

    }


}
