package OfferCode;

/**
 * @ClassName: T27MirrorTree
 * @Description: 求树的镜像,输入一个二叉树,输出它的镜像
 *          思路: 求树的镜像,通过画可以得出就是将树的所有结点的左右子树进行反转
 *               通过对树进行先序遍历,如果遍历到结点有子节点,则交换他们的两个子节点,当交换完所有结点后,就得到了镜像
 * @Author:xuwen
 * @Date: 2020/2/9 下午1:45
 **/
public class T27MirrorTree {

    //交换左右子节点
    public void swap(TreeNode root){
        TreeNode treeNode = root.lchild;
        root.lchild = root.rchild;
        root.rchild = treeNode;
    }

    public void MirrorTree(TreeNode root){

        if(root == null)
            return;
        swap(root);
        MirrorTree(root.lchild);
        MirrorTree(root.rchild);
    }


}
