package leetcode._0001_TwoSum;

import java.util.Arrays;

public class Two_Sum {
    public static void main(String[] args) {
        int arr[] = {2,3,11,7};
        int target = 9;
        int res[] = new Two_Sum().twoSum(arr, target);
        System.out.println(res[0] + " " + res[1]);
    }

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int ano = target - first;
            for (int j = i+1; j<nums.length; j++) {
                if(nums[j]==ano){
                    int[] res = new int[]{i,j};
                    return res;
                }

            }
        }
        return nums;

        //map存储所有的值，遍历的时候再找想要的对象
    }
}
