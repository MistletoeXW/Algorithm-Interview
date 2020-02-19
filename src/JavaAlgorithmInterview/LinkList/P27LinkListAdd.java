package JavaAlgorithmInterview.LinkList;

import java.util.Scanner;

//将两个链表所表示的数相加
// 3->4->5->6->7->9 表示数：976543
// 9->8->2->6->5 表示数：56289
// 两者相加： 2->3->8->2->3->0->1 表示数：1032832
public class P27LinkListAdd {
     public static LNode LinkListAdd(LNode h1,LNode h2){
         if(h1 == null || h1.next == null)
             return h2;
         if(h2 == null || h2.next == null)
             return h1;
         int c=0; //表示进位
         int sum=0;//表示每一位结点之和
         LNode p1 = h1.next;
         LNode p2 = h2.next;

         LNode resultHead = new LNode(); //用来存储相加结果的链表
         resultHead.next = null;
         LNode p = resultHead;  //尾插法时用来记录尾部

         while(p1 != null && p2 != null){ //循环计算各结点之和
             LNode tmp = new LNode();
             tmp.next = null;

             sum = p1.data + p2.data + c; //计算结点之和
             tmp.data = sum % 10;
             c = sum / 10;

             p.next = tmp;
             p=tmp;
             p1 = p1.next;
             p2 = p2.next;
         }

         while(p1 != null){ //如果p1较长
             LNode tmp = new LNode();
             tmp.next=null;

             sum = p1.data + c;
             tmp.data = sum % 10;
             c = sum / 10;

             p.next = tmp;
             p = tmp;
             p1 = p1.next;
         }

         while(p2 != null){ //如果p2较长
             LNode tmp = new LNode();
             tmp.next=null;

             sum = p2.data + c;
             tmp.data = sum % 10;
             c = sum / 10;

             p.next = tmp;
             p = tmp;
             p2 = p2.next;
         }

         if(c == 1){
             LNode tmp = new LNode();
             tmp.next=null;
             tmp.data=1;
             p.next = tmp;
         }

         return resultHead;
     }

     public static void main(String[] args){
         LNode head1 = new LNode();
         head1.next = null;
         LNode p1 = head1;
         LNode head2 = new LNode();
         head2.next = null;
         LNode p2 = head2;

         int length1 = 0;
         int length2 = 0;
         System.out.print("请输入第一个链表的长度：");
         Scanner sc = new Scanner(System.in);
         if(sc.hasNextInt()){
             length1 = sc.nextInt();
         }
         int[] num1 = new int[length1];
         System.out.print("请输入第一个链表的各结点值：");
         Scanner in = new Scanner(System.in);
         for(int i=0;i<length1;i++){
             num1[i] = in.nextInt();
         }
         System.out.print("请输入第二个链表的长度：");
         Scanner sc1 = new Scanner(System.in);
         if(sc1.hasNextInt()){
             length2 = sc1.nextInt();
         }
         int[] num2 = new int[length2];
         System.out.print("请输入第二个链表的各结点值：");
         Scanner in1 = new Scanner(System.in);
         for(int i=0;i<length2;i++){
             num2[i] = in1.nextInt();
         }

         for(int i=0;i<length1;i++){//创建链表1
             LNode tmp = new LNode();
             tmp.next = null;
             tmp.data = num1[i];
             p1.next = tmp;
             p1 = tmp;
         }

         for(int i=0;i<length2;i++){//创建链表2
             LNode tmp = new LNode();
             tmp.next = null;
             tmp.data = num2[i];
             p2.next = tmp;
             p2 = tmp;
         }

         LNode result = LinkListAdd(head1,head2);

         System.out.print("两链表相加后的结果为： ");
         LNode p = result.next;
         while (p != null){
             System.out.print(p.data + " ");
             p = p.next;
         }
     }

}
