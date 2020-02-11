package HUAWEI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: T5StudentSocre
 * @Description: 学生成绩查询及更新
 *       输入描述: 输入包括多组测试数据. 每组输入第一行是两个正整数N和M（0<N<=30000,0<M<5000）,分别代表学生的数目和操作的数目.
 *                学生ID编号从1到N.第二行包含N个整数,代表这N个学生的初始成绩,其中第i个数代表id为i的学生的成绩
 *                接下来又是M行,每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为’Q’的时候, 表示这是一
 *                条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 *                当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *       输入例子: 5 7
 *                1 2 3 4 5
 *                Q 1 5
 *                U 3 6
 *                Q 3 4
 *                Q 4 5
 *                U 4 5
 *                U 2 9
 *                Q 1 5
 *       输出例子:  5
 *                 6
 *                 5
 *                 9
 *       思路: 此题主要考察寻找数组最大值和输入格式的处理
 * @Author:xuwen
 * @Date: 2020/2/11 下午6:44
 **/
public class T5StudentSocre {

    //找出数组中的两下标之间的最大值
    public static int findMax(int[] arr,int start,int end){
        if(start > end || arr==null)
            return 0;
        int max = 0;
        for(int i=start;i<=end;i++){
            if(arr[i] > max)
                max = arr[i];
        }
        return max;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int student = Integer.parseInt(a[0]);
        int pot = Integer.parseInt(a[1]);

        String[] b = sc.nextLine().trim().split(" ");
        int[] sorces = new int[student];
        for(int i=0;i<student;i++){
            sorces[i] = Integer.parseInt(b[i]);
        }

        ArrayList<String> input = new ArrayList<>();

        for(int i=0;i<pot;i++){
            String str = sc.nextLine();
            input.add(str);
        }

        for(String str: input){
            int start = Integer.parseInt(String.valueOf(str.charAt(2)));
            int end = Integer.parseInt(String.valueOf(str.charAt(4)));
            if(str.charAt(0) == 'Q'){
                System.out.println(findMax(sorces,start-1,end-1));
            }
            else if(str.charAt(0) == 'U'){
                sorces[start-1] = end;
            }
        }



    }









}
