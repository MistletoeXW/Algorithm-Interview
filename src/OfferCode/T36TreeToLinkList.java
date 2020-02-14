package OfferCode;

import java.util.LinkedList;

/**
 * @ClassName: T36TreeToLinkList
 * @Description: 将一棵搜索二叉树转化为双向链表
 *          思路: 首先看到是一棵二叉搜索树,则要想到用中序遍历
 *               这里可以想到递归, 先递归根结点的左子树,再将根节点的右孩子指向双向链表的尾结点
 *               再将双向链表的尾结点指向根节点, 再递归右子树
 * @Author:xuwen
 * @Date: 2020/2/14 下午1:19
 **/
public class T36TreeToLinkList {

    private static TreeNode head = null;
    private static TreeNode end = null;

    public static void treeToLinkList(TreeNode root){

        if(root == null)
            return;

        //递归左子树
        treeToLinkList(root.lchild);

        root.rchild = end;
        //如果链表为空则将root设为头结点,如果不为空,则将End的下一指针指向root
        if(end == null)
            head = root;
        else
            end.rchild = root;

        //尾指针跟进
        end = root;

        treeToLinkList(root.rchild);

    }


}
