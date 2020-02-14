package OfferCode;

import java.util.Vector;

/**
 * @ClassName: T34FindRoadSum
 * @Description: 给定一个整数, 在二叉树中找到路径中所有结点的值的和与输入的整数相等的路径
 *          思路: 对二叉树进行先序遍历,把遍历的路径记录下来,当遍历到叶子结点时,
 *               判断当前路径上所有结点的数据和是否等于给定的整数
 *               如果相等则输出路径信息.
 * @Author:xuwen
 * @Date: 2020/2/10 下午4:34
 **/
public class T34FindRoadSum {

    /*
     * @Author: xw
     * @Description: //TODO
     * @Date: 下午4:41 2020/2/10
     * @Param: [root, num, sum, v]
     *         root: 根节点
     *         num: 给定的整数
     *         sum: 当前路径上的和
     *         v: 用
     * @Return: java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
     **/
    public void FindRoadSum(TreeNode root, int num, int sum, Vector<Integer> v){

        //记录当前遍历的root结点
        sum += root.data;
        v.add(root.data);
        //当遍历到叶子结点的时候进行判断
        if(root.lchild==null && root.rchild==null && num==sum){
            for(Integer n:v){
                System.out.print(n + " ");
            }
            System.out.println();
        }
        if(root.lchild != null)
            FindRoadSum(root.lchild,num,sum,v);

        if(root.rchild != null)
            FindRoadSum(root.rchild,num,sum,v);

        //如果不满足则向上回溯回到根节点
        sum -= v.get(v.size()-1);
        v.remove(v.size()-1);

    }



}
