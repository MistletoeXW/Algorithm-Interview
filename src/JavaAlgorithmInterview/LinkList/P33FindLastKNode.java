package JavaAlgorithmInterview.LinkList;

import java.util.Scanner;
/**
 * 单链表查找到倒数第K个结点：使用快慢指针的方法
 */
public class P33FindLastKNode {
    /*
     * @Author: xw
     * @Description: 单链表查找到倒数第K个结点：使用快慢指针的方法//TODO
     * @Date: 下午9:27 2020/1/5
     * @Param: [head, k]
     * @Return: JavaAlgorithmInterview.LinkList.LNode
     **/
    public static LNode FindLastKNode(LNode head,int k){
        LNode p = head.next;
        //先让快指针P走K个结点
        for(int i=0;i<k;i++){
            p = p.next;
        }
        LNode q = head.next;
        while(p != null){
            q = q.next;
            p = p.next;
        }
        return q;
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
        System.out.print("请输入要查找的倒数第几个的结点值：");
        Scanner in1 = new Scanner(System.in);
        int k = in1.nextInt();

        LNode resultNode = FindLastKNode(head,k);

        System.out.print("查找到的结点值为：" + resultNode.data);
    }
}
