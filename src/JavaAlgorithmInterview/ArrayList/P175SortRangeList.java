package JavaAlgorithmInterview.ArrayList;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @ClassName: P175SortRangeList
 * @Description: 对有大量重复数字的数组进行高效的排序
 *          方法一: 快排,堆排或者归并排序的方法,这些排序的方法的算法时间复杂度为O(nlogn),但是却没有利用具有大量重复数字的特点
 *          方法二: 平衡二叉树(AVL),根据数组数组中的数构建一个AVL树,这里需要对AVL树做适当扩展,在结点增加一个额外的数据
 *                 域来记录这个数字出现的次数,在AVL树构建完成后,可以对AVL树进行中序遍历,根据每个结点对应数字出现的次数,吧遍历的结果放回数组
 *                 中就完成了排序
 *          方法三: 哈希法,建立一个哈希表,然后遍历数组,把数组中的数字放入到哈希表中,在遍历的过程中,
 *                 如果这个数在哈希表中则直接把哈希表中这个key对应的value加1;
 *                 如果这个数在哈希表中不存在,则直接把这个数添加到哈希表中,并且初始化这个key对应的value为1
 * @Author:xuwen
 * @Date: 2020/1/30 下午5:12
 **/
public class P175SortRangeList {


    //==================================方法二: 平衡二叉树(AVL)===============================
    //AVL树的结点类
    static class Node{

        int data;
        Node left,right;
        int height,count;

        public Node(int data) {
            this.data = data;
            this.left=this.right=null;
            this.height=this.count=1;
        }
    }

    //中序遍历AVL树,将遍历结果放入到数组中
    public static int inOrder(int[] arr, Node root, int index){

        if(root != null){

            //中序遍历左子树
            index = inOrder(arr,root.left,index);
            //把root结点对应的数字根据出现的次数放入到数组中
            for(int i=0;i<root.count;i++){
                arr[index] = root.data;
                index++;
            }
            //中序遍历右子树
            index = inOrder(arr,root.right,index);
        }
        return index;
    }

    //得到树的高度
    private static int getHeight(Node node){
        if(node == null)
            return 0;
        else
            return node.height;
    }

    //把以y为根的子树向右旋转
    private static Node rightRotate(Node y){

        Node x = y.left;
        Node T2 = x.right;
        //旋转
        x.right = y;
        y.left = T2;
        y.height = Integer.max(getHeight(y.left),getHeight(y.right)) +1;
        x.height = Integer.max(getHeight(x.left),getHeight(x.right)) +1;
        //返回新的根节点
        return x;

    }

    //把以x为根的子树向左旋转
    private static Node leftRotate(Node x){

        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = Integer.max(getHeight(x.left),getHeight(x.right))+1;
        y.height = Integer.max(getHeight(y.left),getHeight(y.right))+1;
        return y;
    }

    //获取树的平衡因子
    private static int getBalance(Node N){

        if(N==null)
            return 0;
        return getHeight(N.left) - getHeight(N.right);
    }

    //如果data在AVL树中不存在,则把data插入到AVL树中,否则否则把这个结点对应的count加1即可
    private static Node insert(Node root, int data){

        if(root == null)
            return (new Node(data));
        //data在树中存在,把对应的结点的count+1
        if(data == root.data){
            (root.count)++;
            return root;
        }
        //在左子树中继续查找data是否存在
        if(data<root.data)
            root.left = insert(root.left,data);
        else //否则就在右子树中查找data是否存在
            root.right = insert(root.right,data);
        //插入新的结点后更新root的结点高度
        root.height = Integer.max(getHeight(root.left),getHeight(root.right))+1;
        //获取树的平衡因子
        int balance = getBalance(root);
        //如果树不平衡,会根据以下四种情况进行调整
        //LL型
        if(balance>1 && data<root.left.data)
            return rightRotate(root);
        //RR型
        else if(balance<-1 && data>root.right.data)
            return leftRotate(root);
        //LR型
        else if(balance>1 && data>root.left.data){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        //RL型
        else if(balance<-1 && data<root.right.data){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        return root;

    }

    //使用AVL树实现排序
    public static void sort(int[] arr){

        Node root = null;//根节点
        for(int i=0;i<arr.length;i++){
            root = insert(root,arr[i]);
        }
        int index = 0;
        inOrder(arr,root,index);

    }

    //==================================方法三: 哈希法===============================
    public static void Sort_2(int[] arr){

        Map<Integer,Integer> data_count = new TreeMap<Integer, Integer>();
        for(int i=0;i<arr.length;i++){

            if(data_count.containsKey(arr[i])){
                data_count.put(arr[i],data_count.get(arr[i])+1);
            }else{
                data_count.put(arr[i],1);
            }

        }
        int index = 0;
        //通过Map.entrySet遍历key和value,尤其是容量大时
        for(Map.Entry<Integer,Integer> entry: data_count.entrySet()){

            int key=entry.getKey();
            int value = entry.getValue();
            for(int i=value;i>0;i--)
                arr[index++] = key;

        }


    }





    //==================================主函数===============================
    public static void main(String[] args){

        System.out.print("请输入包含大量重复数字的数组:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        sc.close();
        int[] arr = new int[a.length];
        for(int i=0;i<a.length;i++)
            arr[i] = Integer.parseInt(a[i]);
        //sort(arr);
        Sort_2(arr);
        System.out.print("排序后的结果为:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i] + " ");

    }


}
