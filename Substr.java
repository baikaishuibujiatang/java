import java.util.*;

public class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean []rs=new boolean[p.length];
        if(p.length>500||s.length()>1000){
            return rs;
        }
        for(int i=0;i<n;i++){
            rs[i]=s.contains(p[i]);
        }
        return rs;
    }
}