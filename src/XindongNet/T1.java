package XindongNet;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @ClassName: T1
 * @Description: 按照给定的字符顺序进比较字符串,对字符串进行排序
 *          思路: 将给定的字符顺序放入到一个字典序中,按照字符的顺序进行编号
 *                对字符串进行依次比较
 * @Author:xuwen
 * @Date: 2020/2/28 下午2:01
 **/
public class T1 {

    //根据给定的字符顺序进行字符串比较
    public static int compare(String str1, String str2, HashMap<Character,Integer> charInt){
        int len1 = str1.length();
        int len2 = str2.length();
        int i=0,j=0;
        while(i<len1 && j<len2){
            //如果字符不在给定的字符序列中,就将值赋为-1
            if(!charInt.containsKey(str1.charAt(i)))
                charInt.put(str1.charAt(i),-1);
            if(!charInt.containsKey(str2.charAt(j)))
                charInt.put(str2.charAt(j),-1);
            //比较个字符串的大小
            if(charInt.get(str1.charAt(i)) < charInt.get(str2.charAt(j)))
                return -1;
            else if(charInt.get(str1.charAt(i)) < charInt.get(str2.charAt(j)))
                return 1;
            else{
                i++;
                j++;
            }
        }
        //两个字符串都依次比较结束长度相同,则这两个字符串排序位置相同
        if(i==len1 && j==len2){
            return 0;
        }else if( i == len1){
            return -1;
        }else {
            return 1;
        }
    }

    //对字符串数组进行排序
    public static void insertSort(String[] s,HashMap<Character,Integer> charInt){

        int i,j;
        int len = s.length;
        String temp;
        //这里运用插入排序
        for(i=1;i<len;i++){
            temp = s[i];//记录当前遍历的值
            for(j=i-1;j>=0;j--){
                if(compare(temp,s[j],charInt) == -1)
                    s[j+1] = s[j]; //向后移动位置
                else
                    break; //找到位置后退出
            }
            s[j+1] = temp;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //读取第一行字符序列
        String charList = br.readLine();
        //读取第二行字符数组
        String[] strList = br.readLine().trim().split(" ");
        HashMap<Character,Integer> charInt = new HashMap<Character, Integer>();
        for(int i=0;i<charList.length();i++){
            charInt.put(charList.charAt(i),i);
        }

        insertSort(strList,charInt);
        for(int i=0;i<strList.length;i++){
            System.out.println(strList[i]);
        }


    }

}
