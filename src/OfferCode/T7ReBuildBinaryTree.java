package OfferCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @ClassName: T7ReBuildBinaryTree
 * @Description: 重建二叉树,输入某二叉树的前序和中序遍历的结果,重建该二叉树.
 *               假设输入的前序遍历和中序遍历结果不含有重复的数字
 *        解决思路: 前序遍历的第一个值为根节点的值,使用这个值将中序遍历结果分成两部分,左部分为树的左子树
 *                 中序遍历的结果,右部分为树的右子树中序遍历结果.然后分别对左右子树递归
 * @Author:xuwen
 * @Date: 2020/2/2 下午3:43
 **/
public class T7ReBuildBinaryTree {

    //缓存中序遍历数组每个值对应的索引
    private static Map<Integer,Integer> indexForInOrders = new HashMap<>();

    /*
     * @Author: xw
     * @Description: 运用递归,先根据先序遍历结果找到根节点,再在中序遍历的缓存中找到根节点的位置
     *               将中序遍历分为左子树和右子树两部分,再进行递归//TODO
     * @Date: 下午4:27 2020/2/2
     * @Param: [pre, preL, preR, inL] [先序遍历数组, 先序遍历头部,先序遍历尾部,中序遍历头部]
     * @Return: OfferCode.TreeNode
     **/
    public static TreeNode reBuildBinaryTree(int[] pre,int preL,int preR,int inL){

        if(preL > preR)
            return null;
        //将先序遍历头部加入到根节点
        TreeNode root = new TreeNode(pre[preL]);
        //得到中序遍历结果中根节点对应的位置
        int inIndex = indexForInOrders.get(root.data);
        //得到根节点在中序遍历中的位置后,减去中序遍历头部等于根节点左子树的结点数
        int leftTreeSize = inIndex - inL;
        //递归左子树,传入参数为:[先序遍历数组,先序遍历中下一个元素,根节点后连续leftTreeSize都是左子树,中序遍历头部]
        root.lchild = reBuildBinaryTree(pre,preL+1,preL+leftTreeSize,inL);
        //递归右子树,传入参数为:[先序遍历数组,根节点后连续leftTreeSize都是左子树加上1即为右子树的头部,右子树尾部,中序遍历头部+左子树的个数即为中序右子树的头部]
        root.rchild = reBuildBinaryTree(pre,preL+leftTreeSize+1,preR,inL+ leftTreeSize+1);
        return root;
    }

    /*
     * @Author: xw
     * @Description: //TODO
     * @Date: 下午4:28 2020/2/2
     * @Param: [pre, in][先序遍历数组,中序遍历数组]
     * @Return: OfferCode.TreeNode
     **/
    public static TreeNode reBuildBinaryTree(int[] pre,int[] in){

        //将中序遍历结果加入到缓存的字典中
        for(int i=0;i<in.length;i++)
            indexForInOrders.put(in[i],i);
        return reBuildBinaryTree(pre,0,pre.length-1,0);

    }


    public static void main(String[] args){

        System.out.print("请输入先序遍历结果: ");
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] pre = new int[s.length];
        for(int i=0;i<s.length;i++)
            pre[i] = Integer.parseInt(s[i]);
        System.out.print("请输入中序遍历结果: ");
        String[] s1 = sc.nextLine().trim().split(" ");
        int[] in = new int[s1.length];
        for(int i=0;i<s1.length;i++)
            in[i] = Integer.parseInt(s1[i]);
        sc.close();

        System.out.print("根据中序遍历和先序遍历创建二叉树!");

        TreeNode root = reBuildBinaryTree(pre,in);

        System.out.print("\n二叉树的先序遍历结果为: ");
        root.preOrder(root);

        System.out.print("\n二叉树的中序遍历结果为: ");
        root.inOrder(root);

        System.out.print("\n二叉树的后序遍历结果为: ");
        root.postOrder(root);

        System.out.print("\n二叉树的层序遍历结果为: ");
        root.floorOrder(root);


    }


}
