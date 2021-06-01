package leetcode._0029_Divide_Two_Integers;

public class Divide_Two_Integers {
    public int divide(int dividend, int divisor) {
        boolean isSub = false;
        if(dividend==0){
            return 0;
        }
        else if(dividend>0&&divisor>0 || dividend<0&&divisor<0){
            isSub = false;
        } else {
            isSub = true;
        }
        if(dividend == Integer.MIN_VALUE){
            int shang = 0;
            if(divisor>0){
                divisor = -divisor;
                while(dividend<=divisor){
                    shang++;
                    dividend -= divisor;
                }
                return -shang;
            }else{
                while(dividend<=divisor){
                    if(shang==Integer.MAX_VALUE){
                        return Integer.MAX_VALUE;
                    }
                    shang++;
                    dividend -= divisor;
                }
                return shang;
            }
        }
        if(divisor == Integer.MIN_VALUE){
            if(dividend == Integer.MIN_VALUE){
                return 1;
            }else{
                return 0;
            }
        }
        int shang=0;
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend>=divisor){
            shang++;
            dividend -= divisor;
        }
        return isSub?-shang:shang;
    }
}
