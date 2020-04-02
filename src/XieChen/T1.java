package XieChen;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName:T1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/1 下午5:36
 **/
public class T1 {

    /*请完成下面这个函数，实现题目要求的功能
当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
******************************开始写代码******************************/
    static long countDolphin(int n, int m, int[] birthYear, int x) {
        ArrayList<Integer> result = new ArrayList<>();

        for(int i=0;i<n;i++){
            result.add(0);
        }
        for(int i=0;i<=x;i++){
            int size = result.size();
            for(int j=0;j<size;j++){
                int age = result.get(j);
                if(result.get(j) < m){
                    for(int k=0;k<birthYear.length;k++){
                        if(result.get(j) == birthYear[k])
                            result.add(0);
                    }
                    result.set(j,age+1);
                }
            }
        }
        return result.size();

    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        long res;

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _birthYear_size = 0;
        _birthYear_size = Integer.parseInt(in.nextLine().trim());
        int[] _birthYear = new int[_birthYear_size];
        int _birthYear_item;
        for(int _birthYear_i = 0; _birthYear_i < _birthYear_size; _birthYear_i++) {
            _birthYear_item = Integer.parseInt(in.nextLine().trim());
            if(_birthYear_item < 1 || _birthYear_item > _m)
                return;
            _birthYear[_birthYear_i] = _birthYear_item;
        }

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = countDolphin(_n, _m, _birthYear, _x);
        System.out.println(String.valueOf(res));

    }
    
}
