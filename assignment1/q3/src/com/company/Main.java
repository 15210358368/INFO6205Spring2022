public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = citations.length;

        for(int i = 0; i < citations.length; i++){
        if(h > citations[i]){
        h--;
        continue;
        }

        if(h <= citations[i]){
        return h;
        }
        }

        return 0;
        }