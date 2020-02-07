package OfferCode;

/**
 * @ClassName:Node
 * @Description: 链表结点
 * @Author:xuwen
 * @Date: 2020/2/2 下午2:48
 **/
public class LNode {//Java中使用引用来建立单链表
    int data;
    LNode next;

    //将数组转化为单链表,使用尾插法
    public LNode buildLNode(int[] arr){
        LNode head = new LNode();
        head.next = null;
        LNode r = head;
        for(int i=0;i<arr.length;i++){
            LNode p = new LNode();
            p.data = arr[i];
            p.next = r.next;
            r.next = p;
            r = p;
        }
        return head;
    }
}
