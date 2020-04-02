package XieChen;

import java.util.Scanner;

/**
 * @ClassName:T3
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/1 下午8:07
 **/
public class T3 {
    public static int min(int a,int b,int c){
        int tmp = Math.min(a, b);
        return Math.min(tmp, c);
    }
    public static int edit(String s1,String s2,int replaceWight){

        if(s1 == null && s2==null)
            return 0;
        if(s1==null)
            return s2.length();
        if(s2==null)
            return s1.length();
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        int i,j;

        for(i=0;i<len1;i++)
            dp[i][0] = i;
        for(i=0;i<len2;i++)
            dp[0][i] = i;
        for(i=1;i<len1+1;i++){
            for(j=1;j<len2+1;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]);
                }else {
                    dp[i][j] = min(dp[i-1][j]+1,dp[i][j-1]+1,dp[i-1][j-1]+replaceWight);
                }
            }
        }
        int dis = dp[len1][len2];
        return dis;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        String[] strings = {"surprise", "happy", "ctrip", "travel", "wellcome","student","system","program","editor"};
        for(String s:strings){
            if(edit(s,str,1) <= 2){
                System.out.print(s);
                return;
            }
        }
        System.out.print("null");

    }

}
