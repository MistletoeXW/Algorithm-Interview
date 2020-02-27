package OfferCode;

/**
 * @ClassName: T15_1Count1InNum
 * @Description: 统计一个数的二进制中1的个数
 *          思路: 将这个数-1,然后再根原来的数进行与操作,如果不为0则继续操作,为0则退出;
 * @Author:xuwen
 * @Date: 2020/2/27 上午10:39
 **/
public class T15_1Count1InNum {

    public int NumberOf1(int n){

        int count =0;
        while(n!=0){
            int sub = n-1;
            count++;
            n=n&sub;
        }
        return count;

    }

}
