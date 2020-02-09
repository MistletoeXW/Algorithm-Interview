package OfferCode;

import java.util.Stack;

/**
 * @ClassName: T31IsPopOrder
 * @Description: 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 *               假设压入栈的所有数字均不相等。
 *          例如: 序列 1,2,3,4,5 是某栈的压入顺序，
 *               序列 4,5,3,2,1 是该压栈序列对应的一个弹出序列，
 *               但 4,3,5,1,2 就不可能是该压栈序列的弹出序列。
 *
 *          思路: 使用一个栈来模拟入栈顺序
 *               1. 把push序列依次入栈,直到栈顶元素等于pop序列第一个元素,然后栈顶元素出栈,pop序列移动到下一个元素
 *               2. 如果栈顶继续等于pop序列现在的元素,则继续出栈并pop后移;否则对push序列继续入栈
 *               3. 如果push序列已经全部入栈,但是破pop序列未全部遍历, 而且栈顶元素不等于此时pop的元素,那么就不是一个可能的pop序列
 *                  如果栈为空,pop序列也遍历完,则说明是一个可能的pop序列
 * @Author:xuwen
 * @Date: 2020/2/9 下午3:58
 **/
public class T31IsPopOrder {

    public static boolean idPopStack(String push,String pop){

        if(push == null || pop == null)
            return false;
        if(push.length() < pop.length())
            return false;
        int pushIndex =0;
        int popIndex = 0;
        Stack<Character> stack = new Stack<>();
        //遍历入栈序列
        while (pushIndex < push.length()){

            //把栈顶元素依次入栈,直到栈顶元素等于pop序列当前元素
            stack.push(push.charAt(pushIndex));
            pushIndex++;
            //栈顶元素出栈,pop序列移动到下一个元素
            while (!stack.isEmpty() && stack.peek()==pop.charAt(popIndex)){

                stack.pop();
                popIndex++;

            }

        }

        //栈为空且pop序列遍历完毕则返回true
        return stack.isEmpty() && popIndex==pop.length();

    }


}
