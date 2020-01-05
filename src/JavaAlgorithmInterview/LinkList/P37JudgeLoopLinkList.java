package JavaAlgorithmInterview.LinkList;

import java.util.Scanner;

/**
 * @ClassName:P37JudgeLoopLinkList
 * @Description: 检测一个较大的单链表是否有环，并且找出环的入口点
 * @Author:xuwen
 * @Date: 2020/1/5 下午9:29
 **/
public class P37JudgeLoopLinkList {

    /*
     * @Author: xw
     * @Description: 判断单链表是否有环，使用快慢指针法，慢指针一次走1步，快指针一次走2步//TODO
     * @Date: 下午9:56 2020/1/5
     * @Param: [head]
     * @Return: JavaAlgorithmInterview.LinkList.LNode
     **/
    public static LNode JudgeIsLoop(LNode head){
        if(head == null || head.next == null)
            return null;
        LNode slow = head.next;
        LNode fast = head.next;
        while (fast != null && fast.next != null){ //慢指针一次走1步，快指针一次走2步
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return slow;
        }
        return null;
    }

    /*
     * @Author: xw
     * @Description: 如果单链表含有环，则找出环的入口点//TODO
     *               方法为设置链头为一指针，相遇点为二指针，两者同时进行遍历，直到两者相遇，相遇点为环入口
     * @Date: 下午10:03 2020/1/5
     * @Param: [head, meetNode]
     * @Return: JavaAlgorithmInterview.LinkList.LNode
     **/
    public static LNode FindLoopNode(LNode head,LNode meetNode){
        LNode firstNode = head.next;
        LNode secondNode = meetNode;
        while(firstNode.data != secondNode.data){
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }
        return firstNode;
    }

    public static void main(String[] args) {
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
        if(num[length-1] != length){
            LNode cur = head.next;
            for(int i=0;i<num[length-1];i++){
                cur = cur.next;
            }
            r.next = cur;
        }
        LNode meetNode = JudgeIsLoop(head);
        if(meetNode != null){
            System.out.print("此链表有环！"+'\n');
            LNode LoopNode = FindLoopNode(head,meetNode);
            System.out.print("环的入口为："+ LoopNode.data);
        }else {
            System.out.print("此链表无环！");
        }
    }
}
