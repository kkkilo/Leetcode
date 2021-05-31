package leetcode._0026_Remove_Duplicates_from_Sorted_Array;

public class Remove_Duplicates_from_Sorted_Array {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int real = 0;
        int pre = -100001;

        for (int i = 0; i < len; i++) {
            if(pre == nums[i]){
                continue;
            } else {
                pre = nums[i];
                nums[real] = nums[i];
                real++;
            }
        }
        return real;
    }
}
