public class Test{
	private static int i=1;
	public int getNext(){
		return i++;
	}
	public static void main(String[] args){
		Test test=new Test();
		Test testObject=new Test();
		test.getNext();
		testObject.getNext();
		System.out.println(testObject.getNext());
		int[][] array={
			{1,2,8,9},
			{2,4,9,12},
			{4,7,10,13},
			{6,8,11,15}
		};
		boolean result=judgeInterger(array,0);
		System.out.println(result);
		boolean result1=judgeInterger1(array,0);
		System.out.println(result1);
	}
	public static boolean judgeInterger(int[][] a,int x){
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[0].length;j++){
				if(a[i][j]==x){
					return true;
				}
			}
		}
		return false;
	}
	public static boolean judgeInterger1(int[][] a,int x){
		//选取右上角元素
		int row=0;
		int col=a[0].length-1;
		while(row<=a.length-1&&col>=0){
			if(x>a[row][col]){
				row++;//大的值在下面，行加加
			}else if(x<a[row][col]){
				col--;//小的值在基准左面，列减减
			}else{
				return true;
			}
		}
		return false;
	} 
	
}