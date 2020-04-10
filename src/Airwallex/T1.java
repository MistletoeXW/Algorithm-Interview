package Airwallex;

import java.util.Scanner;

/**
 * @ClassName:T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/10 下午7:48
 **/
public class T1 {

    public static void reverse(char[] ch,int low,int high){

        while (low<high){
            char tmp = ch[low];
            ch[low] = ch[high];
            ch[high] = tmp;
            low++;
            high--;
        }
    }

    public static String swapWords(String str){
        int len = str.length();
        char[] ch = str.toCharArray();

        int begin = 0;
        for(int i=1;i<len;i++){
            if(ch[i]==' '){
                //遇到空格则将其前的单词进行反转
                reverse(ch,begin,i-1);
                begin = i+1;
            }
        }
        reverse(ch,begin,len-1);
        return new String(ch);
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.print(swapWords(str));

    }

}
