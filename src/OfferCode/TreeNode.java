package OfferCode;

import javax.transaction.TransactionRequiredException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @ClassName: TreeNode
 * @Description:
 * @Author:xuwen
 * @Date: 2020/2/2 下午3:42
 **/
public class TreeNode {
    int data;
    TreeNode lchild,rchild;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode() {

    }

    /*
     * @Author: xw
     * @Description: 利用中序遍历,将数组构建成一颗二叉树//TODO
     * @Date: 下午3:12 2020/2/7
     * @Param: [arr]
     * @Return: OfferCode.TreeNode
     **/
    public TreeNode buildBinaryTree(int[] arr,int low,int high){

        if(low <= high){
            int mid = (low+high+1)/2;
            //树的根结点为数组的中间元素
            TreeNode root = new TreeNode(arr[mid]);
            //递归左半部分数组构造左子树
            root.lchild = buildBinaryTree(arr,low,mid-1);
            //递归右半数组构造右子树
            root.rchild = buildBinaryTree(arr,mid+1,high);
            return root;
        }else
            return null;
    }

    //按照数组的顺序建立二叉树
    public TreeNode buildBinaryTreeByArray(Integer[] arr,int index){
        TreeNode root = null;
        if(index < arr.length){
            Integer value = arr[index];
            if(value == null)
                return null;
            root = new TreeNode(value);
            root.lchild = buildBinaryTreeByArray(arr,2*index);
            root.rchild = buildBinaryTreeByArray(arr,2*index+1);
            return root;
        }
        return root;
    }

    //=====================二叉树的几种遍历实现,使用非递归方法===============
    /*
     * @Author: xw
     * @Description: 中序遍历//TODO
     * @Date: 下午4:47 2020/2/2
     * @Param: [root]
     * @Return: void
     **/
    public void inOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        while(p !=null || !stack.empty()){

            if(p!=null){
               stack.push(p);
               p = p.lchild;
            }else {
                p = stack.pop();
                System.out.print(p.data+" ");
                p = p.rchild; //向右子树走
            }
        }
    }

    /*
     * @Author: xw
     * @Description: 先序遍历//TODO
     * @Date: 下午5:01 2020/2/2
     * @Param: [root]
     * @Return: void
     **/
    public void preOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.empty()){
            if(p!=null){
                System.out.print(p.data + " ");
                if(p.rchild != null)
                    stack.push(p.rchild);//如果右子树存在,就将右孩子加入到栈中
                p = p.lchild;//向左走
            }else
                p = stack.pop();//将栈顶元素输出,即输出右子树
        }
    }

    /*
     * @Author: xw
     * @Description: 后序遍历//TODO
     * @Date: 下午5:05 2020/2/2
     * @Param: [root]
     * @Return: void
     **/
    public void postOrder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;
        TreeNode r = null;
        while(p!=null || !stack.empty()){

            if(p!=null){
                stack.push(p);
                p = p.lchild;
            }else {
                p = stack.peek();//取栈顶元素
                //如果右子树存在且没被遍历过
                if(p.rchild!=null && p.rchild!=r){
                    p = p.rchild;//转向右子树
                    stack.push(p);
                    p=p.lchild;//再走到最左边
                }else {
                    p = stack.pop();
                    System.out.print(p.data + " ");
                    r = p; //记录最近访问过的结点
                    p = null;//访问完后重置p指针
                }
            }
        }
    }

    /*
     * @Author: xw
     * @Description: 层序遍历//TODO
     * @Date: 下午5:14 2020/2/2
     * @Param: [root]
     * @Return: void
     **/
    public void floorOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode p = root;
        queue.offer(p);
        while(!queue.isEmpty()){

            p = queue.poll();
            System.out.print(p.data+ " ");
            if(p.lchild != null)
                queue.offer(p.lchild);
            if(p.rchild != null)
                queue.offer(p.rchild);

        }

    }



}
