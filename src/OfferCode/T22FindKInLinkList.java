package OfferCode;

/**
 * @ClassName: T22FindKInLinkList
 * @Description: 找出链表中倒数第k个结点
 *         思路: 使用快慢指针,快指针先遍历k步后快慢指针再同步,当快指针到尾结点时,慢指针的位置就是倒数第k个
 *         此题中需要注意考察鲁棒性:
 *              各种边界条件, 对于不合乎要求的输入予以合理的处理
 *
 * @Author:xuwen
 * @Date: 2020/2/8 下午3:08
 **/
public class T22FindKInLinkList {

    public int findKInLinkList(LNode head,int k){
        //考虑边界条件当链表为空,或k为0,则返回null
        if(head == null || k==0)
            return 0;

        LNode p = head.next;
        LNode r = head.next;
        for(int i=0;i<k;i++){
            if(r.next != null)
                r = r.next;
            else
                return 0;
        }

        while(r!=null){
            p = p.next;
            r = r.next;
        }
        return p.data;
    }

}
