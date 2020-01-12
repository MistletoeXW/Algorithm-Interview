package JavaAlgorithmInterview.StackAndQueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P69IsPopSerial
 * @Description: 给定一个入栈序序列，判断给定的出栈顺序是否满足其出栈顺序
 * @Author:xuwen
 * @Date: 2020/1/12 下午7:21
 **/
public class P69IsPopSerial {

    /*
     * @Author: xw
     * @Description: 判断出栈序列是否满足是给定的入栈序列的出栈序列//TODO
     * @Date: 下午7:25 2020/1/12
     * @Param: [push, pop]
     * @Return: boolean
     **/
    public static boolean IsPopSerial(int[] push , int[] pop){
        if(push==null || pop == null)
            return false;
        int pushLen = push.length;
        int popLen = pop.length;
        if(pushLen != popLen)
            return false;
        int pushIndex = 0;
        int popIndex = 0;
        Stack<Integer> stack = new Stack<>();
        while(pushIndex < pushLen){
            //把栈顶元素依次入栈，直到栈顶元素等于pop序列的第一个元素
            stack.push(push[pushIndex]);
            pushIndex++;
            //栈顶元素出栈，pop序列移动到下一个元素
            while(!stack.empty() && stack.peek() == pop[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        if(stack.empty() && (popIndex == popLen)){ //如果经历上述过程后栈为空且popIndex = popLen则返回true
            return true;
        }else
            return false;
    }

    public static void main(String[] args){
        //控制台输入栈
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入入栈序列：");
        String[] a = sc.nextLine().trim().split(" ");
        System.out.print("请输入出栈序列：");
        String[] b = sc.nextLine().trim().split(" ");
        sc.close();
        int[] push = new int[a.length];
        int[] pop = new int[b.length];
        for(int i=0;i<a.length;i++){
            push[i] = Integer.parseInt(a[i]);
            pop[i] = Integer.parseInt(b[i]);
        }
        Boolean judage = IsPopSerial(push,pop);
        if(judage == true){
            System.out.print("出栈序列满足");
        }else {
            System.out.print("出栈序列不满足");
        }

    }









}
