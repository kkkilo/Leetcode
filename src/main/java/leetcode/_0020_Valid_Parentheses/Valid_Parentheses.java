package leetcode._0020_Valid_Parentheses;

import java.util.HashMap;
import java.util.Stack;

public class Valid_Parentheses {
    public static void main(String[] args) {
        String str = "()";
        System.out.println(new Valid_Parentheses().isValid(str));
    }

    public boolean isValid(String s) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(Integer.valueOf(')'), Integer.valueOf('('));
        map.put(Integer.valueOf(']'), Integer.valueOf('['));
        map.put(Integer.valueOf('}'), Integer.valueOf('{'));


        Stack<Character> stack = new Stack<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            } else {
                if(stack.empty()){
                    return false;
                }else{
                    char top = stack.pop();
                    if(top != map.get(Integer.valueOf(c))){
                        return false;
                    }
                }
            }
        }
        if(stack.empty()){
            return true;
        }else {
            return false;
        }
    }
}
