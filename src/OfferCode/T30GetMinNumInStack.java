package OfferCode;

import java.util.Stack;

/**
 * @ClassName: T30GetMinNumInStack
 * @Description: 实现一个栈的数据结构,里面包含一个能够弹出此时栈中最小元素的函数,且push,pop,min函数都是O(1)的
 *          思路: 使用一个辅助栈,每次都把最小的元素压入辅助栈中,就能保证辅助栈栈顶为最小元素
 *
 * @Author:xuwen
 * @Date: 2020/2/9 下午3:43
 **/
public class T30GetMinNumInStack {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    //在压入元素到栈的操作中,比较压入的值与最小值栈中栈顶元素的值,小的压入栈
    public void push(int node){
        dataStack.push(node);
        if(minStack != null){
            minStack.push(Math.min(minStack.peek(),node));
        }else {
            minStack.push(node);
        }
    }

    //在出栈的同时,最小值栈也要出栈
    public void pop(){
        dataStack.pop();
        minStack.pop();
    }

    //得到当前的最小值
    public int min(){
        return minStack.peek();
    }




}
