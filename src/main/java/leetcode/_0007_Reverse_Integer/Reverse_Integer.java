package leetcode._0007_Reverse_Integer;

public class Reverse_Integer {
    public static void main(String[] args) {
        int x = Integer.MAX_VALUE;
        System.out.println(new Reverse_Integer().reverse(x));
    }
    public int reverse(int x) {
        long num=0;
        while(x!=0){
            int a = x%10;
            x = x/10;
            num = num*10+a;
        }
        System.out.println(num);
        if(num>Integer.MAX_VALUE || num<Integer.MIN_VALUE){
            return 0;
        }else {
            return (int)num;
        }
    }
}
