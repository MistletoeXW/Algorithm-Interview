package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T12FindRoadInArray
 * @Description: 矩阵中的路径, 判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 *               路径可以从矩阵中的任意一个格子开始,每一步可以在矩阵中上下左右移动一个格子.
 *               例如:  a  b  t  g
 *                     c  j  c  s
 *                     j  d  e  h
 *               中包含路径:bfce  不包含路径: abfb
 *       解题思路: 回溯法
 *               回溯法是一种暴力搜索方法,通过搜索所有可能的结果来求解问题.
 *               回溯法在一次搜索结束时需要进行回溯将这一次搜索过程中设置的状态进行清除,从而开始一次新的搜索过程
 * @Author:xuwen
 * @Date: 2020/2/4 下午1:29
 **/
public class T12FindRoadInArray {

    //分别表示往上,下,左,右走
    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows;
    private int cols;

    //我们输入的是数组,我们要将数组转化为矩阵
    public char[][] buildMatrix(char[] array){
        char[][] matrix = new char[rows][cols];
        for(int r=0,idx=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                matrix[r][c] = array[idx++];
            }
        }
         return matrix;
    }


    public boolean hasPath(char[][] matrix,int rows,int cols,char[] str){

        if(rows ==0 || cols==0)
            return false;
        this.rows = rows;
        this.cols = cols;
        //标记已经经过的结点
        boolean[][] marked = new boolean[rows][cols];

        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                if(backtracking(matrix, str, marked, 0, i, j))
                    return true;
        return false;
    }

    /*
     * @Author: xw
     * @Description:  例如上图示例中，从 f 开始，下一步有 4 种搜索可能，
     *                如果先搜索 b，需要将 b 标记为已经使用，防止重复使用。
     *                在这一次搜索结束之后，需要将 b 的已经使用状态清除，并搜索 c。//TODO
     * @Date: 下午6:00 2020/2/5
     * @Param: [matrix, str, marked, pathLen, row, col]
     * @Return: boolean
     **/
    public boolean backtracking(char[][] matrix,char[] str,boolean[][] marked,
                                int pathLen,int row,int col){

        if(pathLen == str.length) return true;
        //如果出现rows遍历完,cols遍历完,或者遍历到的元素值不等于当前字符串的位置字符,或者此矩阵处已经遍历过
        if(row<0 || row>=rows || col<0 || col>=cols
            || matrix[row][col] != str[pathLen] || marked[row][col]){
            return false;
        }

        //标记为已经使用，防止重复使用
        marked[row][col] = true;
        //如果矩阵中坐标为(row,col)的格子和路径字符串中下标为pathLength的字符一样时
        //从相邻的上下左右定位pathLength+1字符一样的位置
        for(int[] n: next){
            //往上,下,左,右分别进行回溯
            if(backtracking(matrix,str,marked,pathLen+1,
                            row+n[0],col+n[1])){
                return true;
            }
        }
        //在这一次搜索结束之后，需要将此位置的值已经使用状态清除
        marked[row][col] = false;
        return false;

    }


    public static void main(String[] args){

        System.out.print("请输入矩阵,以字符串的形式输入:");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] arr = s.toCharArray();
        System.out.print("请输入矩阵的行数:");
        int rows = sc.nextInt();
        System.out.print("请输入矩阵的列数:");
        int cols = sc.nextInt();
        System.out.print("请输入要查找的字符串:");
        Scanner sc1 = new Scanner(System.in);
        String strs = sc1.nextLine();
        char[] str = strs.toCharArray();
        sc.close();
        sc1.close();

        T12FindRoadInArray object = new T12FindRoadInArray();
        object.rows=rows;
        object.cols=cols;
        //根据数组建立矩阵
        char[][] matrix = object.buildMatrix(arr);

        System.out.print("输入的矩阵为:\n");
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(matrix[i][j]+"   ");
            }
            System.out.print("\n");
        }




        System.out.print("在矩阵中查询此字符串的结果为: "+ object.hasPath(matrix,rows,cols,str));




    }


}
