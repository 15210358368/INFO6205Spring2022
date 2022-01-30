class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int n : nums){
            mp.put(n, mp.getOrDefault(n,0) + 1);
        }


        List<Integer> li = new ArrayList<>();
        for(int key : mp.keySet()){
            if(mp.get(key) > (nums.length / 3)){
                li.add(key);
            }

        }

        return li;

    }
}