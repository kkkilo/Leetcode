package leetcode._0004_Median_of_Two_Sorted_Arrays;

import java.util.ArrayList;

public class Median_of_Two_Sorted_Arrays {
    public static void main(String[] args) {
        int[] nums1 = {};
        int[] nums2 = {3,4};
        System.out.println(new Median_of_Two_Sorted_Arrays().findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len1 == 0){
            if(len2 % 2 == 0){
                return (nums2[len2/2]+nums2[len2/2-1])/2.0;
            }else{
                return nums2[len2/2]/1.0;
            }
        }

        if(len2 == 0){
            if(len1 % 2 == 0){
                return (nums1[len1/2]+nums1[len1/2-1])/2.0;
            }else{
                return nums1[len1/2]/1.0;
            }
        }

        int len = len1 + len2;


        ArrayList<Integer> arr = new ArrayList<>(len);
        int i1=0,i2=0;
        int side = nums1[0]>nums2[0]?2:1;
        while(i1<len1 && i2<len2) {
            side = nums1[i1]>nums2[i2]?2:1;
            if(side == 1) {
                arr.add(nums1[i1]);
                i1++;
            }else{
                arr.add(nums2[i2]);
                i2++;
            }
        }
        while (i1<len1){
            arr.add(nums1[i1]);
            i1++;
        }
        while (i2<len2){
            arr.add(nums2[i2]);
            i2++;
        }
        if(len % 2 == 0){
            return (arr.get(len/2)+arr.get(len/2-1))/2.0;
        }else{
            return arr.get(len/2)/1.0;
        }

        //先合并再寻找
    }
}
