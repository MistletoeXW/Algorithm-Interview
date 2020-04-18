package ACMSpring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @ClassName:B
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/18 下午1:46
 **/
public class B {

    static class user{
        int date;
        int id;
        float c;
    }

    public static int compare(user arr1,user arr2){

        if(arr1.date > arr2.date){
            return 1;
        }else if(arr1.date < arr2.date){
            return -1;
        }else {
            if(arr1.c > arr2.c){
                return 1;
            }else if(arr1.c < arr2.c){
                return -1;
            }else {
                if(arr1.id > arr2.id){
                    return -1;
                }
                if(arr1.id < arr2.id){
                    return 1;
                }
            }
        }
        return 1;
    }

    public static void sort(ArrayList<user> arrayList){
        if(arrayList == null){
            return;
        }
        for(int i=0;i<arrayList.size();i++){
            boolean flag = false;
            for(int j=arrayList.size()-1;j>i;j--){
                if(compare(arrayList.get(j),arrayList.get(j-1)) == 1){
                    Collections.swap(arrayList,j,j-1);
                    flag = true;
                }
            }
            if(!flag){
                return;
            }
        }

    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<user> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++){
            user u = new user();
            u.date = sc.nextInt();
            u.id = sc.nextInt();
            u.c = sc.nextFloat();
            if(u.c >= 38.0){
                arrayList.add(u);
            }
        }

        sort(arrayList);
        System.out.println(arrayList.size());
        for(user u : arrayList){
            System.out.println(u.date +" "+u.id+" "+u.c);
        }
    }

}
