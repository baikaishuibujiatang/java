import java.util.HashMap;
import java.util.Map;

public class P1 {
    static Map<Integer,Integer> count(int[] nums){
        //key  数字
        //value  出现的次数
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums){
            //判断n在不在map 中
            //不在，出现次数是1
            //在，出现次数+1
            int c=map.getOrDefault(n,0);
            map.put(n,c+1);
        }
        return map;
    }

    public static void main(String[] args) {
        int[] numbers={1,2,3,4,5,1,2,3,4,5,8};
        Map<Integer,Integer> map=count(numbers);
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int number=entry.getKey();
            int count=entry.getValue();
            if(count==1){
                System.out.println(number);
            }
        }
    }
}