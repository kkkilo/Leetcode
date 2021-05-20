package leetcode._0010_Regular_Expression_Matching;

public class Regular_Expression_Matching {
    public static void main(String[] args) {
        String s = "aasdfasdfasdfasdfas";
        String p = "aasdf.*asdf.*asdf.*asdf.*s";
        System.out.println(new Regular_Expression_Matching().isMatch(s,p));
    }

    public boolean isMatch(String s, String p) {
        int slen = s.length();
        int plen = p.length();
        int j=0;
        int i=0;

        return check(s,p,slen-1,plen-1);
    }
    public boolean check(String s, String p, int si, int pi){
        if(si<0&&pi>=0){
            if(p.charAt(pi)=='*'){
                return check(s,p,si,pi-2);
            } else {
                return false;
            }
        }else if(pi<0&&si>=0){
            return false;
        }else if(pi<0 && si<0){
            return true;
        }
        if(p.charAt(pi) == '*'){
            char pre = p.charAt(pi-1);
            if(pre == s.charAt(si) || pre == '.'){
                return check(s,p,si,pi-2)||check(s,p,si-1,pi);
            }else {
                return check(s,p,si,pi-2);
            }
        } else {
            if(p.charAt(pi) == s.charAt(si)){
                return check(s,p,si-1,pi-1);
            } else if(p.charAt(pi) == '.') {
                return check(s,p,si-1,pi-1);
            }else{
                return false;
            }
        }
    }
}
