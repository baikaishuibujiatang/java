import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sort {
   public static void mergeSort(Person[] array){
       mergeSort1(array,0,array.length);
   }
   //[low,high)
    private static void mergeSort1(Person[] array,int low,int high){
       if(low+1>=high){
           return ;
       }
       int mid=(low+high)/2;
       mergeSort1(array,low,mid);
       mergeSort1(array,mid,high);
       merge(array,low,mid,high);
    }
    private static void merge(Person[] array,int low,int mid,int high){
       int length=high-low;
       Person[] extra=new Person[length];
       int iLeft=low;
       int iRight=mid;
       int iExtra=0;
       while(iLeft<mid&&iRight<high){
           int r=array[iLeft].compareTo(array[iRight]);
           if(r<=0){
               extra[iExtra++]=array[iLeft++];
           }else{
               extra[iExtra++]=array[iRight++];
           }
       }
       while(iLeft<mid){
           extra[iExtra++]=array[iLeft++];
       }
       while(iRight<high){
           extra[iExtra++]=array[iRight++];
       }
       for(int i=0;i<length;i++){
           array[low+i]=extra[i];
       }
    }
    public static void mergeSortWithComparator(Person[] array,Comparator<Person> comparator){
        mergeSort1WithComparator(array,0,array.length,comparator);
    }
    //[low,high)
    private static void mergeSort1WithComparator(Person[] array, int low, int high, Comparator<Person> comparator){
        if(low+1>=high){
            return ;
        }
        int mid=(low+high)/2;
        mergeSort1WithComparator(array,low,mid,comparator);
        mergeSort1WithComparator(array,mid,high,comparator);
        mergeWithComparator(array,low,mid,high,comparator);
    }
    private static void mergeWithComparator(Person[] array,int low,int mid,int high,Comparator<Person> comparator){
        int length=high-low;
        Person[] extra=new Person[length];
        int iLeft=low;
        int iRight=mid;
        int iExtra=0;
        while(iLeft<mid&&iRight<high){
            int r=comparator.compare(array[iLeft],array[iRight]);
            if(r<=0){
                extra[iExtra++]=array[iLeft++];
            }else{
                extra[iExtra++]=array[iRight++];
            }
        }
        while(iLeft<mid){
            extra[iExtra++]=array[iLeft++];
        }
        while(iRight<high){
            extra[iExtra++]=array[iRight++];
        }
        for(int i=0;i<length;i++){
            array[low+i]=extra[i];
        }
    }
    public static void main(String[] args) {
        Person[] people=new Person[20];
        Random random=new Random(20190902);
        for(int i=0;i<people.length;i++){
            people[i]=new Person();
            people[i].age=random.nextInt(100);
            people[i].rank=random.nextInt(50);

        }
        System.out.println(Arrays.toString(people));
        //mergeSort(people);
        //System.out.println(Arrays.toString(people));
        mergeSortWithComparator(people,new PersonRankComparator());
        System.out.println(Arrays.toString(people));;
    }
}