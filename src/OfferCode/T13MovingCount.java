package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T13MovingCount
 * @Description: 机器人的运动范围
 *               地上有一个m行和n列的方格,一个机器人从坐标(0,0)的格子开始移动,每一次只能向上下左右移动一格
 *               但是不能进入行坐标和列坐标数位之和大于k的格子
 *               例如: 当k=18时, 机器人能够进入方格(35,37),因为3+5+3+7=18<=k
 *                    机器人不能进入(35,38)因为,3+5+3+6=19>k
 *               请问该机器人能到达多少个格子?
 *
 *
 * @Author:xuwen
 * @Date: 2020/2/4 下午3:38
 **/
public class T13MovingCount {

    //定义往上下左右的位置
    private static final int[][] next ={{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt=0; //记录总共能到达几个格子
    private int rows;
    private int cols;
    private int threshold; //记录k值

    //计算一个数的数位之和
    private int getDigitSum(int number){
        int sum =0;
        while(number>0){
            sum += number%10;
            number /= 10;
        }
        return sum;
    }

    //进行回溯
    private void dfs(boolean[][] marked,int r,int c){
        if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
            return;

        marked[r][c] = true;
        int sum = getDigitSum(rows)+getDigitSum(cols);
        if(sum > this.threshold)
            return;
        cnt++;
        for(int[] n:next)
            dfs(marked,r+n[0],c+n[1]);
    }


    public int movingCount(int threshold,int rows,int cols){

        this.rows = rows;
        this.cols = cols;
        this.threshold = threshold;

        boolean[][] marked = new boolean[rows][cols];
        dfs(marked,0,0);
        return cnt;
    }

    public static void main(String[] args){

        System.out.print("请输入k值:");
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        System.out.print("请输入方格的行数: ");
        int rows = sc.nextInt();
        System.out.print("请输入方格的列数: ");
        int cols = sc.nextInt();
        sc.close();
        T13MovingCount object = new T13MovingCount();
        object.rows = rows;
        object.cols = cols;
        object.threshold = k;
        System.out.print("机器人能走的方格格数为: " + object.movingCount(k,rows,cols));
    }


}
