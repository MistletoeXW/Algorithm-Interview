package JavaAlgorithmInterview.StringList;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName:P183PermutationString
 * @Description: 求一个字符串的所有排列,当输入一个字符串时,要求输出这个字符串的所有排列
 *           例如: 输入字符串abc,要求输出由字符a,b,c所能排列出来的所有字符串: abc,acb,bac,bca,cab,cba
 *           方法一: 递归法(以abc为例) 时间复杂度为O(n!)
 *                  1. 首先固定第一个字符a,然后对其后的bc进行全排列
 *                  2. 交换字符a和字符b,然后固定第一个字符b,对其后的ac进行全排列
 *                  3. 由于上一步交换了ab,因此,首先要再次交换a和b使其回复到原来的顺序,
 *                     然后交换第一个字符a和第三个字符c,然后再固定字符c,对其后的ab进行全排列
 * @Author:xuwen
 * @Date: 2020/1/31 下午12:06
 **/
public class P183PermutationString {

    //=================================方法一: 递归法=====================================
    /*
     * @Author: xw
     * @Description: 交换字符数组下标为i和j对应的字符//TODO 
     * @Date: 下午2:33 2020/1/31
     * @Param: [str, i, j]
     * @Return: void
     **/
    public static void swap(char[] str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
    
    /*
     * @Author: xw
     * @Description: 对字符串当中的字符进全排列//TODO
     * @Date: 下午2:36 2020/1/31
     * @Param: [str, start][待排序的字符串,待排序的字符串的首字母下标]
     * @Return: void
     **/
    public static void Permutation(char[] str,int start){

        if(str == null || start<0)
            return;
        //完成全排列后输出当前排列的字符串
        if(start == str.length-1){
            System.out.print(Arrays.toString(str) +" ");
        }else {
            for(int i=start;i<str.length;i++){

                //交换start和i所在位置的字符
                swap(str,start,i);
                //固定第一个字符,对剩余的字符进行全排列
                Permutation(str,start+1);
                //还原start和i所在位置的字符
                swap(str,start,i);

            }
        }
    }

    public static void main(String[] args){

        System.out.print("请输入字符串:" );
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();

        char[] s = str.toCharArray();//将字符串转化为数组
        System.out.print("这个字符串的所有排列为:");
        Permutation(s,0);

    }
    
    

}
