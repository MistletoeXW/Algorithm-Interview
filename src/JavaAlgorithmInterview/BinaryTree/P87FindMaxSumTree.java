package JavaAlgorithmInterview.BinaryTree;

import java.util.Scanner;

/**
 * @ClassName:P87FindMaxSumTree
 * @Description: 求一棵二叉树的最大子树和,并找到对应的结点
 * @Author:xuwen
 * @Date: 2020/1/13 下午9:45
 **/
public class P87FindMaxSumTree {
    private static int maxSum = Integer.MIN_VALUE;

    /*
     * @Author: xw
     * @Description: 求一课二叉树的最大子树和,并找到对应的结点//TODO
     * @Date: 下午9:49 2020/1/13
     * @Param: [root]
     * @Return: int
     **/
    public static int findMaxSumTree(BinaryTree root,BinaryTree maxRoot){

        if(root == null)
            return 0;
        //求root左子树所有结点的和
        int lmax = findMaxSumTree(root.lchild,maxRoot);
        //求root右子树所有结点的和
        int rmax = findMaxSumTree(root.rchild,maxRoot);
        int sum = lmax + rmax + root.data;
        //以root为根的子树的和大于前面所求的最大值
        if(sum > maxSum){
            maxSum = sum;
            maxRoot.data = root.data;
        }
        return sum;//返回以root为根节点的子树所有结点的和
    }

    /*
     * @Author: xw
     * @Description: 将一个数组转化为二叉树,要求中序遍历顺序为数组的顺序//TODO
     * @Date: 下午9:58 2020/1/13
     * @Param: [a]
     * @Return: JavaAlgorithmInterview.BinaryTree.BinaryTree
     **/
    public static BinaryTree buildTree(int[] a,int start,int end){
        int mid = (start+end+1) / 2;
        BinaryTree root = root = new BinaryTree();
        if (start < end) {
            root.data = a[mid];
            root.lchild = buildTree(a,start,mid-1);
            root.rchild = buildTree(a,mid+1,end);
        }else {
            root = null;
        }
        return root;
    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.print("请输入树:");
        String[] arr = sc.nextLine().trim().split(" ");
        int[] a= new int[arr.length];
        for(int i = 0;i < arr.length;i++){
            a[i] = Integer.parseInt(arr[i]);
        }
        BinaryTree root = buildTree(a,0,a.length-1);
        BinaryTree maxRoot = new BinaryTree();
        findMaxSumTree(root,maxRoot);
        System.out.print("最大的子树和为:" + maxSum);
        System.out.print("\n对应的子树根结点为:" + maxRoot.data);

    }







}
