package HUAWEI.Text;

/**
 * @ClassName: Node
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

    //遍历打印出链表元素
    public void printNode(LNode head){
        LNode p = head.next;
        while(p!=null){
            System.out.print(p.data+" ");
            p = p.next;
        }
    }
}
