package Test360;

import java.util.Scanner;

/**
 * @ClassName: T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/24 下午6:50
 **/
public class T1 {


    public static int getCount(String str1,String str2){
        if(str1==null || str2==null || str1.length() != str2.length())
            return 0;
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] result = new int[len2+1][len1+1];
        for(int i=1;i<=len1;i++)
            result[0][i] = i;
        for(int i=1;i<=len2;i++)
            result[i][0] = i;
        for(int i=1;i<=len2;i++){
            for(int j=1;j<=len1;j++){
                result[i][j] = Math.min(Math.min(result[i-1][j]+1,result[i][j-1]+1),(str1.charAt(j-1)==str2.charAt(i-1)?result[i-1][j-1]:result[i-1][j-1]+1));
            }
        }
        return result[len2][len1];
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();
        if(str1.length() > 100000 || str2.length() > 100000)
            return;
        int count = getCount(str1,str2);
        System.out.print(count);

    }


}
