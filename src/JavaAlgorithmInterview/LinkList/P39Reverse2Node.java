package JavaAlgorithmInterview.LinkList;

import java.util.Scanner;

/**
 * @ClassName:P39Reverse2Node
 * @Description: 将单链表中相邻的结点进行交换，使用指针的方法进行翻转，设置pre cur 和 next三个指针
 * @Author:xuwen
 * @Date: 2020/1/5 下午10:41
 **/
public class P39Reverse2Node {

    /*
     * @Author: xw
     * @Description: 将单链表中相邻的结点进行交换，使用指针的方法进行翻转，设置pre cur 和 next三个指针//TODO
     * @Date: 下午10:44 2020/1/5
     * @Param: [head]
     * @Return: void
     **/
    public static void Reverse2Node(LNode head){
        LNode pre = head;
        LNode cur = head.next;
        while(cur != null && cur.next != null){
            LNode next = cur.next.next;
            pre.next = cur.next;
            cur.next.next = cur;
            cur.next = next;
            pre = cur;
            cur = next;
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

        Reverse2Node(head);
        System.out.print("交换后链表的值为：");
        LNode cur = head.next;
        while(cur != null){
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
    }
}
