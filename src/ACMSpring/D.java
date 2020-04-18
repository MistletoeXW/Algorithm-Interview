package ACMSpring;

import java.util.Scanner;
import java.util.Vector;

/**
 * @ClassName:D
 * @Description:
 * @Author:xuwen
 * @Date: 2020/4/18 下午4:20
 **/
public class D {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode() {
            this.data = 0;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static TreeNode buildTree(int n){

        TreeNode root = new TreeNode();
        TreeNode p = root;
        int index =1;
        while(index <= n){
            p.left = new TreeNode(0);
            p.right = new TreeNode(1);
            p = p.left;
            index++;
        }
        return root;
    }

    public static void pre(TreeNode root, StringBuilder stringBuilder, Vector<String> strings){
        stringBuilder.append(root.data);
        if(root.left == null && root.right == null){
            strings.add(stringBuilder.toString());
        }

        if(root.left != null){
            pre(root.left,stringBuilder,strings);
        }

        if(root.right != null){
            pre(root.right,stringBuilder,strings);
        }

        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());

    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n < 1 || n> 300)
            return;
        StringBuilder stringBuilder = new StringBuilder();
        Vector<String> strings = new Vector<String>();
        if(n==1){
            System.out.println(1);
            System.out.println(1);
        }else {
            TreeNode root = buildTree(n-1);
            pre(root,stringBuilder,strings);
            System.out.println(strings.size()-1);
            for(int i =strings.size()-1;i>0;i--){
                System.out.println(strings.get(i));
            }
        }

    }


}
