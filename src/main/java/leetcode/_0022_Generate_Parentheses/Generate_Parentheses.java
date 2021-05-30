package leetcode._0022_Generate_Parentheses;

import java.util.ArrayList;
import java.util.List;

public class Generate_Parentheses {
    public ArrayList<String> arr = new ArrayList<>();

    public static void main(String[] args) {
        Generate_Parentheses g = new Generate_Parentheses();
        int n = 1;
        g.generateParenthesis(n);
        for (int i = 0; i < g.arr.size(); i++) {
            System.out.println(g.arr.get(i));
        }
    }

    public List<String> generateParenthesis(int n) {
        int leftn = n;
        int rightn = 0;
        String str = "";

        fun(leftn, rightn, str);
        return arr;
    }

    void fun(int leftn, int rightn, String str) {
        if(leftn == 0 && rightn == 0) {
            arr.add(str);
            return;
        }
        if(leftn>0) {
            if(rightn > 0){
                fun(leftn-1, rightn+1, str+"(");
                fun(leftn, rightn-1, str+")");
            }else{
                fun(leftn-1, rightn+1, str+"(");
            }
        } else{
            fun(leftn, rightn-1, str+")");
        }
    }
}
