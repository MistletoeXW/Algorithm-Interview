package HUAWEI;

import java.util.Scanner;

/**
 * @ClassName: T10TwoStrContain
 * @Description: 两个字符串input1和input2,字符串中元素的值域是26个大写字母,
 *               判断input2中的所有字符是否都包括在字符串input1中
 *         输入案例: BBDDCFFEL
 *                  LCEFB
 *         输出:    true
 *
 *         思路: 方法一: 一般方法, 双层循环判断,时间复杂度为O(m*n)
 *              方法二: 空间换时间, 使用一个26大小的数组,记录字母是否出现的
 * @Author:xuwen
 * @Date: 2020/2/12 下午6:26
 **/
public class T11TwoStrContain {

    //方法一: 判断input2字符串是否包含在input1
    public static boolean isContain_1(char[] input1,char[] input2){

        for(int i=0;i<input2.length;i++){
            int j =0;
            for(j=0;j<input1.length;j++){
                if(input2[i] == input1[j])
                    break;
            }
            if(j >= input1.length)
                return false;
        }

        return true;
    }

    //方法二: 空间换时间的方法
    public static boolean isContain_2(char[] input1,char[] input2){

        boolean[] bool = new boolean[26];
        for(int i=0;i<input1.length;i++){
            bool[input1[i]-'A'] = true;
        }

        for(int i=0;i<input2.length;i++){
            if(!bool[input2[i] - 'A'])
                return false;
        }
        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String input1 = sc.nextLine();
        String input2 = sc.nextLine();
        sc.close();

        System.out.println(isContain_1(input1.toCharArray(),input2.toCharArray()));

        System.out.println(isContain_2(input1.toCharArray(),input2.toCharArray()));

    }

}
