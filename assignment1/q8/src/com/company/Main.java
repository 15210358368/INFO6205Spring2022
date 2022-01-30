
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int end = arr.length - 1;

        while(end >= 0){

            int max = 0;
            int maxIdx = 0;
            for(int i = 0; i <= end; i++){
                if(max < arr[i]){
                    max = arr[i];
                    maxIdx = i;
                }
            }

            reverse(arr, maxIdx);
            res.add(maxIdx + 1);

            reverse(arr, end);
            res.add(end + 1);

            end--;

        }

        return res;
    }


    public void reverse(int[] arr, int j){
        int i = 0;

        while(i < j){
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            j--;
            i++;
        }


    }
