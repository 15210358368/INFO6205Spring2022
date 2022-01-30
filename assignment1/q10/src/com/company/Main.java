class Solution {
    public List<String> topKFrequent(String[] words, int k) {

        Map<String,Integer> mp = new HashMap<>();

        for(String str : words){
            mp.put(str,mp.getOrDefault(str,0)+1);
        }

        Queue<String> que = new PriorityQueue<>( (w1,w2) -> mp.get(w1) == mp.get(w2) ? w2.compareTo(w1) : mp.get(w1) - mp.get(w2));

        for(String key : mp.keySet()){
            que.add(key);
            if(que.size()>k){
                que.poll();
            }
        }

        List<String> res = new ArrayList<>();

        while(!que.isEmpty()){
            res.add(que.poll());
        }

        Collections.reverse(res);
        return res;
    }
}