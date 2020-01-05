package JavaAlgorithmInterview.LinkList;

//实现链表的逆序  P20
//1. 方法一：就地置逆法，设置pre p q 三个指针。太麻烦一般不用
//2. 方法二：插入法，使用头插法
//3. 方法三：递归法
public class P20ReverseLinklist {

    //使用头插发来实现链表置逆
    public static void Reverse2(LNode head){
        if(head == null || head.next == null)
            return;
        LNode p = null;
        LNode next = null;
        p = head.next.next;
        head.next.next = null; //设置第一个结点的后续为null
        while(p != null){
            next = p.next;
            p.next = head.next;
            head.next = p;
            p=next;
        }
    }

    //使用递归法来实现逆序
    //将不带头结点的单链表逆序
    public static LNode RecursiveReverse(LNode head){
        if(head == null || head.next == null){
            return head;
        }else {
            //反转后面的结点
            LNode newhead = RecursiveReverse(head.next);
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }
    //这里实现的是将带头结点的单链表的逆序
    public static void Reverse3(LNode head){
        if(head == null)
            return;
        LNode firstNode = head.next;
        LNode newhead = RecursiveReverse(firstNode);
        head.next = newhead;
    }

    //逆序输出链表数据利用递归法
    public static void ReversePrint(LNode firstNode){
        if(firstNode == null)
            return;
        ReversePrint(firstNode.next);
        System.out.print(firstNode.data+" ");
    }


    public static void main(String[] args){
        //链表的头结点
        LNode head = new LNode();
        head.next = null;
        LNode tmp = null;
        LNode cur = head;
        //构造单链表
        for(int i=1;i<8;i++){
            tmp = new LNode();
            tmp.data = i;
            tmp.next = null;
            cur.next = tmp;
            cur=tmp;
        }
        System.out.print("置逆前:");
        for(cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }
        System.out.print("置逆后:");
        Reverse2(head);
        for(cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }
    }
}
