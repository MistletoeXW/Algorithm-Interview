package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T29PrintMatrixList
 * @Description: 输入一个矩阵,按照从外到里以顺时针的顺序依次打印出每一个数字
 *          分析: 此题没有涉及很复杂的算法或者数据结构,但是此题注意是考察我们能不能把循环边界条件搞清楚
 *          思路: 在分析的时候可以用画图来分析,我们可以把矩阵想象成若干个圈,每一次顺时针打印一圈的内容
 *               1. 打印第一圈的左上角的坐标为(0,0),第二圈的左上角为(1,1),以此类推
 *                  所以我们可以选取左上角(start,start)开始的一圈作为分析
 *                  对于5x5的矩阵而言,最后一圈只有一个数字,对应的坐标为(2,2),我们发现5>2x2
 *                  对于6x6的矩阵而言,最后一圈有四个数字,其左上角的坐标为(2,2),我们发现6>2x2
 *                  所以让圈循环下去的条件为: cols>startX*2 && rows>startY*2
 *               2. 接下来考虑如何打印一圈的功能
 *                  我们可以把打印过程分为四步: 从左到右打印,从上到下打印,从右到左打印,最后从下到上打印
 *                  但是要考虑特殊情况,如果最后一圈退化为只有一行,一列或者只有一个元素的情况,因此这些特殊情况就不需要四步
 *                  我们先来看每一步进行条件,在进行每一步前需要进行判断是否具备进行这一步的条件
 *                  第一步(从左到右打印一行): 第一步总是需要的,因为打印一圈至少一步
 *                  第二步(从上到下打印一列): 前提条件为终止行号必须大于起始行号
 *                  第三步(从右到左打印一行): 前提条件是圈内至少有两行两列,即要求终止行号大于起始行号,终止列号大于起始列号
 *                  第四步(从下到上打印一列): 前提条件是圈内至少有三行两2列,因此要求终止行号比起始行号至少大2,终止列号大于起始列号
 * @Author:xuwen
 * @Date: 2020/2/9 下午2:22
 **/
public class T29PrintMatrixList {

    //从外向内对圈进行循环
    public void PrintMatrixList(int[][] arr,int cols,int rows){

        if(arr == null || cols<=0 || rows<=0)
            return;
        int start=0;
        while(cols > start*2 && rows>start*2){
            PrintNumber(arr,cols,rows,start);
            start++;
        }

    }

    //对圈进行打印
    public void PrintNumber(int[][] arr,int cols,int rows,int start){

        //找到行和列终止位置
        int endX = cols-1-start;
        int endY = rows-1-start;

        //第一步: 从左到右打印一行
        for(int i=start;i<=endX;i++){
            System.out.print(arr[start][i] + " ");
        }

        //第二步: 从上到下打印一列
        if(start < endY){
            for(int i=start+1;i<=endY;i++){
                System.out.print(arr[i][endX]+ " ");
            }

        }

        //第三步: 从右到左打印一行
        if(start < endX && start <endY){
            for(int i=endY-1;i>=start;i--){
                System.out.print(arr[endY][i]+ " ");
            }
        }

        //第四步: 从下到上打印一列
        if(start<endX && start<endY-1){

            for(int i=endY-1;i>=start+1;i--){
                System.out.print(arr[i][start]+ " ");
            }

        }
    }

    public static void main(String[] args){

        System.out.print("请输入矩阵数组: ");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] arr = new int[s.length];
        for(int i=0;i<s.length;i++)
            arr[i] = Integer.parseInt(s[i]);
        System.out.print("请输入矩阵的行数: ");
        int rows = sc.nextInt();
        System.out.print("请输入矩阵的列数: ");
        int cols = sc.nextInt();
        sc.close();

        int[][] number = new int[rows][cols];
        int index =0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                number[i][j] = arr[index++];
            }
        }

        System.out.print("生成的矩阵为:\n");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(number[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.print("顺时针打印数据为: ");
        T29PrintMatrixList object = new T29PrintMatrixList();
        object.PrintMatrixList(number,cols,rows);

    }



}
