package HUAWEI;

import java.util.Scanner;

/**
 * @ClassName: T8ReverseString
 * @Description: 反转字符串, 同时去除中间不满足条件的分隔符
 *       题目描述:  输入字符串：I am an 20-years out–standing @ * -stu- dent
 *                 去除分割符并反转之后，输出字符串（子字符串以一个空格隔开）：dent stu standing out 20-years an am I
            分割符描述如下：
                1. 除了字母,数字和 '-' 之外，其他的都是分割符，如输入字符串中的'@'等都属于分割符
                2. 20-years中的’-’ 表示的是连接符，即当‘-’两边都有字母、数字时，‘-’就属于连接符，否则属于分割符
                3. out–standing中的‘–’表示分割符，应该拆分为两个字字符串out 和 standing
        思路: 1. 首先处理分割符,将分割符变成空格替代
              2. 先将整个字符串进行反转, 然后再遍历每一个分隔符分割的单词, 对每个单词进行反转
 * @Author:xuwen
 * @Date: 2020/2/12 下午1:30
 **/
public class T9ReverseString {

    //对字符串进行反转
    //采用头尾指针交换的方法
    public static void ReverseStr(char[] ch,int start,int end){

        while(end > start){
            ch[start] = (char)(ch[start]^ch[end]);
            ch[end] = (char)(ch[start]^ch[end]);
            ch[start] = (char)(ch[start]^ch[end]);
            start++;
            end--;
        }
    }

    //对语句进行反转
    public static String swapWords(String str){

        //首先对语句进行整体反转
        int len = str.length();
        char[] ch = str.toCharArray();
        ReverseStr(ch,0,len-1);
        int begin =0;
        //对每个单词进行发转
        for(int i=1;i<len;i++){

            if(ch[i] == ' '){
                ReverseStr(ch,begin,i-1);
                begin=i+1;
            }
        }
        ReverseStr(ch,begin,len-1);
        return new String(ch);
    }

    public static void main(String[] args){

        System.out.print("请输入字符串: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        StringBuilder s = new StringBuilder(str);

        //处理分割符
        for(int i=0;i<s.length()-1;i++){

            //处理'-'字符, 判断'-'字符前后是否有数字,如果没有则判定为分割符
            if(s.charAt(i)=='-' &&
                    !((Character.isDigit(s.charAt(i-1)) && Character.isLetter(s.charAt(i+1)))
                       || (Character.isDigit(s.charAt(i-1))) && Character.isLetter(s.charAt(i+1)))){
                if(s.charAt(i+1) == '-')
                    s.replace(i,i+2," ");
                else
                    s.replace(i,i+1," ");
            }

            //处理除了字母数字和'-'以外的分隔符
            if((!Character.isLetterOrDigit(s.charAt(i))) && s.charAt(i)!='-'){
                int j = i+1;
                while(!Character.isLetterOrDigit(s.charAt(j))){
                    j++;
                }
                s.replace(i,j," ");
            }
        }

        String string = s.toString();
        string = swapWords(string);
        System.out.print("反转后的字符串为: "+string);


    }


}
