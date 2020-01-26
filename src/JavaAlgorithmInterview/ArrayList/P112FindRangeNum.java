package JavaAlgorithmInterview.ArrayList;

import java.util.Hashtable;
import java.util.Scanner;

/**
 * @ClassName:P112FindRangeNum
 * @Description: 查找数组中唯一重复的元素,数字1~1000放在含有1001个元素的数组中,其中只有唯一的一个元素值重复
 *               要求算法只能遍历每个数组元素一次,且不使用辅助空间
 *            方法一: Hash法
 *            方法二: 数据映射法
 *
 * @Author:xuwen
 * @Date: 2020/1/26 下午7:07
 **/
public class P112FindRangeNum {

    //=======================方法一:Hash法===============================
    /*
     * @Author: xw
     * @Description: 使用hash法,将原数组中的元素逐一映射到hash数组中
     *               当对应的Hash数组中的值为0时,则置该处的值为1,当hash数组中该处的值为1时
     *               则表面该位置的数在原数组中是重复的//TODO
     * @Date: 下午7:19 2020/1/26
     * @Param: [ary]
     * @Return: int
     **/
    public static int findRangNum_1(int[] ary){
        if(null == ary)
            return -1;
        int len = ary.length;
        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
        //首先将hash表置0
        for(int i=0;i<len;i++)
            hashtable.put(i,0);
        for(int i=0;i<len;i++){
            //判断所判断值的hash表位置中的值是否0,如果是则将相应位置的值设置为此值,如果不是表示此值重复
            if(hashtable.get(ary[i]-1) == 0){
                hashtable.put(ary[i]-1,ary[i]-1);
            }else
                return ary[i];
        }
        return -1;
    }

    //=======================方法二:数据映射法===============================

    /*
     * @Author: xw
     * @Description: 将数组中的值作为数组下标进行遍历,同时将对应下标的值改为相反数,
     *               如果当再次遍历到一个下标位置的值为负数时,则表示为重复数字//TODO
     * @Date: 下午7:46 2020/1/26
     * @Param: [ary]
     * @Return: int
     **/
    public static int findRangeNum_2(int[] ary){
        if(ary == null)
            return -1;
        int len = ary.length;
        int index = 0;
        int i=0;
        while(true){
            //数组中的元素值只能小于len,否则会越界
            if(ary[i]>=len)
                return -1;
            if(ary[index]<0)
                break;
            //访问过,通过变相反数的方法进行标记
            ary[index] *= -1;
            //index的后继为ary[index]
            index = -1*ary[index];
        }

        return index;

    }


    public static void main(String[] args){

        System.out.print("请输入数组的值:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] ary = new int[a.length];
        for(int i=0;i<a.length;i++){
            ary[i] = Integer.parseInt(a[i]);
        }
        sc.close();

        //=======================方法一:Hash法===============================
        //int num = findRangNum_1(ary);

        //=======================方法二:数据映射法===============================
        int num = findRangeNum_2(ary);

        System.out.print("重复的数字为:" + num);


    }

}
