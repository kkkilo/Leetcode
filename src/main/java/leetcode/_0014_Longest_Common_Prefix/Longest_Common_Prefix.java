package leetcode._0014_Longest_Common_Prefix;

import java.util.Arrays;

public class Longest_Common_Prefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        Arrays.sort(strs);
        int len = strs.length;

        String begin = strs[0];
        String end = strs[len-1];
        int i = 0;
        for ( ; i < begin.length() && i < end.length(); i++) {
            if(begin.charAt(i) != end.charAt(i)) break;
        }

        if(i==0) return "";
        return begin.substring(0, i);
    }
}
