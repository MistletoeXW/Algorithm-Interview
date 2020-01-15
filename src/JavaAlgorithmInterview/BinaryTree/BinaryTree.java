package JavaAlgorithmInterview.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName:BinaryTree
 * @Description: 二叉树结构类
 * @Author:xuwen
 * @Date: 2020/1/12 下午9:40
 **/
public class BinaryTree {
    int data;
    BinaryTree lchild,rchild;

    /*
     * @Author: xw
     * @Description: 利用层序遍历,根据树中值查找到结点//TODO
     * @Date: 下午7:49 2020/1/15
     * @Param: [node_num]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public BinaryTree FindTreeNode(BinaryTree root,int node_num){

        Queue<BinaryTree> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){

            BinaryTree node = queue.poll();
            if(node.data == node_num)
                return node;
            if(node.lchild != null)
                queue.offer(node.lchild);
            if(node.rchild != null)
                queue.offer(node.rchild);
        }

        return null;


    }

}
