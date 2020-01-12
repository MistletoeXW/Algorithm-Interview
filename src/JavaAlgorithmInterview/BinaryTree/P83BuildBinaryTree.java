package JavaAlgorithmInterview.BinaryTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P83BuildBinaryTree
 * @Description: 把一个有序的整数数组放入到二叉树中
 *               将有序的数组放入到二叉树中，所构造出来的二叉树必定也是一棵有序二叉树，即中序遍历序列也是有序的
 *               实现思路为：取数组中间元素作为根结点麻将数组分为左右两个部分
 *                         对数组的两个部分别进行递归的方法构建左右子树
 * @Author:xuwen
 * @Date: 2020/1/12 下午9:10
 **/
public class P83BuildBinaryTree {

    /*
     * @Author: xw
     * @Description: 将有序的数组放入到二叉树中，使用递归的方法//TODO
     * @Date: 下午9:48 2020/1/12
     * @Param: [ary, start, end]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree ArrayToTree(int[] arr,int start,int end){
        BinaryTree root = null;
        if(end >= start){
            root = new BinaryTree();
            int mid = (start+end+1) / 2;
            //根结点为数组中间的元素
            root.data = arr[mid];
            //递归的用左半部分数组构造左子树
            root.lchild = ArrayToTree(arr,start,mid-1);
            //递归调用右半部分数组构造右子树
            root.rchild = ArrayToTree(arr,mid+1,end);
        }else {
            root = null;
        }
        return root;
    }

    /*
     * @Author: xw
     * @Description: 利用中序遍历的方法对树进行遍历(递归方法)//TODO
     * @Date: 下午10:01 2020/1/12
     * @Param: [root]
     * @Return: void
     **/
    public static void MidOrder(BinaryTree root){
        if(root == null) return;
        //遍历root结点的左子树
        if(root.lchild != null)
            MidOrder(root.lchild);
        //遍历root结点
        System.out.print(root.data + " ");
        //遍历root结点的有子树
        if(root.rchild != null)
            MidOrder(root.rchild);
    }

    /*
     * @Author: xw
     * @Description: 中序遍历对树进行遍历(非递归方法)//TODO
     * @Date: 下午10:06 2020/1/12
     * @Param: [root]
     * @Return: void
     **/
    public static void MidOrder_1(BinaryTree root){
        Stack<BinaryTree> stack = new Stack<>();//创建工作栈
        BinaryTree p = root;
        while(p != null || !stack.empty()){ //栈不空
            if(p!=null){
                stack.push(p);
                p = p.lchild; //往左子树走
            }else {
                p = stack.pop();
                System.out.print(p.data+ " ");
                p = p.rchild;
            }
        }
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入有序数组:");
        String[] a = sc.nextLine().trim().split(" ");
        sc.close();
        int[] arr = new int[a.length];
        for(int i=0;i<a.length;i++)
            arr[i] = Integer.parseInt(a[i]);
        BinaryTree root = ArrayToTree(arr,0,arr.length-1);
        System.out.print("转换为树后的中序遍历序列为:");
        MidOrder_1(root);
    }

}
