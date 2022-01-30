class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> mp = new HashMap<>();
        for(char c : s.toCharArray()){
            mp.put(c, mp.getOrDefault(c,0)+1);
        }

        StringBuilder sb = new StringBuilder();

        for(char k : order.toCharArray()){
            if(mp.containsKey(k)){
                int num =  mp.get(k);
                while(num > 0){
                    sb.append(k);
                    num--;
                }
                mp.remove(k);
            }
        }


        for(char ch : mp.keySet()){
            int num = mp.get(ch);
            while(num > 0){
                sb.append(ch);
                num--;
            }
        }


        return sb.toString();

    }
}