package leetcode._0149_Max_Points_on_a_Line;

import org.junit.Test;

import java.util.*;

public class Max_Points_on_a_line {
    @Test
    public void main() {
        Solution s = new Solution();
        //int arr[][] = {{1,1},{2,2},{3,3}};
        //int arr[][] = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int arr[][] = {{-6,-1},{3,1},{12,3}};
        System.out.println(s.maxPoints(arr));

    }

    class Solution {
        public int maxPoints(int[][] points) {
            int len = points.length;

            HashMap<String, Integer> map = new HashMap<String, Integer>();

            for(int i=0; i<len; i++) {
                for(int j=i+1; j<len; j++) {
                    System.out.println(points[i][0]+" "+points[i][1]+" "+points[j][0]+" "+points[j][1]+" ");
                    String k = null;
                    double kk = 0;
                    String fakeb = null;
                    if((points[i][0]-points[j][0]) != 0) {
                        if((points[i][1] - points[j][1]) == 0){
                            k = "0";
                            kk = 0;
                        } else {
                            kk = 1.0 * (points[i][1] - points[j][1]) / (points[i][0] - points[j][0]);
                            k = String.valueOf(kk);
                        }
                    }else
                        k = "";
                    if(k != "") {
                        if((points[i][1] + points[j][1]) - kk*(points[i][0] + points[j][0])==0){
                            fakeb = "0";
                        }else
                            fakeb = String.valueOf((points[i][1] + points[j][1]) - kk*(points[i][0] + points[j][0]));
                    }else
                        fakeb = String.valueOf(points[i][0]);

                    String key = k + "&" +fakeb;
                    System.out.println(key);
                    if(map.containsKey(key)) {
                        map.replace(key, map.get(key)+1);
                    }else{
                        map.put(key,1);
                    }
                }
            }

            int max = 0;

            Collection<Integer> entries = map.values();
            for (Integer entry :
                    entries) {
                System.out.println(entry);
                max=max>entry?max:entry;
            }

            return (int)Math.floor(Math.sqrt(2*max))+1;
        }
    }
}
