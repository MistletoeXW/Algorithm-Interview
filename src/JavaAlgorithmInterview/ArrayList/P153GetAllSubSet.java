package JavaAlgorithmInterview.ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName:P153GetAllSubSet
 * @Description: 求集合的所有子集
 *           采用迭代法: 每一次迭代,都是上一次迭代的结果
 *                     +上次迭代结果中每个元素都加上当前迭代的元素
 *                     +当前迭代的元素
 *           例如: 原始集合为: {a,b,c}
 *           第一次迭代: {a}
 *           第二次迭代: {a,ab,b}
 *           第三次迭代: {a,ab,b,ac,abc,bc,c}
 *          时间复杂度: O(2^n)
 * @Author:xuwen
 * @Date: 2020/1/29 下午4:05
 **/
public class P153GetAllSubSet {

    /*
     * @Author: xw
     * @Description: 迭代法求集合的所有子集//TODO
     * @Date: 上午9:59 2020/1/30
     * @Param: [str]
     * @Return: java.util.ArrayList<java.lang.String>
     **/
    public static ArrayList<String> getAllSubSet(String str){

        ArrayList<String> arr = new ArrayList<String>();
        arr.add(str.substring(0,1));//将第一个字母加入到数组中
        for(int i=1;i<str.length();i++){

            int len = arr.size();
            for(int j=0;j<len;j++){
                arr.add(arr.get(j)+str.charAt(i));//将当前子集合中的每一个字符串与当前字符进行拼接加入到子集和中
            }
            arr.add(str.substring(i,i+1)); //将当前字符加入到子集和中
        }
        return arr;
    }

    public static void main(String[] args){

        System.out.print("请输入字符串:");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        ArrayList<String> arr = getAllSubSet(str);
        System.out.print("此字符串的所有子集为:");
        for(int i=0;i<arr.size();i++){
            System.out.print("{"+ arr.get(i)+"}" +" ");
        }
    }


}
