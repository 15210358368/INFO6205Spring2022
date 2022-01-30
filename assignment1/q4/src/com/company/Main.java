class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<>();
        for(int i : nums1){
            for(int k : nums2){
                if(i == k){
                    res.add(k);
                }
            }
        }

        int[] ans = new int[res.size()];
        int i = 0;
        for(int a : res){
            ans[i] = a;
            i++;
        }

        return ans;

    }
}