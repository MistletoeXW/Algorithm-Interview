package HUAWEI;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @ClassName: T8BookInformation
 * @Description: 给定多组原本的航班预订信息（航班号，座位号，乘客姓名），
 *               以及多组要改签的航班信息（原本航班号，原本座位号，新航班号，新座位号）
 *         输入内容如下:  3
 *                      CZ7132,A1,ZHANGSAN
 *                      CZ7132,A2,ZHAOSI
 *                      CZ7156,A2,WANGWU
 *                      2
 *                      CZ7132,A1,CZ7156,A2
 *                      CZ7156,A2,CZ7156,A3
 *         输出内容如下:   CZ7132,A2,ZHAOSI
 *                       CZ7156,A2,ZHANGSA
 *                       CZ7156,A3,WANGW
 * @Author:xuwen
 * @Date: 2020/2/12 下午3:03
 **/
public class T8BookInformation {

    public static void main(String[] args){
        ArrayList<String[]> BookInformation = new ArrayList<>();
        ArrayList<String[]> OptInformation = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int num = sc.nextInt();
        for(int i=0;i<num;i++){
            String[] strList = sc1.nextLine().trim().split(",");
            BookInformation.add(strList);
        }
        int pot = sc.nextInt();
        for(int i=0;i<pot;i++){
            String[] strList = sc1.nextLine().trim().split(",");
            OptInformation.add(strList);
        }

        for(String[] book : BookInformation){

            for(String[] opt : OptInformation){
                if(book[0].equals(opt[0]) && book[1].equals(opt[1]) ){
                    book[0] = opt[2];
                    book[1] = opt[3];
                }
            }
        }

        System.out.println("修改后的航班信息为: ");
        for(String[] book : BookInformation){
            System.out.println(book[0]+","+book[1]+","+book[2]);
        }


    }


}
