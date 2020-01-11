package JavaAlgorithmInterview.LinkList;
import java.util.Scanner;

/**
 * @ClassName:P44MergeLinkList
 * @Description: 合并两个升序排列的两个链表，合并后的链表要求也升序排列
 * @Author:xuwen
 * @Date: 2020/1/11 下午5:27
 **/
public class P44MergeLinkList {
    /*
     * @Author: xw
     * @Description: 合并两个升序排列的链表，要求排序后的链表也是升序//TODO
     * @Date: 下午5:29 2020/1/11
     * @Param: [A, B]
     * @Return: JavaAlgorithmInterview.LinkList.LNode
     **/
    public static LNode MergeLinkList(LNode A,LNode B){
        LNode pa = A.next;
        LNode pb = B.next;
        LNode qa;
        LNode qb;
        LNode r = A;
        A.next = null;
        while(pa != null && pb != null){
            qa = pa.next;
            qb = pb.next;
            if(pa.data <= pb.data){
                pa.next = r.next;
                r.next = pa;
                r = pa;
                pa = qa;
            }else {
                pb.next = r.next;
                r.next = pb;
                r = pb;
                pb = qb;
            }
        }
        while(pa != null) {
            qa = pa.next;
            pa.next = r.next;
            r.next = pa;
            r = pa;
            pa = qa;
        }
        while(pb != null) {
            qb = pb.next;
            pb.next = r.next;
            r.next = pb;
            r = pb;
            pb = qb;
        }
        return A;
    }

    public static void main(String[] args){

        //控制台输入两数组
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入链表A：");
        String[] a = sc.nextLine().trim().split(" ");
        System.out.print("请输入链表B：");
        String[] b = sc.nextLine().trim().split(" ");
        sc.close(); //结束控制台输入
        LNode A = new LNode();
        A.next = null;
        LNode ra = A;
        for(int i=0;i < a.length;i++){
            LNode p = new LNode();
            p.next = null;
            p.data = Integer.parseInt(a[i]);
            ra.next = p;
            ra = p;
        }
        LNode B = new LNode();
        B.next = null;
        LNode rb = B;
        for(int i=0;i < b.length;i++){
            LNode p = new LNode();
            p.next = null;
            p.data = Integer.parseInt(b[i]);
            rb.next = p;
            rb = p;
        }
        LNode result = MergeLinkList(A,B);

        System.out.print("合并后的链表为：");
        LNode p = result.next;
        while(p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }

    }
















}
