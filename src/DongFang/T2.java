package DongFang;

import java.util.Scanner;

/**
 * @ClassName:T2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/12 下午9:31
 **/
public class T2 {

    public static int maxProfit(int[] prices,int start,int end) {
        if(start>=end)
            return 0;
        int maxProfit = 0, minPrice = prices[start];
        for(int i=start;i<=end;i++)
        {
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            if(prices[i]-minPrice>maxProfit)
            {
                maxProfit = prices[i]-minPrice;
            }
        }
        return maxProfit;
    }

    public static int max2Profit(int[] prices)
    {
        int n = prices.length;
        int max_ = 0;
        for(int i=1;i<n-1;i++)
        {
            max_ = Math.max(maxProfit(prices,0,i)+maxProfit(prices,i+1,n-1),max_);
        }
        return max_;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
        }
        System.out.print(max2Profit(arr));
    }
}
