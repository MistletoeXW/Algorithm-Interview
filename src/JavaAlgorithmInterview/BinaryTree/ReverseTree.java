package JavaAlgorithmInterview.BinaryTree;

import javafx.beans.value.ObservableNumberValue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.SimpleTimeZone;

/**
 * @ClassName:ReverseTree
 * @Description: 将二叉树进行左右镜像反转
 *               方法: 遍历二叉树,交换每一个每一个非叶结点的左右子树
 * @Author:xuwen
 * @Date: 2020/1/26 下午1:30
 **/
public class ReverseTree {

    /*
     * @Author: xw
     * @Description: 对二叉树进行左右镜像反转//TODO
     * @Date: 下午1:32 2020/1/26
     * @Param: [root]
     * @Return: void
     **/
    public static void ReverseTree(BinaryTree root){
        if(root == null)
            return;
        //递归遍历左子树和右子树
        ReverseTree(root.lchild);
        ReverseTree(root.rchild);
        //交换左右子树
        BinaryTree tmp = root.lchild;
        root.lchild = root.rchild;
        root.rchild = tmp;
    }

    /*
     * @Author: xw
     * @Description: 通过中序遍历建立二叉树//TODO
     * @Date: 下午1:37 2020/1/26
     * @Param: [arr, start, end]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree buildTree(int arr[],int start,int end){
        BinaryTree root = null;
        if(end >= start){
            root = new BinaryTree();
            //根节点数据为数组的中间结点
            int mid = (start+end+1) / 2;
            root.data = arr[mid];
            //递归遍历根节点的左子树
            root.lchild = buildTree(arr,start,mid-1);
            //递归遍历根节点的右子树
            root.rchild = buildTree(arr,mid+1,end);
        }
        return root;
    }

    /*
     * @Author: xw
     * @Description: 使用层序遍历打印二叉树中各层结点//TODO
     * @Date: 下午1:45 2020/1/26
     * @Param: [root]
     * @Return: void
     **/
    public static void LayPrintTree(BinaryTree root){
        if(root == null)
            return;
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();

        queue.offer(root);

        while (! queue.isEmpty()) {
            BinaryTree p = queue.poll();
            System.out.print(p.data+" ");
            if(p.lchild !=  null)
                queue.offer(p.lchild);
            if(p.rchild != null)
                queue.offer(p.rchild);
        }

    }

    public static void main(String[] args){

        System.out.print("请输入树结点值:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        int[] tree = new int[a.length];
        for(int i=0;i<a.length;i++){
            tree[i] = Integer.parseInt(a[i]);
        }
        BinaryTree root = buildTree(tree,0,a.length-1); //建立一颗树

        System.out.print("输入的二叉树层序遍历结果为:");
        LayPrintTree(root);

        ReverseTree(root);

        System.out.print("\n对二叉树进行左右子树反转后层序遍历结果为:");
        LayPrintTree(root);

    }


}
