package Baidu;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * @ClassName: T2
 * @Description:
 * @Author:xuwen
 * @Date: 2020/3/14 下午7:50
 **/
public class T2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<0 || n>20)
            return;
        int money = sc.nextInt();
        if(money < 1 || money > Math.pow(10,9))
            return;
        ArrayList<ArrayList<Integer>> changeList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if(num1 <1 || num1 > Math.pow(10,9))
                return;
            if(num2 <1 || num2 > Math.pow(10,6))
                return;
            list.add(num1);
            list.add(num2);
            changeList.add(list);
        }

        int low=0;
        int high=changeList.size()-1;
        int len = changeList.size();
        int count=0;
        while(low < high){
            while(low < high && low <len && high < len && (changeList.get(low).get(0) >= money)){
                int num = changeList.get(low).get(1);
                count += num;
                changeList.get(low).set(1,changeList.get(low).get(1)-num);
                low++;
            }
            while (low < high && low <len && high < len && (changeList.get(low).get(0)+changeList.get(high).get(0)) >= money){
                if(changeList.get(low).get(1) < changeList.get(high).get(1)){
                    int num = changeList.get(low).get(1);
                    count += num;
                    changeList.get(low).set(1,changeList.get(low).get(1)-num);
                    changeList.get(high).set(1,changeList.get(high).get(1)-num);
                    low++;
                }else if(changeList.get(low).get(1) > changeList.get(high).get(1)){
                    int num = changeList.get(high).get(1);
                    count += num;
                    changeList.get(low).set(1,changeList.get(low).get(1)-num);
                    changeList.get(high).set(1,changeList.get(high).get(1)-num);
                    high--;
                }else {
                    int num = changeList.get(low).get(1);
                    count += num;
                    changeList.get(low).set(1,changeList.get(low).get(1)-num);
                    changeList.get(high).set(1,changeList.get(high).get(1)-num);
                    low++;
                    high--;
                }
            }
        }
        int sum = changeList.get(low).get(0) * changeList.get(low).get(1);
        if( sum > money){
            int num = sum / money;
            count += num;
        }

        int min = 0;
        if(count ==0){
            for(int i=0;i<changeList.size()-1;i++){
                if(min > changeList.get(i).get(1))
                    min = changeList.get(i).get(1);
            }
            count = min;
        }

        System.out.print(count);

    }


}
