package JavaAlgorithmInterview.ArrayList;

import java.util.Scanner;

/**
 * @ClassName: P133FindDisInList
 * @Description: 求数组中两个元素的最小距离
 *               给定一个数组,数组中含有重复元素,给定两个数字num1和num2,
 *               求这两个数字在数组中出现的位置的最小距离
 *           方法一: 蛮干法,对数组进行双重遍历,外层循环遍历到num1,内层循环对数组从头开始遍历找num2,时间复杂度O(n^2)
 *           方法二: 动态规划
 *           具体实现思路: 遍历数组过程中会遇到以下两种问题
 *              1. 当遇到num1时,记录下num1的值对应的数组下标的位置lastPos1,通过求lastPos1与上次遍历到num2下标的位置的值
 *                 lastPos2的差可以求得最近一次遍历到的num1和num2的距离
 *              2. 当遇到num2时,同样记录下它在数组中下标的位置lastPos2,然后通过求lastPos2与上次遍历到的num1下标的位置值
 *                 lastPos1的差可以求得最近一次遍历到的num1与num2的距离
 *           例子: 数组{4 5 6 4 7 4 6 7 8 5 6 4},num1=4,num2=8
 *              1. 首先遍历到4,此时下标lastPos1=0,由于此时还没有遍历到num2,因此没必要计算num1与num2的值
 *              2. 再次遍历到4,此时更新lastPos1=3
 *              3. 再次遍历到4,此时更新lastPos1=5
 *              4. 再次遍历到4,此时更新lastPos1=7
 *              5. 遍历到8,更新lastPOs2=9; 此时由于前面已经遍历到过num1,因此可以求出当前num1与num2的最小距离为|lastPos1-lastPos2|
 *              6. 接着往下遍历,重复以上过程
 *           时间复杂度: O(n)
 * @Author:xuwen
 * @Date: 2020/1/27 下午5:45
 **/
public class P133FindDisInList {


    //===============================方法一:蛮力法============================
    /*
     * @Author: xw
     * @Description: 给定一个数组,找出数组中任意两个数字之间的最短距离//TODO
     * @Date: 下午1:01 2020/1/28
     * @Param: [arr, num1, num2]
     * @Return: int
     **/
    public static int findDisInList_1(int[] arr,int num1,int num2){

        int minDis = Integer.MAX_VALUE; //首先定义num1与num2的最小距离为最大值
        int dist = 0;
        for(int i=0;i<arr.length;i++){

            if(arr[i] == num1){
                for(int j=0;j < arr.length;j++){
                    if(arr[j] == num2){

                        dist = Math.abs(i-j); //当前遍历的num1与num2的距离
                        if(dist<minDis)
                            minDis = dist;
                    }

                }


            }
        }
        return minDis;
    }

    //===============================方法二:动态规划============================
    /*
     * @Author: xw
     * @Description: 动态规划的方法求解两数之间的最短距离//TODO
     * @Date: 下午2:31 2020/1/28
     * @Param: [arr, num1, num2]
     * @Return: int
     **/
    public static int findDisInList_2(int[] arr,int num1,int num2){

        int lastPos1 = -1;//上次遍历到num1的位置
        int lastPos2 = -1;//上次遍历到num2的位置
        int mimDist = Integer.MAX_VALUE;//num1与num2之间的最小距离
        for(int i=0;i<arr.length;i++){

            if(arr[i] == num1){
                lastPos1 = i;
                if(lastPos2 >= 0)
                    mimDist = Math.min(mimDist,lastPos1-lastPos2);
            }
            if(arr[i] == num2){
                lastPos2=i;
                if(lastPos1>=0){
                    mimDist = Math.min(mimDist,lastPos2-lastPos1);
                }
            }
        }
        return mimDist;
    }



    public static void main(String[] args){

        System.out.print("请输入数组:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] arr = new int[a.length];
        for(int i=0;i<a.length;i++){
            arr[i] = Integer.parseInt(a[i]);
        }
        System.out.print("请输入要查询的第一个数:");
        int num1 = sc.nextInt();
        System.out.print("请输入要查询的第二个数:");
        int num2 = sc.nextInt();
        sc.close();
        //===============================方法一:蛮力法============================
        int dist = findDisInList_2(arr,num1,num2);
        System.out.print("两个数在数组中的最短距离为:" + dist);

    }

}
