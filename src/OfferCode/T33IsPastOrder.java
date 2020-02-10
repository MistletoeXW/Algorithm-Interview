package OfferCode;

/**
 * @ClassName: T33IsPastOrder
 * @Description: 输入一个数组,判断该数组是否是一棵二叉搜索树的后序遍历序列
 *
 *         思路: 1. 首先要知道二叉搜索树的特点: 对于任意一个结点,它的左子树上所有结点的值都小于这个结点的值
 *                 它右子树上所有结点的值都大于这个结点的值
 *              2. 根据二叉搜索树的特点和后续遍历特点, 首先找出数组中最后一个元素,为本二叉树的根结点
 *                 此时可以根据这一点将数组分为两部分,比此值小的为根节点的左子树,比根节点值大的为根节点的右子树
 *              3. 再用递归的方法递归左右子树
 * @Author:xuwen
 * @Date: 2020/2/10 下午3:49
 **/
public class T33IsPastOrder {

    public boolean IsAfterOrder(int[] arr,int start,int end){

        if(arr == null)
            return false;

        //数组的最后一个元素一定为根节点
        int root = arr[end];
        int i,j;
        //找到第一个大于root的值,那么前面所有结点都位于root左子树上
        for(i=start;i<end;i++){
            if(arr[i] > root)
                break;
        }

        //如果序列是后续遍历的序列,那么从i,开始的所有值都应该大于根结点root的值
        for(j=i;j<end;j++){
            if(arr[j] < root)
                return false;
        }

        boolean left_IsAfterOrder = true;
        boolean right_IsAfterOrder = true;

        //递归判断小于root的值的序列是不是满足二叉搜索树的后续遍历序列
        if(i > start)
            left_IsAfterOrder = IsAfterOrder(arr,start,i-1);

        //递归判断大于root的值的序列是不是满足二叉搜索树的后续遍历序列
        if(j<end)
            right_IsAfterOrder = IsAfterOrder(arr,i,end);

        return (left_IsAfterOrder && right_IsAfterOrder);

    }


}
