package JavaAlgorithmInterview.BinaryTree;

import java.util.Scanner;

/**
 * @ClassName: P108ReverseDNS
 * @Description: 实现反向DNS查找到缓存(本题运用字典树实现)
 *            描述: 反向DNS查找是使用Internet IP地址查找域名.例如,在浏览其器中输入:74.125.200.106就会自动重定向到google
 *            想要实现反向DNS查找缓存,主要需要完成如下的功能:
 *               1. 将IP地址添加到缓存中的URL映射
 *               2. 根据给定IP地址查找对应的URL
 *            解决方案:
 *               方法一: 哈希法--使用Hashmap 来存储IP地址和URL之间的映射关系
 *               方法二: Tire树(字典树)法--在Tire树中存储IP地址,而在最后一个结点中存储对应的域名
 *                      Trie树,是一种树形结构,是一种哈希树的变种。典型应用是用于统计,排序和保存大量的字符串（但不仅限于字符串）,
 *                      所以经常被搜索引擎系统用于文本词频统计.
 *                      它的优点是：利用字符串的公共前缀来减少查询时间,最大限度地减少无谓的字符串比较,查询效率比哈希树高.
 *            两者对比:
 *               1. 使用Tire树,在最坏的情况下时间复杂度为O(1), 而哈希方法在平均情况下时间复杂度为O(1)
 *               2. Tire树可以实现前缀搜索(对于有相同前缀的IP地址,可以寻找所有的URL)
 *               当然,由于树这种数据结构本身的特性,所以使用树结构的最大一个缺点是需要消耗更多的内存,但对于本题来说,这不是一个问题,因为Internet 的IP
 *               地址只包含11个字母(0~9和.)
 * @Author:xuwen
 * @Date: 2020/1/26 下午2:04
 **/
public class P108ReverseDNS {
    //IP地址最多有11个不同的字符
    private final static int CHAR_COUNT=11;

    //Tire树结构
    public static class TireNode{
        boolean isLeaf;
        String url;
        TireNode[] child;

        public TireNode(){
            this.isLeaf = false;
            this.url = null;
            this.child = new TireNode[CHAR_COUNT];
        }

    }

    private TireNode root = new TireNode();

    public static int getIndexFromChar(char c){
        return (c == '.') ? 10:(c-'0');
    }
    public static char getCharFromIndex(int i){
        return (i==10) ? '.':(char)('0'+i);
    }

    /*
     * @Author: xw
     * @Description: 把一个IP地址和相应的url添加到Trie树中,最后一个结点是URL//TODO
     * @Date: 下午2:44 2020/1/26
     * @Param: [ip, url]
     * @Return: void
     **/
    public void insert(String ip, String url){
        //IP地址的长度
        int len = ip.length();
        TireNode pCrawl = root;

        for(int level=0;level<len;level++){
            //根据当前遍历到的ip中的字符,找出子结点的索引
            int index = getIndexFromChar(ip.charAt(level));

            //如果子结点不存在则创建一个
            if(pCrawl.child[index] == null)
                pCrawl.child[index] = new TireNode();

            //移动到子结点
            pCrawl = pCrawl.child[index];
        }

        //在叶结点中存储IP对应的URL
        pCrawl.isLeaf = true;
        pCrawl.url=url;

    }

    /*
     * @Author: xw
     * @Description: 通过Ip地址找到对应的URL//TODO
     * @Date: 下午2:54 2020/1/26
     * @Param: [ip]
     * @Return: java.lang.String
     **/
    public String searchDNSCache(String ip){
        TireNode pCrawl = root;
        int len = ip.length();

        //遍历ip地址中所有的字符
        for(int i=0;i<len;i++){
            int index = getIndexFromChar(ip.charAt(i));
            if(pCrawl.child[index]==null)
                return  null;
            pCrawl = pCrawl.child[index];
        }

        //返回找到的url
        if(pCrawl !=null&&pCrawl.isLeaf)
            return pCrawl.url;
        return null;
    }


    public static void main(String[] args){
        String[] ipAdds = {"100.100.100.001","100.100.100.002","100.100.100.003"};
        String[] url = {"www.001.com","www.002.com","www.003.com"};
        int n = ipAdds.length;
        P108ReverseDNS cache = new P108ReverseDNS();
        //把Ip地址和对应的URL插入到Trie树中
        for(int i=0;i<n;i++)
            cache.insert(ipAdds[i],url[i]);
        System.out.print("请输入查询的ip地址:");
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        sc.close();
        String res_url = cache.searchDNSCache(ip);
        if(res_url != null)
            System.out.print("找到了IP对应的URL:"+res_url);
        else
            System.out.print("没找到对应的URL");

    }

}
