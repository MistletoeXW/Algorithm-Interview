package OfferCode;

import sun.security.krb5.SCDynamicStoreConfig;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: T17PrintBum
 * @Description: 打印从1到最大的n位数
 *               输入数字n,按照顺序打印出1到最大的n位十进制数.比如输入3,则打印出 1、2、3 一直到最大的 3 位数即 999
 *         解题思路: 此题关键在于处理大数问题, 打印的数有超出范围的情况发生,所以得使用字符串打印数字
 *                  所以此题要跳过陷阱,在字符串上模拟数字加法的解法
 *         方案一: 字符串一般方法,首先把字符串中每一位数字都初始化为'0',然后每一次为字符串表示的数字+1
 *                再打印出来,因此,我们只需要做两件事:
 *                1. 在字符串表达的数字上加上模拟加法
 *                2. 把字符串表达的数字打印出来
 *         方案二: 回溯法
 *                由于 n 可能会非常大，因此不能直接用 int 表示数字，而是用 char 数组进行存储。
 *                使用回溯法得到所有的数。
 *                其实就是得到n个从0到9的全排列,把每一位数字都从0到9排列一遍,就得到所有的十进制数
 *                位置是依次放进去数字的，这可以用递归,每个位置上0到9的十种情况可以用for循环来遍历。
 *                然后设置下一位
 *                递归结束的条件就是我们已经设置了数字的最后一位
 * @Author:xuwen
 * @Date: 2020/2/6 下午3:10
 **/
public class T17PrintNum {

    //==============================运用字符串表示数字的一般方法====================
    /*
     * @Author: xw
     * @Description: 实现了用O(1)的时间复杂度判断是否已经到达了最大的n位数//TODO
     * @Date: 下午4:23 2020/2/6
     * @Param: [number]
     * @Return: boolean
     **/
    private boolean Increment(char[] number){
        boolean isOverflow = false;
        int nTakeOver=0;
        int nLength = number.length-1;
        for(int i=nLength-1; i>=0 ;i--){

            int nSum = number[i] - '0' + nTakeOver;
            //在末尾数+1
            if(i==(nLength-1)){
                nSum++;
            }
            if(nSum>=10){
                if(i==0)
                    isOverflow = true;
                else{
                    nSum -= 10;
                    //进位+1
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            }else {
                number[i] = (char) ('0' + nSum);
                break;
            }

        }
        return isOverflow;
    }
    //打印用字符串表示的数字
    public void PrintNumber(char[] number){
        boolean isBeginning=true;
        int nLength = number.length-1;

        for(int i=0;i<nLength;i++){
            if(isBeginning && number[i]!='0')
                isBeginning = false;
            if(!isBeginning)
                System.out.print(number[i]);
        }

        System.out.print("\n");


    }


    public void PrintToMaxOfNums(int n){
        if(n<=0)
            return;

        char[] number = new char[n+1];
        Arrays.fill(number,'0');
        number[n] = '\0';
        while(!Increment(number)){
            PrintNumber(number);
        }
    }

    //===========================回溯法=======================
    public void printToMaxOfNum_2(int n){
        if(n<=0)
            return;
        char[] number = new char[n];

        printToMaxOfNum(number,0);
    }

    /*
     * @Author: xw
     * @Description: 用递归很容易表示,数字中每一位都从0-9中的一个数,然后设置下一位
     *               递归结束的条件就是我们已经设置了数字的最后一位//TODO
     * @Date: 下午2:17 2020/2/7
     * @Param: [number, digit]
     * @Return: void
     **/
    public void  printToMaxOfNum(char[] number,int digit){
        if(digit == number.length){
            printNumber(number);
            return;
        }

        for(int i=0;i<10;i++){
            number[digit] = (char)(i+'0');
            printToMaxOfNum(number,digit+1);
        }

    }

    //打印数组中的字符
    private void printNumber(char[] number){
        int index = 0;
        //将指针移动到最高位数,因为再没达到的位数的位置是0
        while(index < number.length && number[index] =='0')
            index++;
        while(index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }


    public static void main(String[] args){

        System.out.print("请输入位数: ");
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        sc.close();

        System.out.print("打印出数为:\n");
        T17PrintNum object = new T17PrintNum();
        object.printToMaxOfNum_2(n);

    }



}
