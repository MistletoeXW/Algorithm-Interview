package OfferCode;

import sun.security.krb5.SCDynamicStoreConfig;

import java.awt.*;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: T6PrintListFromTailToHead
 * @Description: 从尾到头打印链表
 *          方法一: 使用递归
 *                 要逆序打印链表1-->2-->3,可以先逆序打印链表 2-->3,最后打印第一个结点1
 *                 对2-->3也可以递归下去
 *          方法二: 使用栈,在遍历的过程中,将值按着顺序放入栈中,最后出栈的顺序即为逆序
 *          方法三: 使用头插法,将链表反转
 * @Author:xuwen
 * @Date: 2020/2/2 下午2:46
 **/
public class T6PrintListFromTailToHead {

    //==========================方法一: 递归法==========================

    public static void printListFromTailToHead_1(LNode L){

        if(L.next != null)
            printListFromTailToHead_1(L.next);//递归

        System.out.print(L.data+" "); //打印结点的值
    }

    //==========================方法二: 加入栈法==========================
    public static void printListFromTailToHead_2(LNode head){

        Stack<Integer> stack = new Stack<Integer>();
        LNode p = head.next;
        while(p != null){
            stack.push(p.data);
            p = p.next;
        }

        while(! stack.empty()){
            Integer num = stack.pop();
            System.out.print(num+" ");
        }

    }

    //==========================方法三: 头插法==========================
    public static void printListFromTailToHead_3(LNode head){

        LNode p = head.next;
        head.next = null; //将头部指空
        while(p != null){

            LNode q = p.next; //将p的下一个结点记录防止断链
            p.next = head.next;
            head.next = p;
            p = q;
        }

        //将链表反转后遍历打印出来
        LNode cur = head.next;
        while (cur != null){

            System.out.print(cur.data);
            cur = cur.next;
        }

    }


    public static void main(String[] args){

        System.out.print("请输入链表的值: ");
        Scanner sc = new Scanner(System.in);

        String[] s = sc.nextLine().trim().split(" ");
        //创建链表
        LNode head = new LNode();
        head.next = null;
        LNode r = head;//尾插法设置尾指针
        for (int i=0;i<s.length;i++){

            LNode p = new LNode();
            p.data = Integer.parseInt(s[i]);
            r.next = p;
            r = p;
            r.next = null;
        }

        System.out.print("从尾到头输出链表为: ");
        printListFromTailToHead_3(head);




    }


}
