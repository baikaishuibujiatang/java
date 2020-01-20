class Solution9 {
    public int pivotIndex(int[] nums) {
        if(nums.length<3){return -1;}
        int index=-1;
        int leftsum=0;
        int rightsum=0;
        for(int i=0;i<nums.length;i++) rightsum+=nums[i];
        for(int i=0;i<nums.length;i++){
            rightsum-=nums[i];
            if(leftsum==rightsum){
                index=i;
                break;
            }else{
                leftsum+=nums[i];
            }
        }
        return index;
    }
}