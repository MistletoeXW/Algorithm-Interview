package QIAnXin;

/**
 * @ClassName:LucklyTail
 * @Description:
 * @Author:xuwen
 * @Date: 2020/1/6 下午6:38
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 *
N个人排成一队，从1到5轮流报数，报5的人是幸运者，出列。报到队尾后，从队首接着报。依此循环。
问：排在队尾的人是第几名幸运者？
注：N为小于100000的正整数。
例如：
1人排成一队，他就是第1名幸运者。
3人排成一队，队尾是第2名幸运者。
5人排成一队，队尾是第1名幸运者。
8人排成一队，队尾是第3名幸运者。
即求：N人排成一队，队尾是第多少名幸运者？
*/
public class LucklyTail {
    public static int getluckinedx(List<Integer> list,int n) {
        List<Integer> listluck=new ArrayList<Integer>();
        int i=0;
        while(true) {
            if(i+4<list.size()) {
                i=i+4;
                listluck.add(list.get(i));
                if(list.get(i)==n) {
                    break;
                }
                list.remove(i);
            }else {
                if(list.size()<=2) {
                    i=5-(list.size()-i)-3;
                }else {
                    i=5-(list.size()-i)-1;
                }
                listluck.add(list.get(i));
                if(list.get(i)==n) {
                    break;
                }
                list.remove(i);
            }
            if(list.size()==1) {
                listluck.add(list.get(0));
                break;
            }
        }
        return listluck.size();
    }

    //方法二
    public static int getluckinedx2(List<Integer> list, int n){
        int i=0;
        while(list.size()!=0) {
            i=(i+4)%list.size();
            int j=list.remove(i);
            if(j==n) {

                return n-list.size();
            }
        }

        return n;
    }

    public static void main(String[] args) {
        List<Integer> list=new ArrayList<Integer>();
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        for(int i=1;i<=n;i++) {
            list.add(i);
        }
        int index=getluckinedx(list,n);
        System.out.println(index);
    }
}
