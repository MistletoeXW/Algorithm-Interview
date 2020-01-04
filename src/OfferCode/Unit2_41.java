package OfferCode;

import java.util.ArrayList;

public class Unit2_41 {

    public static int[] FindRangeNumber(int[] A){
        int[] B = new int[A.length];
        for(int i=0,j=0;i<A.length-1;i++){
            int pviot = A[i];
            int low = i+1;
            int high=A.length-1;
            while(low < high){
                int mid = (low+high)/2;
                if(A[mid]<pviot)
                    low=mid+1;
                else if(A[mid]>pviot)
                    high=mid-1;
                else
                    low=mid;
                    break;
            }
            if(A[low]==pviot)
                B[j++] = A[i];
        }
        return B;
    }

    public static void main(String args[]){
        int[] A = {2,3,4,5,3,2,6,7};
        int[] B = FindRangeNumber(A);
        for(int i=0;i<B.length;i++)
            System.out.print(B[i]);
    }
}
