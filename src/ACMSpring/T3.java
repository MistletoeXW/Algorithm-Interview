package ACMSpring;

import java.util.Scanner;

/**
 * @ClassName:T3
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/18 上午9:58
 **/
public class T3 {

    public static int findlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length() , b.length());
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.print(findlength(str1,str2));

    }

}
