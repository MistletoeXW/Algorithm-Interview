package JavaAlgorithmInterview.BinaryTree;

import java.util.Scanner;
import java.util.Stack;

/**
 * @ClassName:P98FindTwoNodeDist
 * @Description: 计算二叉树中两个结点的距离(一个结点到另一个结点的最小边数)
 *               方法: 对于给定的root二叉树,只要能找到两个结点n1和n2的公共父结点(采用路径比对法),
 *               那么就可以通过一下公式计算出两者的距离
 *               Dist(node1,node2) = Dist(root,node1) + Dist(root,node2) - 2*Dist(root,parentNode)
 * @Author:xuwen
 * @Date: 2020/1/17 下午4:36
 **/
public class P98FindTwoNodeDist {

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
     * @Description: 首先得到root到node1和node2的路径栈,然后计算栈中的元素个数表示root到两者的路径长度
     *               其次再得到两个结点的公共父节点//TODO
     * @Date: 下午5:20 2020/1/17
     * @Param: [root, node1, node2]
     * @Return: int
     **/
    public static int findTwoNodeDist(BinaryTree root,BinaryTree node1,BinaryTree node2){
        Stack<BinaryTree> stack1 = new Stack<BinaryTree>();//存放root到node1的结点路径
        Stack<BinaryTree> stack2 = new Stack<BinaryTree>();//存放root到node2的结点路径
        Stack<BinaryTree> stack3 = new Stack<BinaryTree>();//存放root到parent的结点路径

        //获取root到达结点node1的路径
        getPathFromRoot(root,node1,stack1);
        //获取root到达结点node2的路径
        getPathFromRoot(root,node2,stack2);

        //获得root到达node1与node2的路径长度
        int DistRootToNode1 = stack1.size();
        int DistRootToNode2 = stack2.size();

        //首先找到node1 与 node2的最近父结点
        BinaryTree commonParentNode = null;
        //获取node1与node2最近的父节点,遍历两个栈
        while (stack1.peek() == stack2.peek()){
                commonParentNode = stack1.peek();
                stack1.pop();
                stack2.pop();
                if(stack1.empty() || stack2.empty())
                    break;
        }
        //获取root到达parent的路径
        getPathFromRoot(root,commonParentNode,stack3);

        //获得root到达parent的路径长度
        int DistRootToParent = stack3.size();

        //利用公式Dist(node1,node2) = Dist(root,node1) + Dist(root,node2) - 2*Dist(root,parentNode)
        return (DistRootToNode1 + DistRootToNode2 - 2*DistRootToParent);

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

        int dis =  findTwoNodeDist(root,node1,node2);

        System.out.print(node1_num+ "与"+node2_num+"的距离为:"+dis);

    }


}
