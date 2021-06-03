package leetcode._0034_Find_First_and_Last_Position_of_Element_in_Sorted_Array;

import java.util.Arrays;

public class Find_First_and_Last_Position_of_Element_in_Sorted_Array {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,3,4,4,4,4,5,5,6,6,6,8,10,10};
        int target = 4;
        int[] ints = new Find_First_and_Last_Position_of_Element_in_Sorted_Array().searchRange(nums, target);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return new int[]{-1,-1};
        }
        int resFront=-1;
        int resBack=-1;

        int head = 0;
        int tail = len-1;
        int mid = 0;

        while (head<tail){
            mid = (head+tail)/2;

            if(nums[mid] == target){
                break;
            }

            if(nums[mid]<target){
                head = mid+1;
            } else{
                tail = mid-1;
            }
        }

        if(nums[mid] == target || (head==tail && nums[head] == target)){

            mid = (nums[mid]==target?mid:head);
            resFront=resBack=mid;

            int head1 = 0;
            int tail1 = mid-1;
            if(head1>tail1){
                resFront = 0;
            } else if(head1 == tail1){
                resFront = nums[head1]==target?0:resFront;
            } else{
                int mid1 = 0;
                while (head1<tail1){
                    mid1 = (head1+tail1)/2;

                    if(nums[mid1]<target){
                        head1 = mid1+1;
                    }else{
                        tail1 = mid1-1;
                    }
                }

                if(head1>tail1){
                    if(nums[head1]==target)resFront = head1;
                    else if(nums[tail1] == target)resFront = tail1;
                }else {
                    resFront = nums[head1]==target?head1:head1+1;
                }
            }


            int head2 = mid+1;
            int tail2 = len-1;
            if(head2>tail2){
                resBack = len-1;
            } else if(head2 == tail2){
                resBack = nums[head2]==target?len-1:resBack;
            } else{
                int mid2 = 0;
                while (head2<tail2){
                    mid2 = (head2+tail2)/2;

                    if(nums[mid2]>target){
                        tail2 = mid2-1;
                    }else{
                        head2 = mid2+1;
                    }
                }

                if(head2>tail2){
                    if(nums[head2]==target)resBack = head2;
                    else if(nums[tail2] == target)resBack = tail2;
                }else {
                    resBack = nums[head2]==target?head2:head2-1;
                }
            }
        }

        return new int[]{resFront,resBack};
    }
}
