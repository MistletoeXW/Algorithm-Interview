package OfferCode;

/**
 * @ClassName: T23FindLoopEnterInLinkLIst
 * @Description: 找到循环链表中的环的入口点
 *        首先要想到如何判断一个链表是否有环:
 *            使用快慢指针,慢指针一次一步,快指针一次两步,快慢指针每次移动都要进行比较,如果快慢指针相等,说明存在环
 *        接下来再考虑如何找出环:
 *            首先,定义两个指针P1和P2指向链表的头结点,如果链表中的环有你个结点,则指针P1先在链表中向前移动n步
 *            然后两个指针再以相同的速度向前移动,两者相遇点就是入口结点
 *            现在的问题是如何找到环有多少个结点:
 *                  首先我们可以在判断是否有环的时候找到相遇点,我们很容易得出相遇点肯定在环中,那么可以从这个点出发,
 *                  进行遍历,统计结点个数,回到相遇点就是环中的结点数.
 *            其实最终推算出,判断是否有环时相遇点就是快指针先走到达的地方
 *
 * @Author:xuwen
 * @Date: 2020/2/8 下午3:22
 **/
public class T23FindLoopEnterInLinkLIst {

    public int findLoopEnter(LNode head){
        //首先找到快慢指针的相遇点
        LNode p = head;
        LNode q = head;
        while(true){
            p = p.next;
            q = q.next.next;

            if(p.data == q.data)
                break;
        }
        LNode fast = p;
        LNode slow = head.next;
        while(slow != fast){

            slow = slow.next;
            fast = fast.next;

        }
        return slow.data;

    }


}
