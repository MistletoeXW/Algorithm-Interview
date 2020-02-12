package HUAWEI;

import java.util.*;

/**
 * @ClassName: T926BNumSum
 * @Description: 2个大整数相加,每一位是一个小写字母,26进制,a表示0,z表示25
 *          输入案例: z
 *                   bc
 *          输出:     cb
 *
 *          思路: 在俩个列表中设置两个同步指针进行遍历,再设置一个进位标志
 *               两个数每一个位相加+进位值,如果相加值大于25则进位
 * @Author:xuwen
 * @Date: 2020/2/12 下午4:40
 **/
public class T926BNumSum {

    public static ArrayList<Integer> add(int[] a,int[] b){

        ArrayList<Integer> result = new ArrayList<>();
        int jw = 0;//进位
        int indexA = a.length-1; //遍历数组a的指针
        int indexB = b.length-1; //遍历数组b的指针
        //双指针遍历两个列表
        while(indexA >= 0 && indexB >= 0){
            int sum = (a[indexA] + b[indexB]) % 26 + jw;
            if(a[indexA] + b[indexB] > 25){
                jw = 1;
            }
            result.add(sum);
            indexA--;
            indexB--;
        }

        //如果a数组还没遍历完
        while(indexA >= 0){
            int sum = a[indexA] + jw;
            result.add(sum);
            indexA--;
            if(sum > 25){
                jw = 1;
            }else {
                jw = 0;
            }
        }

        //如果b数组还没遍历完
        while(indexB >= 0){
            int sum = b[indexB] + jw;
            result.add(sum);
            indexB--;
            if(sum > 25){
                jw = 1;
            }else {
                jw =0;
            }
        }

        //如果最终还存在进位
        if(jw == 1){
            result.add(0);
        }

        return result;

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        sc.close();

        int[] arrA = new int[s1.length()];
        int[] arrB = new int[s2.length()];

        for(int i=0;i<s1.length();i++){
            arrA[i] = s1.charAt(i)-'a';
        }
        for(int i=0;i<s2.length();i++){
            arrB[i] = s2.charAt(i)-'a';
        }

        ArrayList<Integer> result = add(arrA,arrB);
        Collections.reverse(result);
        for(Integer num : result){
            System.out.print((char)(num+'a'));
        }

    }



}
