package JavaAlgorithmInterview.LinkList;

import java.util.Scanner;

//对链表进行排序，这里用的方法是插入排序的方法
//对前部排好次序的部分进行头插法插入
public class P30SortLinkList {

    public static void SortLinkList(LNode head){
        LNode p = head.next.next;
        LNode q = null;
        LNode pre = head;

        head.next.next = null;
        while(p != null){
            pre = head;
            q = p.next;
            while(pre.next != null && pre.next.data < p.data){
               pre = pre.next;
            }
            p.next = pre.next;
            pre.next = p;
            p = q;
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
        SortLinkList(head);
        System.out.print("排序后链表的值为：");
        LNode cur = head.next;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }

}
