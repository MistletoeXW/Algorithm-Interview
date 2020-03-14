package MeiTuan;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: T3
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/12 下午8:22
 **/
public class T3 {

    private static int count =0;

    public static void printToMaxOfNum_2(int n,int low,int high,int num){
        if(n<=0)
            return ;
        char[] number = new char[n];

        printToMaxOfNum(number,0,low,high,num);
    }

    public static void  printToMaxOfNum(char[] number,int digit,int low,int high,int num){
        if(digit == number.length){
            int sum = 0;
            for(int i=0;i<number.length;i++){
                sum += (char)(number[i]+'0');
            }
            if(sum % num ==0)
                count++;
            return;
        }

        for(int i=low;i<=high;i++){
            number[digit] = (char)(i+'0');
            printToMaxOfNum(number,digit+1,low,high,num);
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int len = Integer.parseInt(str[0]);
        int num = Integer.parseInt(str[1]);
        int low = Integer.parseInt(str[2]);
        int high = Integer.parseInt(str[3]);
        if(len < 0 || num < 0 || num > 10 || low > high || low < 0)
            return;
        printToMaxOfNum_2(len,low,high,num);
        System.out.print(count);

    }
}
