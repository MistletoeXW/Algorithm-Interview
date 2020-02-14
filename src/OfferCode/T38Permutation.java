package OfferCode;

/**
 * @ClassName: T38Permutation
 * @Description: 字符串的全排列: 输入一个字符串，按字典序打印出该字符串中字符的所有排列。例如输入字符串 abc，
 *               则打印出由字符 a, b, c 所能排列出来的所有字符串 abc, acb, bac, bca, cab 和 cba。
 *          思路: 1. 固定一个字母,对其后的字母进行全排列
 *                2. 交换第一个字母和第二个字母,固定第一个字母,对其后的字母进行全排序,结束后交换回字母
 *                3. 交换第一个字母和第三个字母,固定第一个字母,对其后的字母进行全排序,结束后交换回字母
 *                3. 递归下去
 * @Author:xuwen
 * @Date: 2020/2/14 下午1:35
 **/
public class T38Permutation {

    public static void swap(char[] str,int i,int j){
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    public static void Permutation(char[] str,int start){

        if(str==null || start<0)
            return;
        if(start == str.length-1){
            System.out.print(str.toString()+" ");
        }else {

            for(int i=start;i<str.length;i++){
                //交换start和i所在位置
                swap(str,start,i);
                //固定第一个字符,对其后的字母进行递归全排列
                Permutation(str,start+1);
                //还原start与i所在位置的字符
                swap(str,i,start);
            }
        }
    }


}
