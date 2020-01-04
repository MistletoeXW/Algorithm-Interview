package JavaAlgorithmInterview.LinkList;

//删除链表中数据重复的结点.分为无序链表和有序链表 P24
//无序链表需要两层循环，时间复杂度为O(n^2)
//有序链表只需一层循环
import java.util.Scanner;
public class DelRangeLinkListP24 {

    //删除有序单链表中的重复结点
    public static LNode DelRangeLink1(LNode head){
        if(head == null || head.next == null)
            return head;
        LNode p = head.next;
        while(p.next != null){ //判断当前结点以及下一个结点的值是否相等
            if(p.data == p.next.data){
                LNode q = p.next;
                p.next = q.next;
                q.next = null;
            }
            else
                p = p.next;
        }
        return head;
    }

    public static void main(String[] args){
        //构造链表，其中使用了输入函数Scanner，自定义链表数据
        LNode head = new LNode();
        head.next = null;
        LNode r = head;
        int[] data = {1,2,2,2,3,3,4,5,6};
        for(int i = 0;i < data.length;i++){
            LNode p = new LNode();
            p.data = data[i];
            r.next = p;
            r = p;
            r.next = null;
        }
        System.out.print("原链表数据：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }

        LNode newhead = DelRangeLink1(head);
        System.out.print("\n删除重复结点后数据如下：");
        for(LNode cur=head.next;cur!=null;cur = cur.next){
            System.out.print(cur.data + " ");
        }
    }

}
