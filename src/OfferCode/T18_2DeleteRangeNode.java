package OfferCode;

import java.util.Scanner;

/**
 * @ClassName: T18_2DeleteRangeNode
 * @Description: 删除有序的单链表中重复的结点
 *          思路: 定义两个指针,p和q,去为p的下一结点,由于链表是有序的,直接比较p和q的值
 *               如果p和q的值不相等,则两者一起进行next操作
 *               如果p和q的值相等,,则将p的next指向q的next,将q删除后,再令q=p.next
 * @Author:xuwen
 * @Date: 2020/2/7 下午3:52
 **/
public class T18_2DeleteRangeNode {

    //删除有序单链表中的重复元素
    public void deleteRangeNode(LNode head){
        LNode p = head.next;
        LNode q = p.next;
        while(p.next!=null){
            if(q.data == p.data){
                p.next = q.next;
                q = p.next;
            }else {
                p = q;
                q = p.next;
            }
        }
    }

    public static void main(String[] args){
        System.out.print("请输入链表: ");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] arr = new int[s.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        LNode head = new LNode();
        head = head.buildLNode(arr);
        System.out.print("删除重复元素前的链表为: ");
        head.printNode(head);
        T18_2DeleteRangeNode object = new T18_2DeleteRangeNode();
        object.deleteRangeNode(head);
        System.out.print("\n删除重复元素后的链表为: ");
        head.printNode(head);

    }


}
