package QIAnXin;

import java.util.*;

/**
 * @ClassName:Qianxin_test1
 * @Description: 奇安信编程题一：杀死进程
     * 给定n个进程，这些进程满足以下条件：
     * （1）每个进程有唯一的PID，其中PID为进程ID
     * （2）每个进程最多只有一个父进程，但可能有多个子进程，用PPID表示父进程ID
     * （3）若一个进程没有父进程，则其PPID为0
     * （4）PID, PPID都是无符号整数
     * 结束进程树的含义是当结束一个进程时，它的所有子进程也会被结束，包括子进程的子进程。
     * 现在给定大小为n的两组输入列表A和B（1 <= n <= 100），列表A表示进程的PID列表，列表B表示列表A对应的父进程的列表，即PPID列表。
     * 若再给定一个PID，请输出结束该PID的进程树时总共结束的进程数量
 * 输入
 * 3 1 5 21 10
 * 0 3 3 1 5
 * 5
 * 输出
 * 2
 *
 * 样例输入
 * 3 1 5 21 10
 * 0 3 3 1 5
 * 3
 *
 * 样例输出
 * 5
 * @Author:xuwen
 * @Date: 2020/1/6 下午6:43
 **/

/*
 * 解决方案： 1. 首先建立进程树
 *          2. 再用广度优先或者深度优先
 **/

public class Qianxin_test1 {
    /*
     * @Author: xw
     * @Description: 建立进程树，使用Map记录结点及该结点的子结点//TODO
     * @Date: 下午4:10 2020/1/7
     * @Param: [pId, ppId]
     * @Return: java.util.Map<java.lang.Integer,java.util.List<java.lang.Integer>>
     **/
    public static Map<Integer, List<Integer>> BuildProcessTree(List<Integer> pId,List<Integer> ppId){
        Map<Integer,List<Integer>> processTree = new HashMap<>();//使用Map来解决记录进程树的信息，key值为父节点，value为该结点对应的子结点
        Iterator<Integer> pID = pId.iterator(); //将pId的List放入迭代器
        Iterator<Integer> ppID = ppId.iterator();//将ppId的List放入迭代器

        while(pID.hasNext() && ppID.hasNext()){
            int p = pID.next();
            int pp = ppID.next();

            if(!processTree.containsKey(pp)){
                processTree.put(pp, new LinkedList<>()); //如果父进程ppID在Map中找不到key值，则为其创建一个子进程List，由于是链结构，所以这里用了LinkList
            }

            processTree.get(pp).add(p);//将父进程的子进程加入到其子进程List中
        }
        return processTree;

    }

    /*
     * @Author: xw
     * @Description: 方法一：使用广度优先算法遍历进程树//TODO
     * @Date: 下午8:34 2020/1/7
     * @Param: [killprocess]
     * @Return: java.util.List<java.lang.Integer>
     **/
    public static List<Integer> killProcess(Map<Integer,List<Integer>> processTree,int killprocess){
        List<Integer> resultList = new LinkedList<>(); //存储结束的进程
        Queue<Integer> processQueue = new LinkedList<>();
        processQueue.add(killprocess);//将要结束的进程加入队列

        while(!processQueue.isEmpty()){ //只要队列不为空就循环
            int kill = processQueue.remove(); //出队加入到结果列表，表示结束进程
            resultList.add(kill);

            if(processTree.containsKey(kill)){ //如果kill的值存在与进程数的key值中，则将其所有子进程加入到队列
                processQueue.addAll(processTree.get(kill));//将其所有子进程加入到队列
            }
        }
        return resultList;

    }

    /*
     * @Author: xw
     * @Description: 方法二：使用深度优先算法进行遍历进程树，这里使用递归//TODO
     * @Date: 下午8:55 2020/1/7
     * @Param: [processTree, target, result]
     * @Return: void
     **/
    public static void kill(Map<Integer, List<Integer>> processTree, int killprocess, List<Integer> result){
        result.add(killprocess);
        if(! processTree.containsKey(killprocess)){
            return;

        }
        for(int child : processTree.get(killprocess)){
            kill(processTree,child,result); //递归遍历每一个子节点
        }
    }
    public static List<Integer> killProcess2(Map<Integer, List<Integer>> processTree,int killprocess){
        List<Integer> result = new LinkedList<>();
        kill(processTree,killprocess,result);
        return result;
    }

    public static void main(String[] args){
        List<Integer> pid = new LinkedList<>();
        List<Integer> ppid = new LinkedList<>();

        //控制台输入两数组
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入数组1：");
        String[] a = sc.nextLine().trim().split(" ");
        System.out.print("请输入数组2：");
        String[] b = sc.nextLine().trim().split(" ");
        System.out.print("请输入要结束的进程：");
        int killprocess = sc.nextInt();
        sc.close(); //结束控制台输入
        for(int i=0;i<a.length;i++){
            pid.add(Integer.parseInt(a[i]));
        }
        for(int i=0;i<b.length;i++){
            ppid.add(Integer.parseInt(b[i]));
        }

        //建立进程树
        Map<Integer,List<Integer>> processTree = new HashMap<>();
        processTree = BuildProcessTree(pid,ppid);

        //使用方法一
        List<Integer> result = killProcess(processTree,killprocess);
        System.out.print("使用广度优先算法得到结束的进程数为："+result.size()+'\n');

        //使用方法二
        List<Integer> result2 = killProcess2(processTree,killprocess);
        System.out.print("使用深度优先算法得到结束的进程数为："+result2.size());



    }










}
