package QIAnXin;

import java.util.Scanner;

/**
 * @ClassName:Qianxin_test2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/1/6 下午6:43
 **/
public class Qianxin_test2 {
    public static int lengthOfSubString(String str){
        int curLength = 0;
        int maxLength = 0;
        int[] posion = new int[26];
        for(int i=0;i<26;i++){
            posion[i] = 0;
        }
        for(int i = 0;i<str.length();i++){
            int Index = posion[str.charAt(i)-'a'+1];
            if(Index == 0 || (i-Index > curLength)){
                curLength++;
            }else {
                if(curLength > maxLength){
                    maxLength = curLength;
                }
                curLength = i-Index;
            }
            posion[str.charAt(i)-'a'+1] = i;
            if ((curLength > maxLength)){
                maxLength = curLength;
            }
        }
        return maxLength;
    }

    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int maxLength = lengthOfSubString(str);
        System.out.print(maxLength);
    }
}
