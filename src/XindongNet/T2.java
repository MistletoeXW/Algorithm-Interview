package XindongNet;

import org.omg.CORBA.DATA_CONVERSION;

/**
 * @ClassName: T2
 * @Description: 求出某结点的左右子树的最大差值
 * @Author:xuwen
 * @Date: 2020/2/28 下午3:11
 **/
public class T2 {

    //按照数组输入顺序构造树
    public static TreeNode buildTreeByArray(int[] array,int index){
        TreeNode root = null;
        if(array == null)
            return null;
        int len = array.length;
        if(index < len){
            int data = array[index];
            root.data = data;
            root.lchild = buildTreeByArray(array,2*index);
            root.rchild = buildTreeByArray(array,2*index+1);
            return root;
        }
        return root;
    }
    private static int maxSub = Integer.MIN_VALUE;
    //使用后序遍历的方法,求出左右子树的最大差值
    public static int findMaxSubTree(TreeNode root,TreeNode maxSubTree){

        if(root == null)
            return 0;
        //求出左子树的价值
        int lvalue = findMaxSubTree(root.lchild,maxSubTree);
        //求出右子树的价值
        int rvalue = findMaxSubTree(root.rchild,maxSubTree);
        int sum = lvalue + rvalue + root.data;
        int sub = Math.abs(lvalue-rvalue);
        if(sub > maxSub){
            maxSub = sub;
            maxSubTree = root;
        }
        return sum;
    }




}
