import java.util.Scanner;
import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            //候选人人数
            int n=in.nextInt();
            String[] s=new String[n];
            HashMap<String,Integer> hs=new HashMap<String,Integer>();
            for(int i=0;i<n;i++){
                String temp=in.next();
                hs.put(temp,0);
                s[i]=temp;
            }
            //投票人数
            int m=in.nextInt();
            Set<String> keys=hs.keySet();
            int cnt=0;
            for(int i=0;i<m;i++){
                //投票
                String tick=in.next();
                if(keys.contains(tick)){
                    hs.put(tick,hs.get(tick)+1);
                }else{
                cnt++;
                }
            }
            //输出结果
            for(String k:s){
                System.out.println(k+" : "+hs.get(k));
            }
            System.out.println("Invalid : "+cnt);
            
        }
    }
}