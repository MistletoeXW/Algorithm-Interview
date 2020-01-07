package QIAnXin;
import java.util.LinkedList;
import java.util.Scanner;
/*
        二元查找树（1.若左子树不空，左子树值都小于父节点；2.如右子树不空，右子树值都大于父节点；3.左、右子树都是二元查找树；4. 没有键值相等的节点）上任意两个节点的值，请找出它们最近的公共祖先。

        输入三行行，第一行为树层级，第二行为数节点（其中-1表示为空节点），第三行为需要查找祖先的两个数。

        在例图中（虚线框没有真实节点，为了输入方便对应位置输-1）查找12和20的最近公共祖先输入为：
        4
        9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
        12 20


        输出
        输出给出两个数在树上的最近公共祖先数值，如果没有公共祖先，输出-1；如果其中一个节点是另一个节点的祖先，输出这个祖先点（如例图中找15、20最近公共祖先，输出15）；如果输入无效，输出-1。


        样例输入
        4
        9 6 15 2 -1 12 25 -1 -1 -1 -1 -1 -1 20 37
        12 20
        样例输出
        15*/
public class Main{
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int value){
            this.value = value;
        }
    }
    public static TreeNode root;
    public static TreeNode p;
    public static TreeNode q;
    public static TreeNode commonfather;
    public static void main(String[] args) {

        /***********************层次创建二叉树***********************/
        Scanner sc = new Scanner(System.in);
        int depth = sc.nextInt();
        sc.nextLine();
        String[] array1 = sc.nextLine().trim().split(" ");
        int pval = sc.nextInt();
        int qval = sc.nextInt();
        int len = array1.length;
        int[] intlevelarray = new int[len];
        for (int i = 0; i < len; i++) {
            intlevelarray[i] = Integer.valueOf(array1[i]);
        }
        root = level_buildBTree(intlevelarray,-1,pval,qval);
        boolean result = recurseTree(root, p, q);
        if(result && commonfather!=null){
            System.out.println(commonfather.value);
        }else{
            System.out.println(-1);
        }


    }
    /**层次遍历创建二叉树*/
    public static TreeNode level_buildBTree(int[]array,int flag, int pval, int qval){
        int len = array.length;
        //将数组转成list
        LinkedList<TreeNode> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            TreeNode temp = new TreeNode(array[i]);
            if(array[i]==pval){
                p = temp;
            }
            if(array[i]==qval){
                q = temp;
            }
            list.add(temp);
        }
        //开始构建树
        for (int i = 0; i < len/2; i++) {
            list.get(i).left = list.get(2*i+1).value!=flag?list.get(2*i+1):null;
            //记得处理最后一个父节点（len/2-1），因为有可能没有右孩子。
            if(i<len/2-1 ||(i==len/2-1&& len%2!=0)){
                list.get(i).right = list.get(2*i+2).value!=flag?list.get(2*i+2):null;
            }
        }
        return list.get(0);
    }

    /**
     * 二叉树的最近公共祖先
     * @param currNode 当前节点
     * @param p 第一个孩子
     * @param q    第二个孩子
     * @return
     */
    public static boolean recurseTree(TreeNode currNode, TreeNode p, TreeNode q){
        if(currNode == null){
            return false;
        }
        int left = recurseTree(currNode.left, p, q)?1:0;
        int right = recurseTree(currNode.right, p, q)?1:0;
        int mid = (currNode==p || currNode==q)?1:0;
        if(mid+left+right>=2){
            commonfather = currNode;
        }
        return mid+left+right>0;
    }
}
