package JavaAlgorithmInterview.LinkList;

import javax.script.AbstractScriptEngine;
import java.util.Scanner;

/**
 * @ClassName:P41ReverseKNode
 * @Description: 单链表以K个结点一组进行翻转
 * @Author:xuwen
 * @Date: 2020/1/5 下午10:52
 **/
public class P41ReverseKNode{

    /*
     * @Author: xw
     * @Description: 将K组的结点进行翻转：1->2->3 变为 1<-2<-3//TODO
     * @Date: 下午11:11 2020/1/5
     * @Param: [begin]
     * @Return: JavaAlgorithmInterview.LinkList.LNode
     **/
    public static LNode Reverse2Node(LNode begin){
        if(begin == null || begin.next == null)
            return begin;
        LNode pre = begin;
        LNode cur = begin.next;
        LNode next = cur.next;
        pre.next = null;

        while(cur != null){
            next=cur.next;
            cur.next = pre;
            pre = cur;
            cur = cur.next;
            cur = next;
        }
        return pre;
    }

    /*
     * @Author: xw
     * @Description: 单链表以K个结点一组进行翻转 //TODO
     * @Date: 下午10:54 2020/1/5
     * @Param: [head]
     * @Return: void
     **/
    public static void ReverseKNode(LNode head,int k){
        if(head == null || head.next == null)
            return;
        LNode begin = head.next;
        LNode pre = head;
        while (begin != null || begin.next != null){
            LNode end = begin;
            for(int i=0;i<k-1;i++){
                if(end.next != null)
                    end = end.next;
                else
                    return;
            }
            LNode next = end.next;
            end.next = null;
            pre.next = Reverse2Node(begin);
            begin.next = next;
            pre = begin;
            begin = next;
        }
    }

    public static void main(String[] args){
        int length = 0;
        System.out.print("请输入链表的长度：");
        Scanner sc = new Scanner(System.in);
        if(sc.hasNextInt()){
            length = sc.nextInt();
        }
        int[] num = new int[length];
        System.out.print("请输入链表的各结点值：");
        Scanner in = new Scanner(System.in);
        for(int i=0;i<length;i++){
            num[i] = in.nextInt();
        }
        LNode head = new LNode();
        head.next = null;
        LNode r = head;
        for(int i=0;i < num.length;i++){
            LNode p = new LNode();
            p.next = null;
            p.data = num[i];
            r.next = p;
            r = p;
        }

        System.out.print("请输入K值：");
        Scanner ink = new Scanner(System.in);
        int k = ink.nextInt();

        ReverseKNode(head,k);

        System.out.print("交换后链表的值为：");
        LNode cur = head.next;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
}
