package DongFang;

import java.util.EventListener;
import java.util.Scanner;

/**
 * @ClassName:T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/12 下午9:06
 **/
public class T1 {

    public static boolean judge(String str1,String str2,String str3){

        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        char[] char3 = str3.toCharArray();
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for(index3=0;index3<str3.length();index3++){
            if(index1 < str1.length() && char3[index3] == char1[index1]){
                index1++;
            }
            if(index2 < str2.length() && char3[index3] == char2[index2]){
                index2++;
            }
        }

        if(index1 > str1.length()-1 && index2 > str2.length()-1)
            return true;
        else
            return false;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().trim().split(" ");
        String str1 = strings[0];
        String str2 = strings[1];
        String str3 = strings[2];
        if(judge(str1,str2,str3)){
            System.out.print("TRUE");
        }else {
            System.out.print("FALSE");
        }

    }

}
