public class findTheDuplicateNumber {
    //Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
    //
    //There is only one repeated number in nums, return this repeated number.
    //
    //You must solve the problem without modifying the array nums and using only constant extra space.
    public int findDuplicate(int[] nums) {
        int n=nums.length;
        int i=0;
        while(i<n){
            if(nums[i]!=i+1)
            {
                int correct=nums[i]-1;
                if(nums[i]!=nums[correct])
                    swap(nums,i,correct);
                else
                    return nums[i];
            }
            else i++;
        }
        return -1;
    }
    public void swap(int[] nums,int first,int second)
    {
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
    public int findDuplicate2(int[] nums) {
        boolean[] count = new boolean[nums.length+1];
        for(int i = 0 ; i < nums.length; i++){
            if(count[nums[i]]) {
                return nums[i];
            }else{
                count[nums[i]] = true;
            }
        }
        return 0;
    }
}
