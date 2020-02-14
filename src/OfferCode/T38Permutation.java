package OfferCode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

/**
 * @ClassName: T38Permutation
 * @Description: 字符串的全排列: 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，
 *               则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 *          思路: 1. 固定一个字母,对其后的字母进行全排列
 *                2. 交换第一个字母和第二个字母,固定第一个字母,对其后的字母进行全排序,结束后交换回字母
 *                3. 交换第一个字母和第三个字母,固定第一个字母,对其后的字母进行全排序,结束后交换回字母
 *                3. 递归下去
 *
 *         改进: 上述题目中要求不能包含重复的字母,主这样的化,排;列的结果会有很多重复,所以以下进行改进:
 *           主要思路为: 从第一个字符起每一个字符分别与它后面非重复出现的字符进行交换
 *                      在递归方法的基础上只需要增加一个判断字是否重复的函数即可
 *
 * @Author:xuwen
 * @Date: 2020/2/14 下午1:35
 **/
public class T38Permutation {

    public static void swap(char[] str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    //=======================没有添加去重操作前============================
    public static void Permutation(char[] str,int start){

        if(str==null || start<0)
            return;
        if(start == str.length-1){
            System.out.print(new String(str)+" ");
        }else {

            for(int i=start;i<str.length;i++){
                //交换start和i所在位置
                swap(str,start,i);
                //固定第一个字符,对其后的字母进行递归全排列
                Permutation(str,start+1);
                //还原start与i所在位置的字符
                swap(str,i,start);
            }
        }
    }

    //=======================添加去重操作后============================

    //判断[begin,end]区间中是否有字符与*end相等
    public static boolean isDup(char[] str,int begin,int end){

        for(int i=begin;i<end;i++){

            if(str[i]==str[end])
                return false;
        }
        return true;

    }

    //加上去重操作后的全排列函数
    public static void Permutation_Noloop(char[] str,int start){

        if(str == null || start<0)
            return;

        if(start == str.length-1){
            System.out.print(new String(str) + " ");
        }else {

            for(int i=start;i<str.length;i++){

                //首先要判断要交换的位置的值是否有重复
                if(!isDup(str,start,i))
                    continue;
                //交换开头与第i位置的值
                swap(str,start,i);

                //递归遍历子序列
                Permutation_Noloop(str,start+1);

                //还原交换的值
                swap(str,i,start);

            }

        }


    }



}
