package ZiJieTioaDong;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: T1
 * @Description: 给定一个二叉树填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *        思路:
 *          方法一: 利用递归
 *          方法二: 使用层序遍历
 *          方法三: 利用深度指针和层指针
 * @Author:xuwen
 * @Date: 2020/2/24 下午4:55
 **/
public class T1 {

    static class  treeNode{
        treeNode left;
        treeNode right;
        treeNode next;
    }

    //====================方法一: 递归==================
    public static void changeTre_1(treeNode root){

        if(root == null)
            return;
        if(root.left != null){

            root.left.next = root.right;
            if(root.next != null) root.right.next = root.next.left;
        }

        changeTre_1(root.left);
        changeTre_1(root.right);
    }

    //=====================方法二: 层序遍历==================
    public static void changeTree_2(treeNode root){

        if (root == null) return;
        Queue<treeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size =queue.size();
            for(int i=0;i<size;i++){
                treeNode p = queue.poll();
                p.next = queue.peek();
                if(p.left!=null) queue.add(p.left);
                if(p.right!=null) queue.add(p.right);
            }

        }
    }

    //======================方法三: 定义一个深度指针和层指针===============
    public static void changeTree_3(treeNode root){

        if(root == null) return;
        treeNode deep = root;//定义一个深度指针进行深度遍历
        treeNode floor = null;//定义一个层指针进行层间的遍历

        while(deep.left != null){

            floor = deep;
            while (floor != null){
                floor.left.next = floor.right;
                if(floor.next != null) floor.right.next = floor.next.left;
                floor = floor.next;
            }
            deep = deep.left;
        }
    }



}
