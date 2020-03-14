package VIVO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName:Terst2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/8 下午3:35
 **/
public class Terst2 {

    public static int solution (int n) throws Exception{

        if(n<=9){
            return n+10;
        }
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        for(int i=9;i>1;i--){
            while (n%i==0){
                n = n/i;
                resultList.add(i);
            }
        }
        if(n!=1)
            return -1;
        long result = 0;
        try {
            for(int i=resultList.size()-1;i>=0;i--){
                result = result*10 + resultList.get(i);
            }
            return (int) result;
        }catch (Exception e){
            return -1;
        }

    }

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int result = solution(num);
        System.out.print(result);

//        String[] str = sc.nextLine().trim().split(",");
//        int[] num = new int[str.length];
//        for(int i=0;i<str.length;i++){
//            num[i] = Integer.parseInt(str[i]);
//        }
//
//        System.out.print(solution(num[0],num[1]));

    }


}
