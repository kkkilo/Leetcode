package leetcode._0013_Roman_to_Integer;

import java.util.HashMap;

public class Roman_to_Integer {
    public static void main(String[] args) {
        String s = "MCMXCIV";
        System.out.println(new Roman_to_Integer().romanToInt(s));
    }

    public int romanToInt(String s) {
        int len = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        if(len==1){
            return map.get(s.charAt(0));
        }

        int sum = 0;
        int i = 0;
        for ( ; i < len-1; i++) {
            int first = map.get(s.charAt(i));
            int second = map.get(s.charAt(i+1));

            if(first<second){
                sum += (second-first);
                i++;
            }else{
                sum += first;
            }
        }

        if(i == len-1){
            sum += map.get(s.charAt(i));
        }

        return sum;
    }
}
