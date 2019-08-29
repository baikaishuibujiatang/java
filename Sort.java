import java.util.Arrays;
import java.util.Random;

public class Sorts {
    //有序数组
    private static int[] buildSortedArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=i;
        }
        return array;
    }
    // 逆序
    private static int[] buildReversedSortedArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=n-i;
        }
        return array;
    }
    //随机值
    private static int[] buildRandomArray( int n){
        Random random=new Random(20190828);
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=random.nextInt(n);
        }
        return array;
    }
    //完全相等
    private static int[] buildEqualsArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            array[i]=n;
        }
        return array;
    }
    private static void swap(int[] array,int i,int j){
        int t=array[i];
        array[i]=array[j];
        array[j]=t;
    }
	//冒泡排序
    public static void buubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=0;j<array.length-i-1;j++){
                if(array[j]>array[j+1]){
                    swap(array,j,j+1);
                }
            }
        }
    }
    //快排
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length-1);
    }
    public static void quickSortInternal(int[] array,int left,int right){
        if(left>right){
            return ;
        }
        //1.确定基准值：array[right]作为基准值
        //2. 遍历，小的左，大的右
        int pivotIndex=partition1(array,left,right);
        //分出两个区间
        //[left,pivotIndex-1]
        //[pivotIndex+1,right]
        //3.治
        quickSortInternal(array,left,pivotIndex-1);
        quickSortInternal(array,pivotIndex+1,right);

    }
    //Hover
    private static int partition1(int[] array,int left,int right){
        int pivot=array[right];
        int less=left;
        int great=right;
        while(less<great){
            while(less<great&&array[less]<=pivot){
                less++;
            }
            while(less<great&&array[great]>=pivot){
                great--;
            }
            swap(array,less,great);
        }
        swap(array,right,less);
        return less;
    }
    //o(n) 挖坑
    private static int partition2(int[] array,int left,int right){
        int pivot=array[right];
        int less=left;
        int great=right;
        while(less<great){
            while(less<great&&array[less]<pivot){
                less++;
            }
            array[great]=array[less];
            while(less<great&&array[great]>=pivot){
                great--;
            }
            array[less]=array[great];
        }
        array[less]=pivot;
        return less;
    }
    private static int partition3(int[] array,int left,int right){
        //[left,less) 小于pivot
        //[less,i)  >=pivot
        int less=left;//蓝色箭头
        int pivot=array[right];
        for(int i=left;i<right;i++){
            if(array[i]<pivot){
                swap(array,i,less);
                less++;
            }
        }
        swap(array,less,right);
        return less;
    }
    private static int[] partition(int[] array,int left,int right){
        int pivot=array[right];
        int less=left;
        int great=right;
        int i=left;
        while(i<great){
            if(array[i]==pivot){
                i++;
            }else if(array[i]<pivot){
                swap(array,less,i);
                less++;
            }else{
                while(i<great&&array[great]>pivot){
                    great--;
                }
                swap(array,i,great);
            }
        }
        return new int[] {less,great-1};
    }


    public static void main(String[] args) {
        // 有序 | 无序 | 随机值 | 完全相等的
        int[] array;

        //array = buildReversedSortedArray(1000000);
        //array = buildSortedArray(1000000);
		array = buildRandomArray(50);
		//array = buildEqualsArray(10);
		System.out.println(Arrays.toString(array));
        long begin = System.nanoTime();	// 纳秒
		//insertSort(array);
		//shellSort(array);
		//selectSort(array);
		//selectSortVersion2(array);
		//heapSort(array);
        quickSort(array);
		long end = System.nanoTime();	// 纳秒
		System.out.println(end - begin);
		System.out.println(Arrays.toString(array));
	}
}