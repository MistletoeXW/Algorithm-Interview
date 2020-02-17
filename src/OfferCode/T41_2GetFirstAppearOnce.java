package OfferCode;

import sun.awt.X11.XQueryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: T41_2GetFirstAppearOnce
 * @Description: 找出字符流中第一个不重复的字符
 *          描述: 请实现一个函数用来找出字符流中第一个只出现一次的字符.
 *                例如: 当从字符流中只读出前两个字符 "go" 时，第一个只出现一次的字符是 "g"。
 *                当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"。
 *          思路: 维护一个队列和开辟一个长度为256的数组(因为所有字符的ascii码最大为127)
 *               没次有新元素入队,就判断队顶字符是否出现过,如果出现了就出队,由此循环
 *               直到找到第一个不重复的字符
 * @Author:xuwen
 * @Date: 2020/2/17 下午3:37
 **/
public class T41_2GetFirstAppearOnce {

    private static int[] cnts = new int[127];
    private static Queue<Character> queue = new LinkedList<>();

    public static void Insert(char ch){

        cnts[ch] ++; //在数组中标示此字符出现
        queue.add(ch);
        while (!queue.isEmpty() && cnts[queue.peek()]>1)
            queue.poll();
    }

    public char FirstAppearOnce(){
        return queue.isEmpty() ? '#':queue.peek();
    }


}
