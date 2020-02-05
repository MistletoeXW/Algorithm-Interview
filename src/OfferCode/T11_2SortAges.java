package OfferCode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: T11_2SortAges
 * @Description: 要求对公司员工的年龄进行排序.要求时间复杂度为O(n)
 *          分析: 要求时间复杂度为O(n)的排序,一定要询问能否给辅助空间,因为要考虑用数组存放数据出现次数进行先统计再排序
 *               本题中要求的是排序年龄,所以数据的范围不广所以考虑到用辅助数组来实现排序
 * @Author:xuwen
 * @Date: 2020/2/5 下午5:07
 **/
public class T11_2SortAges {

    public void SortAge(int[] arr){
        //定义年龄范围为0~99的数组
        int[] ages = new int[100];
        Arrays.fill(ages,0);//将数组填充0

        for(int i=0;i<arr.length;i++){
            int age = arr[i];
            ages[age]++;//年龄统计数组中对应下标值+1;
        }
        int index = 0;
        for(int i=0;i<=99;i++){
            for(int j=0;j<ages[i];j++){
                arr[index] = i;
                index++;
            }
        }
    }

    public static void main(String[] args){
        System.out.print("请输入年龄数组: ");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] ages = new int[s.length];
        for(int i=0;i<s.length;i++){
            ages[i] = Integer.parseInt(s[i]);
        }
        sc.close();
        T11_2SortAges object = new T11_2SortAges();
        object.SortAge(ages);

        System.out.print("经过排序后年龄数组为: ");
        for(int i=0;i<ages.length;i++)
            System.out.print(ages[i]+" ");

    }

}
