class Solution3 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int last = nums.length;
        while (i < last) {
          if (nums[i] == val) {
            nums[i] = nums[last - 1];
            last--;
          } else {
            i++;
          }
        }
        return last;
    }
	public int removeElement2(int[] nums, int val){
		int i=0;
		for(int j=0;j<nums.length;j++){
			if(nums[j]!=val){
				nums[i]=nums[j];
				i++;
			}
		}
	}
	
}