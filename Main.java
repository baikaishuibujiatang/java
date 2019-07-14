public class Main{
	//找基准分区
	public static int getMiddle(int[] array,int low,int high){
		int tmp=array[low];
		while(low<high){
			while(low<high&&array[high]>tmp){
				high--;
			}
			array[low]=array[high];
			while(low<high&&array[low]<tmp){
				low++;
			}
			array[high]=array[low];
		}
		array[low]=tmp;
		return low;
	}
	//递归不断分区（分治）
	public static void _quickSort(int[] array,int low,int high){
		if(low<high){
			int middle=getMiddle(array,low,high);
			_quickSort(array,middle+1,high);
			_quickSort(array,low,middle-1);
			}
	}
	public static void quickSort(int[] array){
		_quickSort(array,0,array.length-1);
	}
	public static void main(String[] args){
		int[] array={5,2,7,1,9,3,8};
		Main qs=new Main();
		qs.quickSort(array);
		for(int i=0;i<array.length;i++){
			System.out.print(array[i]+" ");
		}
		System.out.println();
	}
}