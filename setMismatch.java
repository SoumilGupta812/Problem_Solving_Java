public class setMismatch {
    //You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
    //
    //You are given an integer array nums representing the data status of this set after the error.
    //
    //Find the number that occurs twice and the number that is missing and return them in the form of an array.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,2,2,4]
    //Output: [2,3]
    //Example 2:
    //
    //Input: nums = [1,1]
    //Output: [1,2]
    //
    //
    //Constraints:
    //
    //2 <= nums.length <= 104
    //1 <= nums[i] <= 104
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct])
                swap(nums, i, correct);
            else i++;
        }
        for(int j=0;j<n;j++)
        {
            if(nums[j]!=j+1) return new int[]{nums[j],j+1};
        }
        return new int[] { -1, -1 };
    }

    public void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
    public int[] findErrorNums2(int[] nums) {
        int dup=-1,miss=-1;
        int[] freq=new int[nums.length+1];
        for(int num:nums) freq[num]++;
        for(int i=1;i<=nums.length;i++){
            if(freq[i]==2) dup=i;
            else if(freq[i]==0) miss=i;
        }
        return new int[]{dup,miss};
    }
}
