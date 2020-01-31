package JavaAlgorithmInterview.StringList;

import java.util.Scanner;

/**
 * @ClassName: P192ReverseString
 * @Description: 对字符串进行翻转,要求实现字符串的反转,要求不使用任何系统的方法,而且时间复杂度最小
 *          方法一: 临时变量法     时间复杂度为O(n)
 *                 定义一个中间变量来交换两个值,temp=a, a=b, b=temp;
 *          方法二: 直接交换法     时间复杂度为O(n)
 *                 在交换两个字符时可以用异或的方法: 比如要交换a和b
 *                 1. a=a^b
 *                 2. b=a^b //b=a^b=(a^b)^b=a^(b^b)=a^0=a
 *                 3. a=a^b //a=a^b=(a^b)^a=(b^a)^a=b^(a^a)=b^0=b
 *
 *          引申要求: 如何实现单词的反转,把一个句子中的单词进行反转,例如:'how are you' 反转为 'you are how'
 *              方法: 对字符串进行两次反转,
 *                   第一次对整个字符串中的字符进行反转,反转结果为'uoy era woh'
 *                   第二次对每个单词进行反转即可得到想要的结果: 'you are how'
 *
 * @Author:xuwen
 * @Date: 2020/1/31 下午4:27
 **/
public class P192ReverseString {

    //==========================方法一:临时变量法=======================
    public static String reverseString_1(String str){

        char[] ch = str.toCharArray();//将字符串转换为字符数组
        int len = ch.length;
        char tmp;
        for(int i=0,j=len-1;i<j;i++,j--){

            tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;

        }

        return new String(ch);

    }

    //=========================方法二: 直接交换法===========================
    public static String reverseString_2(String str){

        char[] ch = str.toCharArray();//将字符串转换为字符数组
        int len = ch.length;

        for(int i=0,j=len-1;i<j;i++,j--){

            ch[i] = (char)(ch[i]^ch[j]);
            ch[j] = (char)(ch[i]^ch[j]);
            ch[i] = (char)(ch[i]^ch[j]);

        }

        return new String(ch);

    }

    //=========================引申要求:实现单词的反转=======================
    /*
     * @Author: xw
     * @Description: 实现字符串反转//TODO
     * @Date: 下午5:30 2020/1/31
     * @Param: [ch, front, end]
     * @Return: void
     **/
    public static void reserve(char[] ch,int front,int end){

        while (front < end){

            ch[front] = (char)(ch[front]^ch[end]);
            ch[end] = (char)(ch[front]^ch[end]);
            ch[front] = (char)(ch[front]^ch[end]);
            front++;
            end--;
        }

    }


    public static String swapWords(String str){

        //对整个字符串进行反转的操作
        int len = str.length();
        char[] ch = str.toCharArray();
        reserve(ch,0,len-1);
        int begin = 0;
        //对每一个单词进行反转操作
        for(int i=1;i<len;i++){
            if(ch[i]==' '){
                reserve(ch,begin,i-1);
                begin = i+1;
            }

        }
        reserve(ch,begin,len-1);
        return new String((ch));

    }




    public static void main(String[] args){

        System.out.print("请输入字符串: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        String str_new = reverseString_2(str);
        System.out.print("字符串反转后的结果为:"+ str_new);

        System.out.print("\n请输入句子: ");
        Scanner sc1 = new Scanner(System.in);
        String s = sc1.nextLine();
        sc.close();
        sc1.close();
        String str1 = swapWords(s);
        System.out.print("句子反转后的结果为:"+ str1);
    }

}
