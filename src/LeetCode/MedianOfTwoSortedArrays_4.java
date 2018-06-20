package LeetCode;

public class MedianOfTwoSortedArrays_4 {

    public static void quickSort(int[] a) {
        if(a.length>0) {
            quickSort(a, 0 , a.length-1);
        }
    }

    private static void quickSort(int[] a, int low, int high) {
        //1,找到递归算法的出口
        if( low > high) {
            return;
        }
        //2, 存
        int i = low;
        int j = high;
        //3,key
        int key = a[ low ];
        //4，完成一趟排序
        while( i< j) {
            //4.1 ，从右往左找到第一个小于key的数
            while(i<j && a[j] > key){
                j--;
            }
            // 4.2 从左往右找到第一个大于key的数
            while( i<j && a[i] <= key) {
                i++;
            }
            //4.3 交换
            if(i<j) {
                int p = a[i];
                a[i] = a[j];
                a[j] = p;
            }
        }
        // 4.4，调整key的位置
        int p = a[i];
        a[i] = a[low];
        a[low] = p;
        //5, 对key左边的数快排
        quickSort(a, low, i-1 );
        //6, 对key右边的数快排
        quickSort(a, i+1, high);
    }

    public double findMedianSortedArrays(int [] num1,int [] num2){
        int m = num1.length;
        int n = num2.length;
        int[] num3 = new int[n+m];
        System.arraycopy(num1,0,num3,0,m);
        System.arraycopy(num2,0,num3,m,n);
        quickSort(num3);
        if((n+m)%2==0){
           return (double)(num3[num3.length/2]+num3[num3.length/2 - 1])/2;
        }
        else{
            return (double)num3[num3.length/2];
        }

    }

    public static void main(String args[]){
        int [] num1 = new int[]{1,3};
        int [] num2 = new int[]{2};
        MedianOfTwoSortedArrays_4 medianOfTwoSortedArrays_4 = new MedianOfTwoSortedArrays_4();
        System.out.println(medianOfTwoSortedArrays_4.findMedianSortedArrays(num1,num2));
    }

}
