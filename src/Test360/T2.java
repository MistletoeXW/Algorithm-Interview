package Test360;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @ClassName:T2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/24 下午8:47
 **/
public class T2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int n=Integer.parseInt(str[0]);
        int m=Integer.parseInt(str[1]);
        if(n<0 || n>1000 || m<0 || m>1000)
            return;
        int count = (m+n)/2;
        double result=(double) n/(n+m);
        double mul = 1;
        for(int j=1;j<=count;j++){
            for(int i=1;i<=j;i++){
                mul = mul * (double) m/(n+m);
                m--;
                if(m==0)
                    mul = 0;
            }
            result = result + mul*n/(n+m);
        }
        DecimalFormat df = new DecimalFormat("0.0000");
        String e = df.format(result);
        System.out.print(e);
    }

}
