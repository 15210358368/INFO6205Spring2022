class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Set<List<Integer>> s = new HashSet<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length-3; i++){
            for(int j = i+1; j < nums.length-2; j++){
                int low = j + 1;
                int high = nums.length - 1;

                while( low < high ){
                    int sum = nums[i] + nums[j] + nums[low] + nums[high];
                    if(sum == target){

                        s.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        low++;
                        high--;
                    }

                    else if(sum > target){
                        high--;
                    }else{
                        low++;
                    }
                }


            }


        }

        for(List<Integer> a : s){
            res.add(a);
        }

        return res;
    }


}