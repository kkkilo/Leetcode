package leetcode._0015_3Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        ArrayList<List<Integer>> arr  = new ArrayList();

        if(len<=2) return arr;


        int prei = -100001;
        for (int i = 0; i < len; i++) {
            if(nums[i]==prei)continue;
            prei = nums[i];
            int prej = -100001;
            for (int j = i+1; j < len; j++) {
                if(nums[j]==prej)continue;
                prej = nums[j];
                if(nums[i]+nums[j]>0)break;
                for (int k = len-1; k > j ; k--) {
                    if(nums[k] + nums[j] + nums[i] == 0){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        arr.add(temp);

                        break;
                    }
                }
            }
        }
        return arr;
    }
}
