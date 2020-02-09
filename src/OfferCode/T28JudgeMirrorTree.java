package OfferCode;

/**
 * @ClassName: T28JudgeMirrorTree
 * @Description: 判断一颗二叉树是否对称, 如果一颗二叉树左右子树跟他的镜像一样,那么它就是对称的
 *          思路: 可以联想到改造前序遍历的次序
 *              1. 先得到一般先序遍历后的遍历列表(根节点,左子结点,右子结点)
 *              2. 得到改造后先序遍历后的遍历列表(根节点,右子结点,左子结点)
 *              3. 比较两个列表是否相同,相同则对称. 这里要特别注意,空结点也要记录到遍历列表中
 * @Author:xuwen
 * @Date: 2020/2/9 下午1:54
 **/
public class T28JudgeMirrorTree {

    public boolean isMirrorTree(TreeNode root){
        if(root == null)
            return true;
        return isMirrorTree(root.lchild,root.rchild);

    }

    public boolean isMirrorTree(TreeNode t1,TreeNode t2){
        if(t1 == null && t2==null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.data != t2.data)
            return false;
        return isMirrorTree(t1.lchild,t2.rchild) && isMirrorTree(t1.rchild,t2.lchild);

    }


}
