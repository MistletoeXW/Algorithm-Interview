package OfferCode;

import java.util.Stack;

/**
 * @ClassName: T9TwoStackToQueue
 * @Description: 运用两个栈来实现一个队列,完成队列的Push和Pop操作
 *          解决方案: in栈来处理入栈(push)操作, out栈来处理出栈(pop)操作.一个元素进入in栈后,出栈的顺序被反转.
 *                  当一个元素要出栈时,需要先进入out栈,此时元素出栈顺序再一次被反转
 * @Author:xuwen
 * @Date: 2020/2/3 上午10:41
 **/
public class T9TwoStackToQueue {

    Stack<Integer> in = new Stack<Integer>(); //in栈来处理入栈操作
    Stack<Integer> out = new Stack<Integer>(); //out栈来处理出栈操作

    public void push(int node){
        in.push(node);
    }

    public int pop() throws Exception{
        if(out.isEmpty()){
            while(!in.isEmpty())
                out.push(in.pop());
        }

        if(out.isEmpty()){
            throw new Exception("Queue is empty");
        }

        return out.pop();
    }


}
