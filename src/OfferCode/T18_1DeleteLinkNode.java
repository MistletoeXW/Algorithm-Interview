package OfferCode;

/**
 * @ClassName: T18_1DeleteLinkNode
 * @Description: 在O(1)时间内删除链表结点,给定单向链表的头指针和一个节点指针,定义一个函数在O(1)时间内删除结点
 *         一般思路: 在删除结点i之前,先从链表的头结点开始遍历到i前面一个结点h,然后把h的next指针指向i结点的下一个结点
 *         O(1)的思路: 把i的下一个结点j的值复制到i,然后把i的next指向i的下下结点,再删除j;
 *                    但是此时要考虑另一个情况,就是在删除尾结点的时候,此方法不使用了,还是回归到一般方法
 *                    这样算下来,如果进行N次操作,那么大约需要操作的结点的次数为n-1+n=2n-1
 *                    其中n-1表示n-1个不是尾结点的每个结点以o(1)的时间复杂度操作的总次数
 *                    n表示尾结点以o(n)的时间复杂度操作结点的总次数
 *                    (2n-1)/n=2,所以该算法的平均时间复杂度为o(1)
 * @Author:xuwen
 * @Date: 2020/2/7 下午2:54
 **/
public class T18_1DeleteLinkNode {

    public LNode deleteNode(LNode head,LNode tobeDelete){

        if(head == null || tobeDelete == null)
            return null;
        if(tobeDelete.next != null){
            //要删除的结点不是尾结点
            LNode next = tobeDelete.next;
            tobeDelete.data = next.data;
            tobeDelete.next = next.next;
        }else {
            if(head == tobeDelete){
                //只有一个结点
                head = null;
            }else {
                LNode cur = head;
                while(cur.next != tobeDelete)
                    cur = cur.next;
                cur.next = null;
            }
        }
        return head;
    }


}
