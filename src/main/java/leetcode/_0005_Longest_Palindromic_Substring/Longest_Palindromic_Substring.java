package leetcode._0005_Longest_Palindromic_Substring;

public class Longest_Palindromic_Substring {

    public static void main(String[] args) {
        String s = "";
        System.out.println(new Longest_Palindromic_Substring().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] flag = new boolean[len][len];

        if(len == 0)return "";

        int max = 0;
        int ii = 0;
        int jj = 0;

        for(int i=len-1; i>=0; i--){
            for(int j=i; j<=len-1; j++){
                if(i==j){
                    flag[i][j] = true;
                }else if(j-i == 1){
                    if(s.charAt(i) == s.charAt(j) ){
                        flag[i][j] = true;
                    }else{
                        flag[i][j] = false;
                    }
                }else{
                    if(flag[i+1][j-1] && s.charAt(i) == s.charAt(j)){
                        flag[i][j] = true;
                    }else{
                        flag[i][j] = false;
                    }
                }
                if(flag[i][j]){
                    if(max < (j-i+1)){
                        max = (j-i+1);
                        ii = i;
                        jj = j;
                    }

                }
            }

        }
        return s.substring(ii,jj+1);
    }
}
