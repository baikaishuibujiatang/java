import java.util.Scanner;
public class Main {
    public static int gcd(int a,int b){
        while(a%b!=0){
            int tmp=a%b;
            a=b;
            b=tmp;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n=in.nextInt();
            int power=in.nextInt();
            int[] array=new int[n];
            for(int i=0;i<array.length;i++){
                array[i]=in.nextInt();
            }
            for(int i=0;i<array.length;i++){
                if(power>=array[i]){
                    power+=array[i];
                }else{
                    power+=gcd(array[i],power);
                }
            }
            System.out.println(power);
        }
    }
}