import java.util.Scanner;
public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s=in.nextLine();
            int k=in.nextInt();
            int max=0;
            int maxIndex=0;
            for(int i=0;i<s.length()-k;i++){
                int count=0;
                for(int j=i;j<i+k;j++){
                    if(s.charAt(j)=='G'||s.charAt(j)=='C'){
                        count++;
                    }
                }
                if(count>max){
                    maxIndex=i;
                    max=count;
                }
            }
            System.out.println(s.substring(maxIndex,maxIndex+k));
        }
    }
}