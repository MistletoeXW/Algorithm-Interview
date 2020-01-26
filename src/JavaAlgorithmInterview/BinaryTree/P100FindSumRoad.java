package JavaAlgorithmInterview.BinaryTree;

import java.util.Vector;

/**
 * @ClassName: P100FindSumRoad
 * @Description: 输入一个着整数,找到所有满足路径中结点值之和等于这个整数的路径
 *               解决思路:
 *               1. 对二叉树进行先序遍历,把遍历的路径记录下来
 *               2. 当遍历到叶子结点时,判断当前路径上的所有结点值之和是否等于给定的整数
 *               3. 如果相等则输出路径信息
 * @Author:xuwen
 * @Date: 2020/1/17 下午6:48
 **/
public class P100FindSumRoad {

    /*
     * @Author: xw
     * @Description: 打印出所有满足路径中结点值之和等于这个整数的路径//TODO
     * @Date: 下午1:58 2020/1/18
     * @Param: [root, num, sum, v]: [二叉树根结点,给定的整数,当前路径中结点值之和,用来存储从根节点到当前遍历到结点的路径]
     * @Return: void
     **/
    public static void FindRoad(BinaryTree root, int num, int sum,Vector<Integer> v){

        //记录当前遍历的root结点
        sum += root.data;
        v.add(root.data);
        //当前结点是叶子结点且遍历路径上所有结点的和等于num
        if(root.lchild == null && root.rchild == null && sum==num){
            for(int i=0;i<v.size();i++)
                System.out.print(v.get(i)+ " ");
            System.out.println();
        }
        //遍历左子树
        if(root.lchild!=null)
            FindRoad(root.lchild,num,sum,v);
        //遍历右子树
        if(root.rchild!=null)
            FindRoad(root.rchild,num,sum,v);
        //清除遍历的路径
        sum -= v.get(v.size()-1);
        v.remove(v.size()-1);

    }

    




}
