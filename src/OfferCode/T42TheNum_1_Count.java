package OfferCode;

/**
 * @ClassName: T42TheNum_1_Count
 * @Description: 从1到n整数中1出现的次数: 时间复杂度为O(logn)的算法
 *        题目描述:  输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数
 *                  例如输入12，从1到12这些整数中包含1的数字有1，10，11和12，1一共出现了5次
 *        方法一: 暴力解法,时间复杂度为O(n*logn)
 *               直接循环遍历求出n个数中每一个数包含1的次数,然后累加起来
 *
 *        方法二: 寻找规律法,时间复杂度为O(log10 n),就是数字的位数
 *               考虑将n的十进制的每一位单独拿出来讨论,每一位的值记为weight
 *               例子: n=534
 *             1.个位: 从1到n，每增加1，weight就会加1，当weight加到9时，再加1又会回到0重新开始,
 *                    那么weight从0-9的这种周期会出现多少次呢？这取决于n的高位是多少
 *                    以534为例，在从1增长到n的过程中，534的个位从0-9变化了53次，记为round。
 *                    每一轮变化中，1在个位出现一次，所以一共出现了53次
 *                    再来看weight的值,为4,大于0,说明第54轮变化是从0-4,里面包含一次出现1,所以总共出现1的次数为:
 *                    count= round + 1=53+1=54
 *             2.十位: 不同点在于,从1到n，每增加10，十位的weight才会增加1，所以，一轮0-9周期内，1会出现10次。
 *                     即rount*10
 *                     再来看weight的值,为3,说明第6轮出现了10次1,则count=roun*10+10 = 60
 *                     如果此时weight的值等于0,则说明第6轮到0就停止了
 *                     如果此时weight的值为1,那么di6轮中1出现多少次呢?很明显与个位数的值有关
 *                     个位数的值为k,第六轮就出现k+1次1
 *             3.更高位: 类似
 *
 *             总结:
 *             1. 对于个位来说,若个位大于0,则1出现的次数为round*1+1,否则为round*1
 *             2. 对于其他位来说, 记每一位的权值为base,位值为weight,该位之前的数是former
 *             举例如下:      round  weight  former    base=10
 *                      n =  5       3       4
 *              则: 若weight=0, 则1出现的次数为round*base
 *                  若weight=1, 则1出现的次数为round*base+former+1
 *                  若weight>1,则出现1的次数为round*base+base
 *              例如: 534 = (个位1出现的次数) + (十位1出现的次数) + (百位1出现的次数)
 *                       = (round*1+1)  +  (round*base+base) + (round*base+base)
 *                       = (53*1+1) + (5*10+10) + (0*100+100)
 *
 * @Author:xuwen
 * @Date: 2020/2/17 下午4:52
 **/
public class T42TheNum_1_Count {

    //===================方法一: 暴力法=========================
    public static int TheNum_1_Count_1(int n){
        int num = 0;
        for(int i=1;i<=n;i++){
            num = num + numberof1(n);
        }
        return num;
    }
    //每次对10求余数进行判断个位数字是否是1,如果这个数字大于10,则先除以10.
    public static int numberof1(int n){
        int num = 0;
        while (n>0){
            if(n%10 == 1){
                num++;
            }
            n=n/10;
        }
        return num;
    }

    //==========================方法二: 运用规律=======================
    public int TheNum_1_Count_2(int n){
        if(n<1)
            return 0;
        int count=0;
        int base=1; //表示权重,个位权重为1,十位为10...
        int round=n; //表示当前位前的数字
        while (round > 0){
            //表示十进制的每一位
            int weight = round%10;
            //表示每一次weight位上的数要从0-9变换多少个轮回
            round = round/10;
            //当weight位上为0的时候
            count += round*base;
            if(weight==1)
                count = count +  (n%base) +1;
            else if(weight > 1){
                count = count + base;
            }
            //下一位的权重为前一位权重的10倍
            base*=10;
        }
        return count;

    }


}
