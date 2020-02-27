package JavaBase;

import java.util.ArrayList;

/**
 * @ClassName: T1BigNumSumAndSubAndMux
 * @Description: 实现两个大数的相加,相减,相乘
 * @Author:xuwen
 * @Date: 2020/2/25 上午9:06
 **/
public class T1BigNumSumAndSubAndMux {


    //=======================实现两个大数的相加================
    public static int[] SumBigNum(char[] arr1, char[] arr2){
        int len1 = arr1.length-1;
        int len2 = arr2.length-1;
        int k = Math.max(len1,len2);
        int[] result = new int[k+1]; //结果数组
        int c = 0; //表示进位
        while (len1 >=0 || len2>=0){

            int tmp1 = len1>=0 ? (arr1[len1]-'0') : 0;
            int tmp2 = len2>=0 ? (arr2[len2]-'0') : 0;
            int tmp = tmp1+tmp2+c; //两个数字相加再加进位
            result[k] = tmp%10;
            c = tmp/10;
            k--;
            len1--;
            len2--;
        }
        return result;
    }

    //===========================实现两个大数的相减=================
    //在进行减法之前,得判断值的大小,小数减大数要加负号,所以此题中,应该首先对相减的两个数进行大小的判断,计算相减的时候用大数减去小数
    //对于减法,从个位开始相减,相减时先加上一个10,结果摸10就是这一位的结果.
    //判断是否要从高位借位,相减加10的结果除以10大于1的话就可以判断不需要高位借位了
    public static int[] SubBigNum(char[] arr1, char[] arr2){ //这里用arr1减arr2, 再此之前要进行判断两个数的大小
        int len1 = arr1.length-1;
        int len2 = arr2.length-1;
        int k = Math.max(len1,len2);
        int[] result = new int[k+1]; //结果数组
        int bower=0;
        while (len1 >=0 || len2>=0){

            int div=10; //arr1当前位先加10再减去arr2当前位
            div += len1 >=0 ? arr1[len1]-'0' : 0;
            div -= len2 >=0 ? arr2[len2]-'0' : 0;
            div -= bower;//减去借位
            result[k--] = div%10;
            bower = div/10==0? 1:0; //将当前结果除以10,如果小于等于0表示已经借过位了
            len1--;
            len2--;
        }
        return result;
    }


}
