package HUAWEI.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @ClassName: T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/2/19 下午4:17
 **/
public class T1 {

    public static int[] number = {2,4,8,16,32,64,128,256,512,1024};

    public static int geti(int num){
        int i;
        for(i=0;i<number.length;i++){
            if(number[i] == num)
                break;
        }
        return i;
    }

    public static int getNum(int[] num){

        int count = 0;
        int j;
        int sum = 0;
        while(num[num.length-1] != 2){
            for (j = num.length - 1; j >= 0; j--) {
                if (num[j] >= 2)
                    break;
            }
            sum = 2 * (int) Math.pow(2, j + 1);
            count++;
            num[geti(sum)] += 1;
            num[j] -= 2;
        }
        return count+1;
    }

    public static void main(String[] args){
        List<int[]> numList = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int[] num = new int[10];
            for(int j = 0; j < 10; j++){
                num[j] = sc.nextInt();
            }
            numList.add(num);
        }

        for(int[] list: numList){
            if(list==null)
                return;
            int count = getNum(list);
            System.out.print(count);
            System.out.println();
        }
    }

}
