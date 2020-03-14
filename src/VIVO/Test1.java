package VIVO;

import java.util.Scanner;

/**
 * @ClassName:Test1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/8 下午2:54
 **/
public class Test1 {

    public static int solution (int n) {
        if(n == 0)
            return 0;
        int date = 1;
        int result = 0;
        int dateresult = 0;
        while(dateresult <= n){
            result = result + date * date;
            dateresult = dateresult + date;
            date++;
        }
        result = (n-dateresult)*(date-1) + result;
        return result;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int result = solution(num);
        System.out.print(result);

    }

}
