package JavaAlgorithmInterview.ArrayList;

import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;

/**
 * @ClassName:P170FindCommonNum
 * @Description: 给定递增顺序排列的三个数组,找出这三个元素的所有公共元素
 *            方法: 假设三个数组分别为arr1[i], arr2[j], arr3[k].则存在以下几种可能:
 *                 1. 如果arr1[i], arr2[j], arr3[k]相等,则说明当前遍历的元素是三个数组的公有元素
 *                    然后执行i++,j++,k++,使三个数组同时向后移动
 *                 2. 如果arr1[i] < arr2[j],则执行i++来继续遍历arr1后面的元素,因为arr1[i]不可能是三者的共有元素
 *                 3. 如果arr2[j] < arr3[k],同理可以用j++来继续遍历arr2后面的元素
 *                 4. 如果前面的条件都不满足,说明arr1[i] > arr2[j]而且arr2[j] > arr3[k],
 *                    此时可以通过k++来继续遍历arr3后面的元素
 *            时间复杂度: O(n1 + n2 + n3)
 * @Author:xuwen
 * @Date: 2020/1/30 下午1:51
 **/
public class P170FindCommonNum {

    /*
     * @Author: xw
     * @Description: 找出三个数组中公共的元素//TODO
     * @Date: 下午2:16 2020/1/30
     * @Param: [arr1, arr2, arr3]
     * @Return: void
     **/
    public static void findCommonNum(int[] arr1,int[] arr2,int[] arr3){

        int i=0,j=0,k=0; //定义三个遍历的变量
        int len1 = arr1.length;
        int len2 = arr2.length;
        int len3 = arr3.length;
        //遍历三个数组
        while(i<len1 && j<len2 && k<len3){

            if(arr1[i] == arr2[j] && arr2[j] == arr3[k]){//找到了公有元素
                System.out.print(arr1[i]+" ");
                i++;j++;k++;
            }else if(arr1[i] < arr2[j]){ //arr1[i]不可能是公有元素
                i++;
            }else if(arr2[j] < arr3[k]){ //arr2[j]不可能是公有元素
                j++;
            }else { //arr3[k]不可能是公有元素
                k++;
            }
        }
    }

    public static void main(String[] args){
        System.out.print("请输入数组1:");
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().trim().split(" ");
        System.out.print("请输入数组2:");
        String[] b = sc.nextLine().trim().split(" ");
        System.out.print("请输入数组3:");
        String[] c = sc.nextLine().trim().split(" ");
        sc.close();
        int[] arr1 = new int[a.length];
        int[] arr2 = new int[b.length];
        int[] arr3 = new int[c.length];
        for(int i=0;i<a.length;i++){
            arr1[i] = Integer.parseInt(a[i]);
        }
        for(int i=0;i<b.length;i++){
            arr2[i] = Integer.parseInt(b[i]);
        }
        for(int i=0;i<c.length;i++){
            arr3[i] = Integer.parseInt(c[i]);
        }

        System.out.print("三个数组的公共元素为:");
        findCommonNum(arr1,arr2,arr3);
    }



}
