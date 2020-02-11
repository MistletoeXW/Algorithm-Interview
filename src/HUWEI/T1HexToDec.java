package HUWEI;

/**
 * @ClassName: T1HexToDec
 * @Description: 进制转换,接受一个十六进制数值的字符串,输出该数值的十进制字符串
 *          输入例子: 0xA
 *          输出例子: 10
 *
 *        思路: 首先先区分各进制
 *             1. 2进制(Bin): 只有0和1
 *             2. 8进制(OCT): 以o开头,0~7组成. 例如: o123
 *             3. 10进制(Dec): 由0~9组成
 *             4. 16进制(Hex): 以ox开头,0~9或者a~f组成, 例如:ox12c
 *        具体步骤: 1. 获取输入字符串及其长度
 *                 2. 获得对应字符的十进制数字
 *                 3. 计算得到输入十六进制数字对应的十进制数字
 * @Author:xuwen
 * @Date: 2020/2/11 下午2:37
 **/
public class T1HexToDec {

    //将十六进制转化为十进制
    public static int HexToDec(String hex){

        String str = "012345678910ABCDEF";
        int dec =0;
        for(int i=0;i<hex.length();i++){

            for(int j=0;j<hex.length();j++){
                //计算得到十进制数
                if(hex.charAt(i) == str.charAt(j))
                    dec = dec + (int)(j*Math.pow(16,hex.length()-1-i));
            }
        }

        return dec;

    }





}
