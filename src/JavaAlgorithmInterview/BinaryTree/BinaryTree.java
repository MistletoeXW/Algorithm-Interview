package JavaAlgorithmInterview.BinaryTree;

import OfferCode.TreeNode;

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

    public BinaryTree(int data) {
        this.data = data;
    }

    public BinaryTree() {

    }

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

    /*
     * @Author: xw
     * @Description: 利用中序遍历,将数组构建成一颗二叉树//TODO
     * @Date: 下午3:12 2020/2/7
     * @Param: [arr]
     * @Return: OfferCode.TreeNode
     **/
    public BinaryTree buildBinaryTree(int[] arr, int low, int high){

        if(low <= high){
            int mid = (low+high+1)/2;
            //树的根结点为数组的中间元素
            BinaryTree root = new BinaryTree(arr[mid]);
            //递归左半部分数组构造左子树
            root.lchild = buildBinaryTree(arr,low,mid-1);
            //递归右半数组构造右子树
            root.rchild = buildBinaryTree(arr,mid+1,high);
            return root;
        }else
            return null;
    }

    //按照数组的顺序建立二叉树
    public BinaryTree buildBinaryTreeByArray(Integer[] arr,int index){
        BinaryTree root = null;
        if(index < arr.length){
            Integer value = arr[index];
            if(value == null)
                return null;
            root = new BinaryTree(value);
            root.lchild = buildBinaryTreeByArray(arr,2*index);
            root.rchild = buildBinaryTreeByArray(arr,2*index+1);
            return root;
        }
        return root;
    }

    public void floorOrder(BinaryTree root){
        Queue<BinaryTree> queue = new LinkedList<>();

        BinaryTree p = root;
        queue.offer(p);
        while(!queue.isEmpty()){

            p = queue.poll();
            System.out.print(p.data+ " ");
            if(p.lchild != null)
                queue.offer(p.lchild);
            if(p.rchild != null)
                queue.offer(p.rchild);

        }

    }

}
