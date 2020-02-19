package JavaAlgorithmInterview.LinkList;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @ClassName: P49IsIntersect
 * @Description: 判断两个单链表是否相交，方法一：hash法 方法二：长的链表先走n1-n2步
 * @Author:xuwen
 * @Date: 2020/1/11 下午6:51
 **/
public class P49IsIntersect {

    /*
     * @Author: xw
     * @Description: 方法一：hash法判断是否相交，先把一个链表加入到hashset中，在对另一个进行遍历//TODO
     * @Date: 下午6:53 2020/1/11
     * @Param: [head1, head2]
     * @Return: int
     **/
    public static int IsIntersect_1(LNode head1,LNode head2){
        HashSet result = new HashSet<Integer>();
        LNode pa = head1.next;
        while (pa != null){
            result.add(pa.data);
            pa = pa.next;
        }
        LNode pb = head2.next;
        while(pb != null){
            if(result.contains(pb.data)){
                return pb.data;
            }else {
                pb = pb.next;
            }
        }
        return 0;
    }

    /*
     * @Author: xw
     * @Description: 方法二：长的链表先走head1.length - head2.length步，然后一起同步遍历//TODO
     * @Date: 下午7:06 2020/1/11
     * @Param: [head1, head2]
     * @Return: int
     **/
    public static int IsIntersect_2(LNode head1,LNode head2){
        int len1 = head1.getLength(head1);
        int len2 = head2.getLength(head2);
        LNode pa = head1.next;
        LNode pb = head2.next;
        if(len1 > len2){
            for(int i = 0;i<(len1-len2);i++){
                pa = pa.next;
            }
        }
        if(len1 < len2){
            for(int i = 0;i<(len2 - len1);i++){
                pb = pb.next;
            }
        }
        while(pa != null && pb != null){
            if(pa.data == pb.data){
                return pa.data;
            }else {
                pa = pa.next;
                pb = pb.next;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        //控制台输入两数组
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入链表A：");
        String[] a = sc.nextLine().trim().split(" ");
        System.out.print("请输入链表B：");
        String[] b = sc.nextLine().trim().split(" ");
        sc.close(); //结束控制台输入
        LNode A = new LNode();
        A.next = null;
        LNode ra = A;
        for(int i=0;i < a.length;i++){
            LNode p = new LNode();
            p.next = null;
            p.data = Integer.parseInt(a[i]);
            ra.next = p;
            ra = p;
        }
        LNode B = new LNode();
        B.next = null;
        LNode rb = B;
        for(int i=0;i < b.length;i++){
            LNode p = new LNode();
            p.next = null;
            p.data = Integer.parseInt(b[i]);
            rb.next = p;
            rb = p;
        }

        int num = IsIntersect_2(A,B);
        if(num == 0){
            System.out.print("两链表不存在交叉");
        }else{
            System.out.print("两链表相交点为："+num);
        }

    }











}
