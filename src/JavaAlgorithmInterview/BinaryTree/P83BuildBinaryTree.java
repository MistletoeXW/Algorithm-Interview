package JavaAlgorithmInterview.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P83BuildBinaryTree
 * @Description: 把一个有序的整数数组放入到二叉树中
 *               将有序的数组放入到二叉树中，所构造出来的二叉树必定也是一棵有序二叉树，即中序遍历序列也是有序的
 *               实现思路为：取数组中间元素作为根结点麻将数组分为左右两个部分
 *                         对数组的两个部分别进行递归的方法构建左右子树
 *               本类中也实现了树的四种遍历,分别有递归和非递归遍历
 * @Author:xuwen
 * @Date: 2020/1/12 下午9:10
 **/
public class P83BuildBinaryTree {

    /*
     * @Author: xw
     * @Description: 将有序的数组放入到二叉树中，使用递归的方法//TODO
     * @Date: 下午9:48 2020/1/12
     * @Param: [ary, start, end]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree ArrayToTree(int[] arr,int start,int end){
        BinaryTree root = null;
        if(end >= start){
            root = new BinaryTree();
            int mid = (start+end+1) / 2;
            //根结点为数组中间的元素
            root.data = arr[mid];
            //递归的用左半部分数组构造左子树
            root.lchild = ArrayToTree(arr,start,mid-1);
            //递归调用右半部分数组构造右子树
            root.rchild = ArrayToTree(arr,mid+1,end);
        }else {
            root = null;
        }
        return root;
    }

    /*
     * @Author: xw
     * @Description: 利用中序遍历的方法对树进行遍历(递归方法)//TODO
     * @Date: 下午10:01 2020/1/12
     * @Param: [root]
     * @Return: void
     **/
    public static void MidOrder_1(BinaryTree root){
        if(root == null) return;
        //遍历root结点的左子树
        if(root.lchild != null)
            MidOrder_1(root.lchild);
        //遍历root结点
        System.out.print(root.data + " ");
        //遍历root结点的有子树
        if(root.rchild != null)
            MidOrder_1(root.rchild);
    }

    /*
     * @Author: xw
     * @Description: 中序遍历对树进行遍历(非递归方法)//TODO
     * @Date: 下午10:06 2020/1/12
     * @Param: [root]
     * @Return: void
     **/
    public static void MidOrder_2(BinaryTree root){
        Stack<BinaryTree> stack = new Stack<>();//创建工作栈
        BinaryTree p = root;
        while(p != null || !stack.empty()){ //栈不空
            if(p!=null){
                stack.push(p);
                p = p.lchild; //往左子树走
            }else {
                p = stack.pop();
                System.out.print(p.data+ " ");
                p = p.rchild;
            }
        }
    }

    /*
     * @Author: xw
     * @Description: 先序遍历树(递归方法)//TODO
     * @Date: 下午6:20 2020/1/13
     * @Param: [root]
     * @Return: void
     **/
    public static void preOrder_1(BinaryTree root){
        if(root == null)
            return;
        //访问当前结点
        System.out.print(root.data + " ");
        //递归遍历结点的左子树
        if(root.lchild != null)
            preOrder_1(root.lchild);
        //递归遍历结点的右子树
        if(root.rchild != null)
            preOrder_1(root.rchild);

    }

    /*
     * @Author: xw
     * @Description: 先序遍历(非递归方法)//TODO
     * @Date: 下午6:28 2020/1/13
     * @Param: [root]
     * @Return: void
     **/
    public static void preOrder_2(BinaryTree root){
        //初始化递归工作栈
        Stack<BinaryTree> stack = new Stack<>();
        BinaryTree p = root;
        while(p != null || !stack.empty()){
            if(p!=null){
               System.out.print(p.data+" ");
               if(p.rchild != null)
                   stack.push(p.rchild);
               p=p.lchild;
            }else {
                p = stack.pop();
            }
        }

    }

    /*
     * @Author: xw
     * @Description: 后序遍历(递归方法)//TODO
     * @Date: 下午6:44 2020/1/13
     * @Param: [root]
     * @Return: void
     **/
    public static void postOrder_1(BinaryTree root){

        if(root == null)
            return;
        //递归遍历左子树
        if(root.lchild != null)
            postOrder_1(root.lchild);
        //递归遍历右子树
        if(root.rchild != null)
            postOrder_1(root.rchild);
        //访问当前结点
        System.out.print(root.data+" ");
    }

    /*
     * @Author: xw
     * @Description: 后序遍历(非递归方法)//TODO
     * @Date: 下午7:01 2020/1/13
     * @Param: [root]
     * @Return: void
     **/
    public static void postOrder_2(BinaryTree root){
        //初始化递归工作栈
        Stack<BinaryTree> stack = new Stack<BinaryTree>();
        if(root == null)
            return;
        BinaryTree p = root;
        BinaryTree r = null;
        while(p!=null || !stack.empty()){
            if(p != null){
                stack.push(p);
                p=p.lchild;
            }else {
                p = stack.peek();
                //如果右孩子存在且没访问过
                if(p.rchild != null && p.rchild != r){
                    p = p.rchild;
                    stack.push(p);
                    p = p.lchild;
                }else {
                    p = stack.pop();
                    System.out.print(p.data + " ");
                    r = p;
                    p = null;
                }
            }
        }
    }


    /*
     * @Author: xw
     * @Description: 层序遍历树//TODO
     * @Date: 下午6:10 2020/1/13
     * @Param: [root]
     * @Return: void
     **/
    public static void LayerOrder(BinaryTree root){
        //初始化一个队列
        Queue<BinaryTree> queue = new LinkedList<BinaryTree>();
        if(root == null)
            return;
        BinaryTree p = root;
        queue.offer(p);
        while (! queue.isEmpty()){
            p=queue.poll();
            System.out.print(p.data + " ");
            //如果这个结点的左子树不为空则加入队列中
            if(p.lchild != null)
                queue.offer(p.lchild);
            //如果这个结点的右子树不为空则加入到队列中
            if(p.rchild != null)
                queue.offer(p.rchild);
        }
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入有序数组:");
        String[] a = sc.nextLine().trim().split(" ");
        sc.close();
        int[] arr = new int[a.length];
        for(int i=0;i<a.length;i++)
            arr[i] = Integer.parseInt(a[i]);
        BinaryTree root = ArrayToTree(arr,0,arr.length-1);
        System.out.print("转换为树后的后序遍历序列为:");
        postOrder_1(root);
        System.out.print("\n转换为树后的后序遍历序列为:");
        postOrder_2(root);
    }

}
