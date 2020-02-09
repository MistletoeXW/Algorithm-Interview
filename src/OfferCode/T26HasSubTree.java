package OfferCode;

/**
 * @ClassName: T26HasSubTree
 * @Description: 输入两棵树A和B,判断B是不是A的子树
 *          思路: 此查找过程分为两步:
 *               1. 遍历A树,找到与B根节点相等的结点,这里使用先序遍历
 *               2. 如果找到与B根节点相等的结点,就进行比较左右子树的判断
 * @Author:xuwen
 * @Date: 2020/2/9 下午1:20
 **/
public class T26HasSubTree {

    //第一步,A进行先序遍历,找到与B根节点相等的结点
    public boolean HasSubTree(TreeNode a,TreeNode b){
        boolean result = false;
        if(a != null && b !=null){
            if(a.data == b.data)
                result = DoesTree1HasTree2(a,b);
            if(!result)
                result = HasSubTree(a.lchild,b);
            if(!result)
                result = HasSubTree(a.rchild,b);
        }
        return result;
    }

    //第二步,判断根节点的左右子树是否相等
    public boolean DoesTree1HasTree2(TreeNode a,TreeNode b){

        if(a == null)
            return false;
        if(b == null)
            return true;
        if(a.data != b.data)
            return false;
        return DoesTree1HasTree2(a.lchild,b.lchild) && DoesTree1HasTree2(a.rchild,b.rchild);

    }

}
