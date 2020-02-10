package OfferCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: T32_1FloorOrderPrint
 * @Description: 按层打印出二叉树的各层结点, 也可以理解为找出二叉树的层数
 *          思路: 二叉树层序遍历的改装
 * @Author:xuwen
 * @Date: 2020/2/10 下午1:18
 **/
public class T32_1FloorOrderPrint {

    public void FloorOrderPrint(TreeNode root){

        if(root==null)
            return;
        //层序遍历的队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int nextLevel=0; //表示下一层结点数
        int toBePrint=1; //表示当前所在层还未打印的结点数

        while(!queue.isEmpty()){

            TreeNode p = queue.peek();
            System.out.println(p.data+" ");
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
                System.out.println();
                toBePrint = nextLevel;
                nextLevel = 0;
            }

        }



    }


}
