package XindongNet;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName: test1
 * @Description:
 * @Author:xuwen
 * @Date: 2020/2/28 下午6:55
 **/
public class test1 {

    public static String getStack(String a,String b){

        if(a==null || b==null)
            return "-1";
        Stack<Character> stack = new Stack<>();
        int pushLen = a.length();
        int popLen = b.length();
        if(pushLen != popLen)
            return "-1";
        int pushIndex = pushLen-1;
        int popIndex = 0;
        StringBuilder result = new StringBuilder();
        while(pushIndex >= 0){
            stack.push(a.charAt(pushIndex));
            result.append("E");
            pushIndex--;
            while (!stack.isEmpty() && stack.peek() == b.charAt(popIndex)){
                result.append("D");
                stack.pop();
                popIndex++;
            }
        }
        if(stack.empty() && popIndex==popLen){
            return result.toString();
        }else {
            return "-1";
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        sc.close();
        String result = getStack(a[0],a[1]);
        System.out.print(result);

    }



}
