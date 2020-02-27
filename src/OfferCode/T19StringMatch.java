package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T19StringMatch
 * @Description: 正则表达式字符串匹配
 *        题目描述: 请实现一个函数用来匹配包括 '.' 和 '*' 的正则表达式。模式中的字符 '.' 表示任意一个字符，
 *                 而 '*' 表示它前面的字符可以出现任意次（包含 0 次）
 *        解题思路: 1. 如果当模式串第二个字符不是*时,问题比较简单.如果字符串中的第一个字符和模式串的第一个字符相匹配
 *                   那么字符串和模式串都向后移动一个字符,然后匹配剩余的字符串和模式串
 *                2. 如果当模式串中第二个字符为*时,可能有不同的情况.
 *                   一种选择是在模式串上向后移动两个字符,这相当于*和它前面的字符被忽略了,因为*可以匹配字符串中的0个字符
 *                综上所述: 如果模式中的第一个字符与字符串中第一个字符相匹配,则在字符串上移动一个字符
 *                         而在模式串上可以向后移动两个字符,也可以保持模式串不变
 *                .应该用来当做一个任意字符,*用来重复前面的字符,可以为0
 *
 * @Author:xuwen
 * @Date: 2020/2/8 下午12:45
 **/
public class T19StringMatch {

    /*
     * @Author: xw
     * @Description: 字符串匹配//TODO
     * @Date: 下午12:59 2020/2/8
     * @Param: [str, pattern]
     * @Return: boolean
     **/
    public boolean StringMatch(char[] array,int sIndex,char[] pattern,int pIndex){

        int sLen = array.length;
        int pLen = pattern.length;
        //字符串和模式字符数组都已经完成最后一个字符匹配,说明没有出现匹配失败
        if(sIndex >= sLen && pIndex >=pLen)
            return true;
        //如果模式串的每一个字符都已经参与匹配,而字符串还有字符未匹配到,说明不匹配
        if(sIndex < sLen && pIndex>=pLen)
            return false;
        //模式串的下一个字符是*,跳过直接选择模式下一个字符,因为*表示可以出现任意次
        if((pIndex+1)<pLen && pattern[pIndex+1]=='*'){
            if(sIndex >= sLen){
                //如果字符串已经全部匹配通过,跳过*,看模式串的下一个字符(模式串往下移两个字符)
                return StringMatch(array,sIndex,pattern,pIndex+2);
            }
            else {
                //如果字符串还有需要匹配的字符,如果满足以下两个条件其中之一:
                //1. 字符串要匹配的字符和模式串的当前字符相等,说明匹配
                //2. 模式串当前字符是'.',和下一个字符'*',组成'.*',就是任意字符可以出现任意次(包括0次)
                //则考虑3种情况:(这里结合书上自动机来想)
                //   1. 匹配串向后移动一位,模式串跳过*,a*表示出现一次a
                //   2. 匹配串向后移动一位,模式串不动,a*表示出现多次a
                //   3. 匹配串不动,模式串跳过*, a*表示出现0次a
                if(array[sIndex] == pattern[pIndex] || (pattern[pIndex] == '.' && array[sIndex]!='\0')){
                    return StringMatch(array,sIndex+1,pattern,pIndex+2)
                            || StringMatch(array,sIndex+1,pattern,pIndex)
                            || StringMatch(array,sIndex,pattern,pIndex+2);

                }else {
                    return StringMatch(array,sIndex,pattern,pIndex+2);
                }
            }

        }

        //如果模式串此时是'.',比较好办, 匹配串和模式串都向后移动一位
        if(array[sIndex] == pattern[pIndex] || (array[sIndex] != '\0' && pattern[pIndex] == '.')){
            return StringMatch(array,sIndex+1,pattern,pIndex+1);
        }


        return false;


    }

    public static void main(String[] args){

//        System.out.print("请输入模式串: ");
//        Scanner sc = new Scanner(System.in);
//        String pattern = sc.nextLine();
//        System.out.print("请输入匹配串: ");
//        Scanner sc1 = new Scanner(System.in);
//        String array = sc.nextLine();
//        sc.close();
//        sc1.close();

        int a = Integer.parseInt("1");
        String s = "ste"+a;

        System.out.println(s);
//
//        System.out.print("匹配结果为: ");
//        T19StringMatch object = new T19StringMatch();
//        System.out.print(object.StringMatch(array.toCharArray(),0,pattern.toCharArray(),0)+"\n");
//
    }


}
