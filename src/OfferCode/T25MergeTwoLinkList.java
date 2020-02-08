package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T25MergeTwoLinkList
 * @Description: 合并两个排序的链表
 * @Author:xuwen
 * @Date: 2020/2/8 下午4:49
 **/
public class T25MergeTwoLinkList {

    //一般方法
    public LNode MergeLinkList_1(LNode head1,LNode head2){
        if(head1.next == null && head2.next != null)
            return head2;

        if(head2.next == null && head1.next != null)
            return head1;
        if(head1.next==null && head2.next==null)
            return head1;
        LNode p = head1.next;
        LNode q = head2.next;
        head1.next = null;
        LNode cur = head1;
        while(p != null && q != null){
            LNode rp = p.next;
            LNode rq = q.next;
            if(p.data <= q.data){
                p.next = cur.next;
                cur.next = p;
                cur = p;
                p = rp;
            }else {
                q.next = cur.next;
                cur.next = q;
                cur = q;
                q = rq;
            }

        }
        if(p!=null)
            cur.next = p;
        if(q!=null)
            cur.next = q;
        return head1;
    }

    //递归法
    public LNode MergeLinkList_2(LNode head1,LNode head2){

        if(head1 == null)
            return head2;
        if(head2 == null)
            return head1;
        LNode newHead = new LNode();
        LNode p = head1.next;
        LNode q = head2.next;
        LNode cur = newHead.next;
        if(p.data <= q.data){
            cur = p;
            cur.next = MergeLinkList_2(p.next,q);
        }else {
            cur = q;
            cur.next = MergeLinkList_2(p,q.next);
        }

        return newHead;

    }


    public static void main(String[] args){
        System.out.print("请输入链表1: ");
        Scanner sc1 = new Scanner(System.in);
        String[] s1 = sc1.nextLine().trim().split(" ");
        int[] arr1 = new int[s1.length];
        for(int i=0;i<arr1.length;i++)
            arr1[i] = Integer.parseInt(s1[i]);

        System.out.print("请输入链表2: ");
        Scanner sc2 = new Scanner(System.in);
        String[] s2 = sc1.nextLine().trim().split(" ");
        int[] arr2 = new int[s2.length];
        for(int i=0;i<arr1.length;i++)
            arr2[i] = Integer.parseInt(s2[i]);

        sc1.close();
        sc2.close();

        LNode head1 = new LNode();
        LNode head2 = new LNode();
        head1 = head1.buildLNode(arr1);
        head2 = head2.buildLNode(arr2);

        T25MergeTwoLinkList object = new T25MergeTwoLinkList();
        LNode newhead = object.MergeLinkList_1(head1,head2);
        newhead.printNode(newhead);
    }
}
