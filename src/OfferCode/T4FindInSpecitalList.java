package OfferCode;

/**
 * @ClassName: T4FindInSpecitalList
 * @Description: 给定一个二维数组,其每一行从左向右递增有序,从上到下也是递增有序,给定一个数,判断是否在此二维数组中
 *               要求时间复杂度为O(M+N),空间复杂度为O(1).其中M为行数,N为列数
 *              二维数组构造:  1  2  8  9
 *  *                        2  4  9  12
 *  *                        4  7  10 13
 *  *                        6  8  11 15
 *  *          从该二维数组中可看出,每一列和每一行都在递增
 *  *          查找元素7的方法为: 从右上角的元素开始(i=0.j=cols-1)
 *  *                        1. 如果arr[i][j]的值等于data,则找到了data返回true
 *  *                        2. 如果arr[i][j] > data,则说明这一列其他元素都比data大,所以令j--
 *  *                        3. 如果arr[i][j] < data,则说明这一行其他元素都比data小,所以令i++
 * @Author:xuwen
 * @Date: 2020/2/2 上午11:21
 **/
public class T4FindInSpecitalList {

    public static boolean findSpecialListNum(int[][] arr,int data){

        int rows = arr.length;//二维数组行数
        int cols = arr[0].length;//二维数组列数
        int i=0,j=cols-1; //从二维数组的右上角开始
        while(i <= rows-1 && j >= 0){

            if(arr[i][j] == data)
                return true;
            else if(arr[i][j] < data)
                i++;
            else
                j--;
        }

        return false;

    }

    public static void main(String[] args){

        int arr[][] = {
                {0,1,2,3,4},
                {10,11,12,13,14},
                {20,21,22,23,24},
                {30,31,32,33,34}
        };
        System.out.print("查找元素17的返回值为:" + findSpecialListNum(arr,17)+"\n");
        System.out.print("查找元素21的返回值为:" + findSpecialListNum(arr,21));

    }



}
