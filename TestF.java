public class TestF{
	public static int isNum(String str){
		int count=0;
		int i=0;
		while(i<str.length()){
			if(str.charAt(i)>='0'&&str.charAt(i)<='9'){
				count++;
			}
			i++;
		}
		return count;
	}
	public static void main(String[] args){
		String str="idw23idfn0";
		System.out.println(isNum(str));
	}
}