package JavaAlgorithmInterview.ArrayList;

/**
 * @ClassName: P159FindSpecialListNum
 * @Description: 在有特点的二维数组中查找元素(行数:rows, 列数: cols)
 *           二维数组构造:  1  2  8  9
 *                        2  4  9  12
 *                        4  7  10 13
 *                        6  8  11 15
 *          从该二维数组中可看出,每一列和每一行都在递增
 *          查找元素7的方法为: 从右上角的元素开始(i=0.j=cols-1)
 *                        1. 如果arr[i][j]的值等于data,则找到了data返回true
 *                        2. 如果arr[i][j] > data,则说明这一列其他元素都比data大,所以令j--
 *                        3. 如果arr[i][j] < data,则说明这一行其他元素都比data小,所以令i++
 * @Author:xuwen
 * @Date: 2020/1/30 下午12:41
 **/
public class P159FindSpecialListNum {

    public static boolean findSpecialListNum(int[][] arr,int data){

        //从二维数组的右上角元素开始遍历
        int i=0;
        int rows = arr.length;
        int cols = arr[0].length;
        int j=cols-1;
        while(i<rows && j>=0){

            if(arr[i][j] == data)
                return true;
            else if(arr[i][j] > data){
                j--;
            }else {
                i++;
            }
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
