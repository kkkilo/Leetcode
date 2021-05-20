package leetcode._0011_Container_With_Most_Water;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {{
                int head = 0;
                int tail = height.length-1;
                int res = 0;
                while(head != tail) {
                    int first = height[head];
                    int second = height[tail];
                    int sum = Math.min(height[head],height[tail])*(tail-head);
                    res = res>sum?res:sum;
                    if(height[head]<height[tail]){
                        head++;
                    }else{
                        tail--;
                    }
                }
                return res;
            }
        }
        //双指针从边界向中间收缩
}
