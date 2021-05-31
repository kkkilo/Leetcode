package leetcode._0028_Implement_strStr;

public class Implement_strStr {
    public static void main(String[] args) {
        String str1 = "mississippi";
        String str2 = "issip";
        System.out.println(new Implement_strStr().strStr(str1,str2));
    }

    public int strStr(String haystack, String needle) {
        int len = haystack.length();
        if(needle.length() == 0){
            return 0;
        }
        int[] jump = new int[needle.length()];
//        int[] jump = getNext(needle);
        int i = 0;
        int j = 0;
        for ( ; i < len; i++) {
            if(j == needle.length()){
                break;
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }else{
                i -= j;
                j = jump[j];
            }
        }
        if(j == needle.length()){
            return i-j;
        } else{
            return -1;
        }
    }

//    public int[] getNext(String str){
//        int len = str.length();
//        int[] next = new int[len];
//        if(len==0){
//            return next;
//        }
//        next[0] = -1;
//
//        for (int i = 1; i < len; i++) {
//            if(str.charAt(next[i-1]+1) == str.charAt(i)){
//                next[i] = next[i]+1;
//            }
//        }
//        return next;
//    }
}