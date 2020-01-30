package JavaAlgorithmInterview.ArrayList;

import java.util.ArrayList;

/**
 * @ClassName:P171GetIntersection
 * @Description: 求两个有序集合的交集,有两个有序的集合,每个集合中的每一个元素都是一段范围,求其交集
 *          例: 集合{[4,8],[9,13]} 和 {[6,12]} 的交集为{[6,8],[9,12]}
 *          方法一暴力法:遍历每一个集合,针对每一个元素判断是否有交集,时间复杂度为O(n^2)
 *          方法二: 特征法,设两个集合为s1和s2, 当前比较的集合为s1[i]与s2[j],可以分为以下几种情况(可在纸上画图理解)
 *              1. s1集合的上界小于s2的下界,此时很明显,s1与s2没有交集
 *              2. s1集合的上界介于s2的上界和下界之间,此时s1与s2有交集(s2的下界~s1的上界)
 *              3. s1集合包含s2,此时s1与s2的交集为s2
 *              4. s2集合包含s1,此时s1与s2的交集为s1
 *              5. s1的下界介于s2的上界与下界之间,此时交集为s1的下界~s2的上界
 *              6. s2的上界小于s1的下界,此时s1与s2没有交集
 *          此方法时间复杂度为O(n1+n2)
 * @Author:xuwen
 * @Date: 2020/1/30 下午4:24
 **/
public class P171GetIntersection {

    //集合类
    static class MySet{
        private int min;
        private int max;

        public MySet(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }
    }

    /*
     * @Author: xw
     * @Description: 求两个集合的交集//TODO
     * @Date: 下午4:42 2020/1/30
     * @Param: [a, b]
     * @Return: java.util.ArrayList<JavaAlgorithmInterview.ArrayList.P171GetIntersection.MySet>
     **/
    public static ArrayList<MySet> getIntersection(ArrayList<MySet> a,ArrayList<MySet> b){

        ArrayList<MySet> result = new ArrayList<MySet>();
        int i=0,j=0;
        while (i<a.size() && j< b.size()){
            MySet s1 = a.get(i);
            MySet s2 = b.get(j);
            if(s1.getMin()<s2.getMin()){ //如果s1的下界小于s2的下界
                if(s1.getMax() < s2.getMin())
                    i++;
                else if(s1.getMax() <= s2.getMax()){
                    result.add(new MySet(s2.getMin(),s1.getMax()));
                    i++;
                }
                else{
                    result.add(new MySet(s2.getMin(),s2.getMax()));
                    j++;
                }
            }
            else if(s1.getMin() <= s2.getMax()){

                if(s1.getMax() <= s2.getMax()){
                    result.add(new MySet(s1.getMin(),s1.getMax()));
                    i++;
                }
                else{
                    result.add(new MySet(s1.getMin(),s2.getMax()));
                    j++;
                }


            }
            else
                j++;

        }

        return result;

    }

    public static void main(String[] args){

        ArrayList<MySet> a = new ArrayList<MySet>();
        ArrayList<MySet> b = new ArrayList<MySet>();
        a.add(new MySet(4,8));
        a.add(new MySet(9,13));

        b.add(new MySet(6,12));
        ArrayList<MySet> result = getIntersection(a,b);
        for(int i=0;i<result.size();i++)
            System.out.print("["+result.get(i).getMin()+","+result.get(i).getMax()+"]"+"\n");

    }



}
