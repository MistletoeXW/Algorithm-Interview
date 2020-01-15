package JavaAlgorithmInterview.BinaryTree;

import sun.awt.Symbol;

import java.beans.BeanInfo;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P93FindFatherTreeNode
 * @Description: 找出一棵二叉树上任意两个结点最近的共同祖先结点
 *               总共三种解决方法:
 *               方法一:路径对比法
 * @Author:xuwen
 * @Date: 2020/1/14 下午5:50
 **/
public class P93FindFatherTreeNode {

   /*
    * @Author: xw
    * @Description: 建立一棵树,使用中序建树的方法//TODO
    * @Date: 下午7:36 2020/1/15
    * @Param: [root, start, end]
    * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
    **/
    public static BinaryTree buildTree(int[] a,int start,int end){
        BinaryTree root = null;
        if(end >= start){
            root = new BinaryTree();
            int mid = (start+end+1) / 2;
            //根结点为数组中间的元素
            root.data = a[mid];
            //递归的用左半部分数组构造左子树
            root.lchild = buildTree(a,start,mid-1);
            //递归调用右半部分数组构造右子树
            root.rchild = buildTree(a,mid+1,end);
        }else {
            root = null;
        }
        return root;

    }


    //===================方法一: 路径对比法=======================
    /*
     * @Author: xw
     * @Description: 获取根节点到当前结点的路径//TODO
     * @Date: 下午6:21 2020/1/15
     * @Param: [root, node, s]  [根结点,当前结点,存放路径的栈]
     * @Return: node在root的子树上或者node==root时返回true,否则返回false
     **/
    public static Boolean getPathFromRoot(BinaryTree root, BinaryTree node, Stack<BinaryTree> s){
        if(root == null)
            return false;
        if(node == root){
            s.push(root);
            return true;
        }
        //如果node结点在root结点的左子树或者右子树上
        //那么root就是node的祖先结点,把他加入到栈中
        if(getPathFromRoot(root.lchild,node,s) || getPathFromRoot(root.rchild,node,s)){
            s.push(root);
            return true;
        }

        return false;
    }

    /*
     * @Author: xw
     * @Description: 查找两个结点最近的公共父节点//TODO
     * @Date: 下午7:22 2020/1/15
     * @Param: [root, node1, node2]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree findParentNode(BinaryTree root,BinaryTree node1,BinaryTree node2){

        Stack<BinaryTree> stack1 = new Stack<BinaryTree>();//保存root到达node1的路径
        Stack<BinaryTree> stack2 = new Stack<BinaryTree>();//保存root到达node2的路径

        //获取从root到达node1的路径
        getPathFromRoot(root,node1,stack1);
        //获取从root到达node2的路径
        getPathFromRoot(root,node2,stack2);
        BinaryTree commonParentNode = null;
        //获取node1与node2最近的父节点,遍历两个栈
        while (stack1.peek() == stack2.peek()){
            commonParentNode = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return commonParentNode;
    }



    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一棵树的子树");
        String[] a = sc.nextLine().trim().split(" ");
        int[] tree = new int[a.length];
        for(int i=0;i<a.length;i++){
            tree[i] = Integer.parseInt(a[i]);
        }
        BinaryTree root = buildTree(tree,0,a.length-1); //建立一颗树

        System.out.print("请输入两个结点:");
        String[] b = sc.nextLine().trim().split(" ");
        sc.close();
        int node1_num = Integer.parseInt(b[0]);
        int node2_num = Integer.parseInt(b[1]);
        BinaryTree node1 = root.FindTreeNode(root,node1_num);
        BinaryTree node2 = root.FindTreeNode(root,node2_num);

        BinaryTree parentNode = findParentNode(root,node1,node2);
        System.out.print(node1_num+ "与"+node2_num+"的最近共同父节点为:"+ parentNode.data);




    }










}
