package HUAWEI;

import sun.rmi.transport.proxy.CGIHandler;

import java.util.*;

/**
 * @ClassName: T4PrintString
 * @Description: 输入一个字符串,得到该字符串包含的字符集合
 *          例: 输入abcabc   输出abc
 *          思路: 方法一: hash法,使用能保持字符串原有顺序的hashset来保存字符串每一个字符
 *               方法二: 双重循环法,每扫描到一个字符就检查其前面是否有相同的字符,没有就插入到集合中
 * @Author:xuwen
 * @Date: 2020/2/11 下午4:59
 **/
public class T4PrintString {

    //==========================方法一:hashset法==============
    public static void PrintString_1(String str){

        //使用LinkedHashSet保持原有的顺序存入set
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }
        int index=0;
        char[] c = new char[set.size()];
        for(char s:set){
            c[index++] = s;
        }
        String result = new String(c);
        System.out.println(result);
    }

    //=============================方法二: 一般方法================
    public static void PrintString_2(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(int i=0;i<str.length();i++){
            int flag =0;
            for(int j=0;j<i;j++){
                if(str.charAt(i) == str.charAt(j))
                    flag =1;
            }

            if(flag == 0)
                list.add(str.charAt(i));
        }

        String result = list.toString();
        System.out.println(result);
    }

    public static void main(String[] args){

        System.out.print("请输入字符串: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print("方法一打印的字符串集合为: ");
        PrintString_1(str);

        System.out.print("方法二打印的字符串集合为: ");
        PrintString_2(str);
    }



}
