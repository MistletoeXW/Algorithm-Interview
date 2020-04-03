package WeiPingHui;

import java.util.Scanner;

/**
 * @ClassName:T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/3 下午6:48
 **/
public class T1 {
    public static boolean judge(String s){
        if(s == null)
            return true;
        char[] str = s.toCharArray();
        int num1 =0;
        int num2 =0;
        int num3 =0;
        for(int i=0;i<str.length;i++){
            if(num1 <0 || num2<0 || num3<0)
                return false;
            if(str[i] == '[')
                num1++;
            if(str[i] == ']')
                num1--;
            if(str[i] == '(')
                num2++;
            if(str[i] == ')')
                num2--;
            if(str[i] == '{')
                num3++;
            if(str[i] == '}')
                num3--;
        }
        if(num1 ==0 && num2==0 && num3==0)
            return true;
        else
            return false;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.print(judge(str));


    }
}
