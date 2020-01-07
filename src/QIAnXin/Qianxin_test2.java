package QIAnXin;

import java.util.*;

/**
 * @ClassName:Qianxin_test2
 * @Description:
 * 描述：
 * 给定一个字符串，找到最长子串的长度，而不重复字符。
 *
 * 例子：
 * 给定"abcabcbb"的答案是"abc"，长度是3。
 *
 * 给定"bbbbb"的答案是"b"，长度为1。
 *
 * 给定"pwwkew"的答案是"wke"，长度为3.请注意，答案必须是子字符串，"pwke"是子序列，而不是子字符串。
 * @Author:xuwen
 * @Date: 2020/1/6 下午6:43
 **/
public class Qianxin_test2 {
    /*
     * @Author: xw
     * @Description: 使用set来判断某字符串的子串中的所有字符都是唯一的（无重复字符）//TODO
     * @Date: 下午9:23 2020/1/7
     * @Param: [str]
     * @Return: int
     **/
    public static String lengthOfSubString_1(String str){
        Set<String> resultSet = new HashSet<>();
        for(int i=0;i<str.length();i++){
            String ch = String.valueOf(str.charAt(i));
            if(!resultSet.contains(ch)){
                resultSet.add(ch);
            }
        }
        Iterator<String> it = resultSet.iterator(); //使用迭代器对set进行遍历
        StringBuffer buf =new StringBuffer();
        while (it.hasNext()) {
            buf.append(it.next());
        }
        String result = buf.toString();
        return result;
    }


    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(str.length() <= 1) {
            System.out.print(1);
        }

        String result = lengthOfSubString_1(str);
        System.out.print(result);

        
    }
}
