class Solution10 {
    public int thirdMax(int[] nums) {
        long first=Long.MIN_VALUE;
        long second=Long.MIN_VALUE;
        long third=Long.MIN_VALUE;
        for(long n:nums){
            if(n>first){
                third=second;
                second=first;
                first=n;
            }else if(n>second&&n<first){
               third=second;
               second=n; 
            }else if(n>third&&n<second){
                third=n;
            }
        }
        return (third==Long.MIN_VALUE)? (int)first:(int)third;
    }
}