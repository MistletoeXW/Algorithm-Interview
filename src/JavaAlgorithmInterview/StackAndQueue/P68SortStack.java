package JavaAlgorithmInterview.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P68SortStack
 * @Description: 将栈中元素排序，使用递归的方法
 *               首先对不包含栈顶元素的子栈进行排序
 *               如果栈顶元素大于子栈的栈顶元素，则交换这两个元素.
 *               所以与翻转栈中元素思路相同，只需要在交换栈顶元素和子栈时加入一个判断就行
 * @Author:xuwen
 * @Date: 2020/1/11 下午9:54
 **/
public class P68SortStack {
    /*
     * @Author: xw
     * @Description: 把栈底元素移动到栈顶//TODO
     * @Date: 下午10:09 2020/1/11
     * @Param: [s]
     * @Return: void
     **/
    public static void MoveBottemToTop(Stack<Integer> s){
        if(s.empty())
            return;
        int top1 = s.peek();
        s.pop();
        if(!s.empty()){
            MoveBottemToTop(s);
            int top2 = s.peek();
            if(top1 > top2){
                s.pop();
                s.push(top1);
                s.push(top2);
                return;
            }
        }
        s.push(top1);
    }

    public static void SortStack(Stack<Integer> s){
        if(s.empty())
            return;
        MoveBottemToTop(s);//把栈底元素移动到栈顶
        int top=s.peek();
        s.pop();
        SortStack(s);//递归处理子栈
        s.push(top);
    }

    public static void main(String[] args){
        //控制台输入栈
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入栈元素：");
        String[] a = sc.nextLine().trim().split(" ");
        sc.close();
        Stack<Integer> s = new Stack<>();
        Stack<Integer> index = new Stack<>();
        for(int i=0;i<a.length;i++){
            s.push(Integer.parseInt(a[i]));
            index.push(Integer.parseInt(a[i]));
        }

        System.out.print("排序前栈中的元素出栈顺序为：");
        while(!index.empty()){
            System.out.print(index.peek()+" ");
            index.pop();
        }
        SortStack(s);
        System.out.print("\n排序后栈中的元素出栈顺序为：");
        while(!s.empty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }
















}
