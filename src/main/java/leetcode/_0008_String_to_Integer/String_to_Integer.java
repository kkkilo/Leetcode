package leetcode._0008_String_to_Integer;

public class String_to_Integer {
    public static void main(String[] args) {
        String s = "-91283472332";
        System.out.println(new String_to_Integer().myAtoi(s));
    }
    public int myAtoi(String s) {
        s = s.trim();

        if(s.length() == 0){
            return 0;
        }

        if(s.length() == 1){
            if(s.charAt(0)<='9' && s.charAt(0)>='0'){
                return s.charAt(0)-'0';
            }else{
                return 0;
            }
        }

        char type = s.charAt(0);
        boolean isSub = false;
        if (type == '-') {
            isSub = true;
            s = s.substring(1);
        } else if(type == '+'){
            s = s.substring(1);
        }

        if(s.charAt(0)>'9' || s.charAt(0)<'0'){
            return 0;
        }

        int index = 0;
        int len = s.length();
        long max = 0;
        if(isSub){
            max = 2147483648L;
        } else {
            max = Integer.MAX_VALUE;
        }
        long sum = 0;
        while (index<len && s.charAt(index) >= '0' && s.charAt(index)<='9'){
            sum = sum*10 + s.charAt(index)-'0';
            index++;
            if(sum>max){
                break;
            }
        }
        if(sum>max){
            return isSub?Integer.MIN_VALUE:Integer.MAX_VALUE;
        }else{
            return isSub?(int)(-sum):(int)sum;
        }
    }
}
