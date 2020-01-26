package JavaAlgorithmInterview.BinaryTree;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P93FindFatherTreeNode
 * @Description: 找出一棵二叉树上任意两个结点最近的共同祖先结点
 *               总共三种解决方法:
 *               方法一:路径对比法
 *                  1. 首先判断node1是否在根节点的子树上,并且在判断的过程中将根节点到该结点的路径加入到路径栈中;对node2同理
 *                  2.将得到的两个路径栈进行遍历,找到第一个相同的结点
 *               方法二:结点编号法
 *                  1.将二叉树看成是一棵完全二叉树对所有结点进行编号
 *                  2.分别求出node1和node2的编号n1和n2,然后没次找出n1和n2中较大的值初以2,直到n1==n2为止
 *                  3.此时n1或者n2的值就是node1和node2的最近公共父节点
 *               方法3:后序遍历法
 *                  1.查找到node1和node2的最近公共父节点可以转化为找到一个结点node,
 *                    使得node1与node2分别位于接点node的左子树或者右子树
 *
 * @Author:xuwen
 * @Date: 2020/1/14 下午5:50
 **/
public class P93FindFatherTreeNode {

   /*
    * @Author: xw
    * @Description: 建立一棵树,使用中序建树的方法//TODO
    * @Date: 下午7:36 2020/1/15
    * @Param: [root, start, end]
    * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
    **/
    public static BinaryTree buildTree(int[] a,int start,int end){
        BinaryTree root = null;
        if(end >= start){
            root = new BinaryTree();
            int mid = (start+end+1) / 2;
            //根结点为数组中间的元素
            root.data = a[mid];
            //递归的用左半部分数组构造左子树
            root.lchild = buildTree(a,start,mid-1);
            //递归调用右半部分数组构造右子树
            root.rchild = buildTree(a,mid+1,end);
        }else {
            root = null;
        }
        return root;
    }


    //===================方法一: 路径对比法=======================
    /*
     * @Author: xw
     * @Description: 获取根节点到当前结点的路径//TODO
     * @Date: 下午6:21 2020/1/15
     * @Param: [root, node, s]  [根结点,当前结点,存放路径的栈]
     * @Return: node在root的子树上或者node==root时返回true,否则返回false
     **/
    public static Boolean getPathFromRoot(BinaryTree root, BinaryTree node, Stack<BinaryTree> s){
        if(root == null)
            return false;
        if(node == root){
            s.push(root);
            return true;
        }
        //如果node结点在root结点的左子树或者右子树上
        //那么root就是node的祖先结点,把他加入到栈中
        if(getPathFromRoot(root.lchild,node,s) || getPathFromRoot(root.rchild,node,s)){
            s.push(root);
            return true;
        }
        return false;
    }

    /*
     * @Author: xw
     * @Description: 查找两个结点最近的公共父节点//TODO
     * @Date: 下午7:22 2020/1/15
     * @Param: [root, node1, node2]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree findParentNode(BinaryTree root,BinaryTree node1,BinaryTree node2){

        Stack<BinaryTree> stack1 = new Stack<BinaryTree>();//保存root到达node1的路径
        Stack<BinaryTree> stack2 = new Stack<BinaryTree>();//保存root到达node2的路径

        //获取从root到达node1的路径
        getPathFromRoot(root,node1,stack1);
        //获取从root到达node2的路径
        getPathFromRoot(root,node2,stack2);
        BinaryTree commonParentNode = null;
        //获取node1与node2最近的父节点,遍历两个栈
        while (stack1.peek() == stack2.peek()){
            commonParentNode = stack1.peek();
            stack1.pop();
            stack2.pop();
        }
        return commonParentNode;
    }

    //===================方法二: 结点编号法=======================
    static class IntRef{   //存储当前编号
        public int num;
    }
    /*
     * @Author: xw
     * @Description: 找出结点在二叉树中的编号//TODO
     * @Date: 下午2:43 2020/1/17
     * @Param: [root, node, number]
     * @Return: boolean: 找到该结点的位置[true] 否则返回[false]
     **/
    public static boolean getNum(BinaryTree root,BinaryTree node,IntRef number){
        if(root == null)
            return false;
        if(root == node)
            return true;
        int tmp = number.num;

        //node结点在root的左子树中,左子树编号为当前编号的2倍
        if(getNum(root.lchild,node,number)){
            number.num = 2*tmp;
            return true;
        }else {
            //node结点在root的右子树中,右子树编号为当前编号的2倍+1
            number.num = tmp*2 + 1;
            return getNum(root.rchild,node,number);
        }
    }

    /*
     * @Author: xw
     * @Description: 根据结点的编号找出相应的结点//TODO
     * @Date: 下午3:00 2020/1/17
     * @Param: [root, number]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree getNodeFromNum(BinaryTree root,int number){
        if(root == null || number<0)
            return null;
        if(number == 1)
            return root;
        //结点编号对应二进制的位数(最高位一定为1,由于根节点代表1)
        int len = (int)(Math.log(number) / Math.log(2));
        //去掉根节点表示的1
        number -= 1<<len;
        for(;len>0;len--){
            //如果这一位二进制的值编号为1,那么编号为number的结点必定在当前结点的右子树上,否则就在左子树上;
            //例如要求找到位置编号为4的点,4的二进制为100,其中第一个1表示root结点,第二位0表示左子树,第3位01表示左子树;
            //要找到编号为5的点,5的二进制我101,其中第一个1表示root根节点,第二位0表示左子树,第3位1表示右子树;
            if((1<<(len-1)&number) == 1)
                root = root.rchild;
            else
                root = root.lchild;

        }
        return root;

    }

    //===================方法三:后序遍历法=======================

    /*
     * @Author: xw
     * @Description: 查找到node1和node2的最近公共父节点可以转化为找到一个结点node,
     *               使得node1与node2分别位于接点node的左子树或者右子树//TODO
     * @Date: 下午3:43 2020/1/17
     * @Param: [root, node1, node2]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree FindParentNode(BinaryTree root,BinaryTree node1,BinaryTree node2){
        if(root == null || root == node1 || root == node2 ){
            return root;
        }
        //后序遍历
        BinaryTree lchild = FindParentNode(root.lchild,node1,node2);
        BinaryTree rchild = FindParentNode(root.rchild,node1,node2);
        //如果root的左子树中没有结点node1和node2,那么一定在root的右子树中
        if(lchild == null)
            return rchild;
        else if(rchild == null)
            return lchild;
        else
            //node1 与node2分别位于root的左子树和右子树上,root就是它们最近的共同父节点
            return root;
    }



    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入一棵树的子树");
        String[] a = sc.nextLine().trim().split(" ");
        int[] tree = new int[a.length];
        for(int i=0;i<a.length;i++){
            tree[i] = Integer.parseInt(a[i]);
        }
        BinaryTree root = buildTree(tree,0,a.length-1); //建立一颗树

        System.out.print("请输入两个结点:");
        String[] b = sc.nextLine().trim().split(" ");
        sc.close();
        int node1_num = Integer.parseInt(b[0]);
        int node2_num = Integer.parseInt(b[1]);

        BinaryTree node1 = root.FindTreeNode(root,node1_num);
        BinaryTree node2 = root.FindTreeNode(root,node2_num);
        //===================方法一: 路径比对法=======================
//        BinaryTree parentNode = findParentNode(root,node1,node2);

        //===================方法二: 结点编号法=======================
//        IntRef ref1 = new IntRef();
//        ref1.num = 1;
//        IntRef ref2 = new IntRef();
//        ref2.num = 1;
//        getNum(root,node1,ref1);
//        getNum(root,node2,ref2);
//        int num1 = ref1.num;
//        int num2 = ref2.num;
//        //找出编号为num1 与 num2 的共同父节点
//        //两者中较大的除以2,直到两者相等
//        while (num1 != num2){
//            if(num1 > num2)
//                num1 /= 2;
//            else
//                num2 /= 2;
//        }
//        //num1就是他们最近的公共父节点的编号,通过编号找到对应的结点
//        BinaryTree parentNode = getNodeFromNum(root,num1);

        //===================方法三:后序遍历法=======================
        BinaryTree parentNode = FindParentNode(root,node1,node2);

        System.out.print(node1_num+ "与"+node2_num+"的最近共同父节点为:"+ parentNode.data+"\n");


    }










}
