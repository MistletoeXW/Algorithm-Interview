package HUAWEI;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @ClassName: T7FindNumInAandB
 * @Description: 给定两个已经升序排序好的的序列A={a1,a2,a3,...an} 和B={b1,b2,b3...bn} ，一个数R，找出满足以下条件的的（ai,bj）序列对
                 1. ai <= bj
                 2. bj和ai两者的距离 满足 bj-ai<=R ,要是该条件不满足，就从序列B中找出 和ai 距离最接近R的一个点bj（同时要满足条件1）
            输入案例: A={1,3,5}, B={2,4,6},R=1
            输出案例: (1,2)(3,4)(5,6)

            思路: 首先要对输入的组字符串进行正则,提取出两个数组,然后在遍历
 * @Author:xuwen
 * @Date: 2020/2/12 上午10:47
 **/
public class T7FindNumInAandB {

    public static void PrintFindNum(int[] a,int[] b,int r){

        for(int i=0;i<a.length;i++){
            int min = Integer.MAX_VALUE;
            int indexj =0;
            for(int j=0;j<b.length;j++){
                if(a[i] <= b[j] && ((b[j] - a[i]) <= r)) {
                    int gap = b[j] - a[i];
                    if (Math.abs(gap - r) < min) {
                        min = Math.abs(gap - r);
                        indexj = j;
                    }
                }
            }
            if(a[i] <= b[indexj]){
                System.out.print("(" + a[i] + "," + b[indexj] + ")");
            }
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        String regex = "A=\\{(.*?)\\},B=\\{(.*?)\\},R=(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m = pattern.matcher(str);
        m.find();
        String a = m.group(1);
        String b = m.group(2);
        String r = m.group(3);

        String[] as = a.trim().split(",");
        String[] bs = b.trim().split(",");

        int[] arrA = new int[as.length];
        for(int i=0;i<as.length;i++)
            arrA[i] = Integer.parseInt(as[i]);

        int[] arrB = new int[bs.length];
        for(int i=0;i<bs.length;i++)
            arrB[i] = Integer.parseInt(bs[i]);

        int R = Integer.parseInt(r);

        PrintFindNum(arrA,arrB,R);
    }




}
