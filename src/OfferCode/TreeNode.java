package OfferCode;

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