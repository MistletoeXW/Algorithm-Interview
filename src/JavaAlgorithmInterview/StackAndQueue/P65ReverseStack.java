package JavaAlgorithmInterview.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P65ReverseStack
 * @Description:翻转一个栈，使栈中的元素由原来的栈顶到栈底的顺序变为栈底到站顶的顺序
 *              方法一：另外开辟一个辅助队列
 *              方法二：使用递归的方法实现，分为两步操作
 *                     操作一：将栈底元素移动到栈顶
 *                     操作二：递归调用除栈顶元素外的子栈
 * @Author:xuwen
 * @Date: 2020/1/11 下午9:08
 **/
public class P65ReverseStack {

    /*
     * @Author: xw
     * @Description: 把栈底元素移动到栈顶//TODO
     *               假设初始栈为栈顶开始： 1 2 3 4 5
     *               则要将栈底移动到栈顶，可以将1出栈，将子栈2 3 4 5递归
     *               递归后的结果为 1 5 2 3 4，此时再交换栈顶1和子栈5的栈顶就行
     * @Date: 下午9:12 2020/1/11
     * @Param: [s]
     * @Return: void
     **/
    public static void moveBottomToTop(Stack<Integer> s){
        if(s.empty())
            return;
        int top1 = s.peek();//取栈顶元素
        s.pop();//出栈
        if(!s.empty()){
            //递归处理不包含栈顶元素的子栈
            moveBottomToTop(s);//这里理解为将子栈进行递归
            int top2 = s.peek();//记录子栈的栈顶元素
            s.pop();
            //交换栈顶元素与子栈栈顶元素
            s.push(top1);
            s.push(top2);
        }else {
            s.push(top1);
        }
    }

    /*
     * @Author: xw
     * @Description: 在上一步将栈底元素放入栈顶后，此时递归调用除栈顶元素的子栈//TODO
     * @Date: 下午9:39 2020/1/11
     * @Param: [s]
     * @Return: void
     **/
    public static void RerverseStack(Stack<Integer> s){
        if(s.empty())
            return;
        moveBottomToTop(s);
        int top = s.peek();
        s.pop();
        //递归处理子栈
        RerverseStack(s);
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

        System.out.print("翻转前栈中的元素出栈顺序为：");
        while(!index.empty()){
            System.out.print(index.peek()+" ");
            index.pop();
        }
        RerverseStack(s);
        System.out.print("\n翻转后栈中的元素出栈顺序为：");
        while(!s.empty()){
            System.out.print(s.peek()+" ");
            s.pop();
        }
    }








}
