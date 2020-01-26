package JavaAlgorithmInterview.ArrayList;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName:P117FindRangNNum
 * @Description: 对于一个给定的自然数N,有N+M个元素的数组,
 *               其中存放了小于或者等于N的所有自然数,求重复出现的自然数序列
 *            例子:{1,2,3,3,3,4,5,5,5,6,7,8}
 *            输出:{3,5}
 * @Author:xuwen
 * @Date: 2020/1/26 下午8:52
 **/
public class P117FindRangNNum {

    /*
     * @Author: xw
     * @Description: 找出重复的N个元素,利用Hash法//TODO
     * @Date: 下午8:57 2020/1/26
     * @Param: [ary, num]
     * @Return: java.util.HashSet<java.lang.Integer>
     **/
    public static HashSet<Integer> findRangNum(int[] ary){

        HashSet<Integer> s = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        if(ary==null)
            return result;
        for (int value : ary) {
            if (!s.contains(value))
                s.add(value);
            else
                result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {

        System.out.print("请输入数组的值:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] ary = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ary[i] = Integer.parseInt(a[i]);
        }
        sc.close();

        System.out.print("重复元素的序列为:");
        HashSet<Integer> result = findRangNum(ary);

        for (Integer integer : result) {
            System.out.print(integer+" ");
        }

    }

}
