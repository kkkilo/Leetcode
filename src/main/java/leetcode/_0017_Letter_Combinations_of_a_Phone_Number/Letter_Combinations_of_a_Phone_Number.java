package leetcode._0017_Letter_Combinations_of_a_Phone_Number;

import java.util.*;

public class Letter_Combinations_of_a_Phone_Number {

    public static void main(String[] args) {
        String str = "22";
        List list = new Letter_Combinations_of_a_Phone_Number().letterCombinations(str);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private ArrayList<String> res = new ArrayList<>();
    private HashMap<Integer,String> map = new HashMap<>();

    /*
    public List<String> letterCombinations(String digits) {//错误解法，题目意思允许字符串所含字母排序不同但是数量相同
        String str = digits;

        int len = str.length();
        if(len == 0)return res;
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 0; i < len; i++) {
            arr.add(str.charAt(i)-'0');
        }

        Collections.sort(arr);
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        fun(arr, 0, '0'-1, len,"");

//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }
        return res;
    }


    public void fun(List list, int i, int pre ,int len ,  String str){
        String alpha = map.get(list.get(i));

        if(i == len-1){
            for (int j = 0; j < alpha.length(); j++) {
                char cur = alpha.charAt(j);
                if(cur>=pre){
                    res.add(str+cur);
                }
            }
        } else{
            for (int j = 0; j < alpha.length(); j++) {
                char cur = alpha.charAt(j);
                if(cur>=pre){
                    fun(list, i+1, cur,len,str+cur);
                }
            }
        }
    }
    */

    public List<String> letterCombinations(String digits) {
        String str = digits;

        int len = str.length();
        if(len == 0)return res;
        ArrayList<Integer> arr = new ArrayList();
        for (int i = 0; i < len; i++) {
            arr.add(str.charAt(i)-'0');
        }

        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");

        fun(arr, 0,  len,"");

//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }
        return res;
    }






    public void fun(List list, int i,int len ,  String str){
        String alpha = map.get(list.get(i));

        if(i == len-1){
            for (int j = 0; j < alpha.length(); j++) {
                char cur = alpha.charAt(j);
                res.add(str+cur);

            }
        } else{
            for (int j = 0; j < alpha.length(); j++) {
                char cur = alpha.charAt(j);
                fun(list, i+1, len,str+cur);

            }
        }
    }
}
