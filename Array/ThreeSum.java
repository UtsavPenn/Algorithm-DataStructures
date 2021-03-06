/**
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]

**/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> solutionList = new ArrayList<>();
        List<Integer> solution;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++){
            if(i!=0 && nums[i]==nums[i-1]) //avoid duplicates
                continue;
            int low = i+1;
            int high = nums.length - 1;
            int sum = 0 - nums[i];
            while(low<high){
                if(nums[low]+nums[high]==sum){
                    solutionList.add(Arrays.asList(nums[low],nums[high],nums[i]));
                    while(low<high && nums[low]==nums[low+1])low++;  //avoid duplicate two sums
                    while(low<high && nums[high]==nums[high-1])high--; //avoid duplicate two sums
                    low++;
                    high--;
                }
                else if(nums[low] + nums[high] > sum){
                    high--;
                }
                else{
                    low++;
                }
            }
        }
      return solutionList;
    }
}
