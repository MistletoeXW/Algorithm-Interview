package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T5ReplaceSpace
 * @Description: 替换空格,将一个字符串中的空格替换成"%20"
 *          方法一: 遍历到空格就把其后的字符向后移动两个位置,这样时间复杂度为O(n^2)
 *          方法二: 双指针法
 *                1. 在字符串尾部填充任意字符,使得字符串的长度等于替换之后的长度.
 *                   因为一个空格要替换成三个字符(%20),所以遍历到一个空格时,需要在尾部填充两个任意的字符
 *                2. 令p1指向字符串原来的末尾位置,p2指向字符串现在的末尾位置.p1和p2从后向前遍历
 *                   当p1遍历到一个空格时,就需要令p2指向的位置依次填充02%(注意是逆序),否则就填充上p1指向字符的值
 *                   从后向前遍历是为了改变p2所指向的内容时,不会影响到p1遍历原来字符此的内容
 *                3. 当p2遇到p1时(p2<=p1_,或者遍历结束(p1<0),退出
 * @Author:xuwen
 * @Date: 2020/2/2 上午11:37
 **/
public class  T5ReplaceSpace {

    /*
     * @Author: xw
     * @Description: 将字符串中的空格替换为"%20"//TODO
     * @Date: 下午2:39 2020/2/2
     * @Param: [s]
     * @Return: java.lang.String
     **/
    public static String replaceSpace(String s){
        StringBuffer str = new StringBuffer().append(s);
        int p1 = str.length() - 1; //令p1指向字符串末尾位置
        //统计空格个数,找到一个空格就在字符串数组后开辟两个空间
        for(int i=0;i<=p1;i++){
            if(str.charAt(i) == ' ')
                str.append("  ");//这里添加两个空格
        }

        int p2 = str.length()-1; //令p2指向字符数组末尾
        while((p1 >= 0) && (p2 > p1)){

            char c = str.charAt(p1--);
            if(c == ' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
            }else {
                str.setCharAt(p2--,c);
            }

        }

        return str.toString();

    }

    public static void main(String[] args){

        System.out.print("请输入字符串: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        sc.close();
        StringBuffer str = new StringBuffer().append(s);
        String result = replaceSpace(str);
        System.out.print("转换后的字符串为: " + str);


    }

    //========================牛客练习=========================
    public static String replaceSpace(StringBuffer str){

        if(str == null)
            return null;
        int low = str.length()-1;
        for(int i=0;i<=low;i++){
            if(str.charAt(i) == ' '){
                str.append("  ");//这里要添加俩个空格
            }
        }
        int high = str.length()-1;
        while((low < high) && low >= 0){
            char c = str.charAt(low--);
            if(c != ' '){
                str.setCharAt(high--,c);
            }else {
                str.setCharAt(high--,'0');
                str.setCharAt(high--,'2');
                str.setCharAt(high--,'%');
            }
        }

        return str.toString();

    }


}
