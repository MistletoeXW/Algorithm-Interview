package XindongNet;

class LNode {  //Java中使用引用来建立单链表
    int data;
    LNode next;

    public int getLength(LNode head){
        LNode p = head.next;
        int length=0;
        while(p != null){
            length++;
            p = p.next;
        }
        return length;
    }
}
