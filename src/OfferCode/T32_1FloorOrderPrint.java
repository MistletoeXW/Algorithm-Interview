package OfferCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @ClassName: T32_1FloorOrderPrint
 * @Description: 按层打印出二叉树的各层结点, 也可以理解为找出二叉树的层数
 *          思路: 二叉树层序遍历的改装
 * @Author:xuwen
 * @Date: 2020/2/10 下午1:18
 **/
public class T32_1FloorOrderPrint {

    public int FloorOrderPrint(TreeNode root){

        if(root==null)
            return 0;
        //层序遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel=0; //表示下一层结点数
        int toBePrint=1; //表示当前所在层还未打印的结点数
        int floor = 0; //统计层数
        while(!queue.isEmpty()){

            TreeNode p = queue.peek();
            System.out.print(p.data+" ");
            if(p.lchild != null){
                queue.add(p.lchild);
                nextLevel++;
            }

            if(p.rchild != null){
                queue.add(p.rchild);
                nextLevel++;
            }
            //当前结点出队
            queue.poll();
            toBePrint--; //还未打印的结点数-1

            if(toBePrint == 0){
                //也可以在这里统计层数
                floor++;
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }

        }
        return floor;
    }

    public static void main(String[] args){

        System.out.print("请输入生成树的元素数组: ");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] arr = new int[s.length];
        for(int i=0;i<s.length;i++){
            arr[i] = Integer.parseInt(s[i]);
        }
        sc.close();

        TreeNode root = new TreeNode();
        root  = root.buildBinaryTree(arr,0,arr.length-1);

        System.out.print("建立的二叉树每一层打印出来为:\n");
        T32_1FloorOrderPrint object = new T32_1FloorOrderPrint();
        int floor = object.FloorOrderPrint(root);
        System.out.print("二叉树的层数为: "+ floor);

    }


}
