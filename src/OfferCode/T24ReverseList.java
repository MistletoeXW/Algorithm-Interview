package OfferCode;

import jdk.internal.org.objectweb.asm.util.CheckAnnotationAdapter;

import java.util.Scanner;

/**
 * @ClassName: T24ReverseList
 * @Description: 反转链表
 *         方法一: 头插法
 *         方法二: 递归
 * @Author:xuwen
 * @Date: 2020/2/8 下午4:15
 **/
public class T24ReverseList {

    //方法一:头插法
    public LNode reverseLinkList_1(LNode head){
        if(head==null || head.next==null)
            return head;
        LNode p = head.next;
        head.next = null;
        while(p!=null){
            LNode q = p.next;
            p.next = head.next;
            head.next = p;
            p = q;
        }
        return head;
    }

    //方法二: 递归法
    public LNode reverseLinkList_2(LNode head){
        if(head==null || head.next == null)
            return head;
        LNode next = head.next;
        head.next = null;
        LNode newHead = reverseLinkList_2(next);
        next.next = head;
        return newHead;
    }

    public static void main(String[] args){

        System.out.print("请输入链表: ");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] arr = new int[s.length];
        for(int i=0;i<s.length;i++)
            arr[i] = Integer.parseInt(s[i]);
        sc.close();
        LNode head = new LNode();
        head = head.buildLNode(arr);
        T24ReverseList object = new T24ReverseList();
        System.out.print("反转后的链表为: ");
        head = object.reverseLinkList_2(head);
        head.printNode(head);
    }

}
