package leetcode._0003_Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        Queue<Character> queue = new LinkedList<Character>();

        int strlen = s.length();
        int maxlen = 0;
        int res = 0;
        for (int i = 0; i < strlen; i++) {
            char c = s.charAt(i);

            if(set.contains(c)){
                char cc;
                while((cc = queue.peek()) != c){
                    queue.poll();
                    set.remove(cc);
                    maxlen--;
                }
                queue.poll();
                queue.offer(cc);
            } else {
                set.add(c);
                queue.offer(c);
                maxlen++;
                res = res>maxlen?res:maxlen;
            }
        }
        return res;
    }

    //set存储重复，其实可以不用queue，因为字符串本身就并排序成队列样子，所以只需要存储开始节点处即可。
    //或者用map存储，value为下标的下一位，map不用剔除，可以用start与map的进行比较，麻烦是map每次循环都得比较更新。
}
