package leetcode._0007_Reverse_Integer;

public class Reverse_Integer {
    public static void main(String[] args) {
//        int x = Integer.MAX_VALUE;
        int x = -2147483648;
        System.out.println(new Reverse_Integer().reverse(x));
    }
    public int reverse(int x) {
        if(x==-2147483648) return 0;
        int flag = x>=0?1:0;
        x = Math.abs(x);
        String strRes = "";
        String maxstr = String.valueOf(Integer.MAX_VALUE);
        String minstr = String.valueOf(Integer.MIN_VALUE);
        while(x!=0){
            int a = x%10;
            x = x/10;
            strRes += String.valueOf(a);
        }
        while (strRes.length()<10){
            strRes = "0"+strRes;
        }
        if(flag == 0){
            strRes = "-" + strRes;
        }
        if(strRes.charAt(0) == '-'){
            if(minstr.compareTo(strRes)>=0){
                return Integer.valueOf(strRes);
            }else {
                return 0;
            }
        } else {
            if(maxstr.compareTo(strRes)>=0){
                return Integer.valueOf(strRes);
            }else {
                return 0;
            }
        }
        //2147483648 其实可以在比较倒数第二次的时候与MAX_INTEGER/10进行比较，如果大于直接否决，相同则比较8



    }


    //用了64位
//    public int reverse(int x) {
//        long num=0;
//        while(x!=0){
//            int a = x%10;
//            x = x/10;
//            num = num*10+a;
//        }
//        System.out.println(num);
//        if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE){
//            return 0;
//        }else {
//            return (int)num;
//        }
//    }
}
