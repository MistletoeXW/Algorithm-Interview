package HUAWEI;

import java.util.Scanner;

/**
 * @ClassName: T6Equation
 * @Description: 输入一个正整数X，在下面的等式左边的数字之间添加+号或者-号，使得等式成立。
 *               1 2 3 4 5 6 7 8 9 = X
 *         例如: 12-34+5-67+89 = 5
 *              1+23+4-5+6-7-8-9 = 5
 *         思路: 数与数之间总共有三种情况: + , - 和 空( 空的情况代表几个数凑成数)
 *              所以我们可以将数字的符号用一个三进制来表示,用0代表+,1代表-,2代表空.
 *              21201202表示12-34+5-67+89
 *              这样从0代表22222222就可以代表所有可能的结果,转换成十进制就是从0到6560,总共6561种情况
 * @Author:xuwen
 * @Date: 2020/2/11 下午8:22
 **/
public class T6Equation {
    static int count = 0;

    //使用递归求出3^8种情况
    public static void getResult(int index,int[] result,int num){

        if(index == 8){
            showResult(result,num);//根据数组取值转换成表达式,且求值
            return;
        }
        //每个空三种可能,0,1,2
        //这里index总共有8位每一位有3种情况
        for(int i=0;i<3;i++){
            result[index] = i;
            getResult(index+1,result,num);
            result[index] = 0;//恢复原来的状态
        }
    }

    public static void showResult(int[] result,int num){
        int sum=0;
        //默认在第一个数字,即1之前是+号,方便编程而已
        char opera = '+';
        String[] source = new String[]{"1","2","3","4","5","6","7","8","9"};
        //最终表达式,最好用StringBuilder,在非多线程的情况下,字符串拼接的性能,StringBuilder最好
        StringBuilder expression = new StringBuilder();
        //用于记录临时的数字,因为参与运算的数字可能是几位数字,所以也需要拼凑
        StringBuilder number = new StringBuilder();
        //先加入第一个字符,即1
        number.append(source[0]);
        expression.append(source[0]);

        //遍历三进制符号串
        for(int i=0;i<result.length;i++){
            if(result[i]==0){ //如果为0,表示数字合并
                number.append(source[i+1]);
                expression.append(source[i+1]);
            }else if(result[i]==1){
                sum=calc(opera,sum,number);
                opera='+';
                number.append(source[i+1]);
                expression.append("+").append(source[i+1]);
            }else if(result[i] == 2){
                sum = calc(opera,sum,number);
                opera = '-';
                number.append(source[i+1]);
                expression.append("-").append(source[i+1]);
            }

        }
        sum = calc(opera,sum,number);
        if(sum == num){
            count++;
            System.out.print(expression.toString()+" = "+num);
            System.out.println();
        }

    }

    public static int calc(char opera,int sum,StringBuilder num){
        if(opera == '+'){
            sum = sum + Integer.parseInt(num.toString());
            num.delete(0,num.length());
        }else if(opera == '-'){
            sum = sum - Integer.parseInt(num.toString());
            num.delete(0,num.length());
        }
        return sum;

    }

    public static void main(String[] args){
        System.out.print("请输入结果值: ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();

        System.out.println("满足条件的表达式为: ");
        int[] result = new int[8];
        getResult(0,result,num);
        System.out.println("满足的表达式个数为: "+count);

    }


}
