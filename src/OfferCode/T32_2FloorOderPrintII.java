package OfferCode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName: T32_2FloorOderPrintII
 * @Description: 要求按"之"字型顺序打印二叉树, 即第一行按照从左到右,第二行按照从右向左,以此类推
 *          思路:
 *          方法一: 按"之"字打印二叉树需要两个栈.
     *               1. 在打印某一层结点时,把下一层相应的子结点保存到相应的栈里
     *               2. 如果当前打印的是奇数层(第一层,第三层等),则先保存左子结点再保存右子结点到栈1中
     *               3. 如果当前打印的是偶数层(第二层,第四层等),则先保存右子结点再保存左子结点到栈2中
     *             这里可能会疑惑,为什么需要两个栈?可以通过实例验证就会发现达不到预期的效果
 *
 *          方法二: 如何不想开两个栈空间,可以改造上一题的代码,把各层元素放入一个list中,再把各层的LIst放入一个总的list,
 *                 只是打印的时候偶数层要反转打印list
 *
 * @Author:xuwen
 * @Date: 2020/2/10 下午2:19
 **/
public class T32_2FloorOderPrintII {

    /*
     * @Author: xw
     * @Description: 方法一使用两个栈进行打印//TODO
     * @Date: 下午2:51 2020/2/10
     * @Param: [root]
     * @Return: void
     **/
    public ArrayList<ArrayList<Integer>> Print_1(TreeNode root){

        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if(root == null)
            return arrayLists;

        //初始化两个栈
        Stack<TreeNode> stack1 = new Stack<>();//暂存奇数层结点
        Stack<TreeNode> stack2 = new Stack<>();//暂存偶数层结点

        //初始层为第一层
        int level = 1;
        //初始层为第一层
        stack1.push(root);

        while (!stack1.isEmpty() || !stack2.isEmpty()){
            //保存该层中栈的元素
            ArrayList<Integer> arrayList = new ArrayList<>();
            //判断是哪一个栈进行操作
            if(level % 2 == 1){

                //当奇数层执行出栈操作时
                //如果stack1还存在元素,则继续出栈
                while(!stack1.isEmpty()){
                    TreeNode node = stack1.pop();
                    //在出栈的同时,将此结点的左右子节点入stack2
                    //同时存入另一个栈的顺序是先存在左子结点,再存右子结点
                    arrayList.add(node.data);
                    if(node.lchild != null) stack2.push(node.lchild);
                    if(node.rchild != null) stack2.push(node.rchild);
                }

                //层数+1
                level++;

                //stack1中所有元素出栈完毕后,将奇数层次的所有元素加入到整个线性表中
                arrayLists.add(arrayList);

            }else {

                //当偶数层执行出栈操作时
                //如果stack2还村元素,则继续出栈
                while (!stack2.isEmpty()){
                    TreeNode node = stack2.pop();
                    //出栈同时加入到奇数层次的数组中
                    arrayList.add(node.data);
                    //在出栈的同时,将此结点的左右子结点加入stack1中
                    //存入stack1的顺序为先存右子结点,再存左子结点
                    if(node.rchild != null) stack1.push(node.rchild);
                    if(node.lchild != null) stack1.push(node.lchild);
                }

                level++;

                arrayLists.add(arrayList);

            }
        }

        return arrayLists;

    }


}
