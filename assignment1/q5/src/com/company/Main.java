class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int right = find(arr,x);
        int left = right - 1;

        List<Integer> res = new ArrayList<>();

        for(int i = 0; i < k; i++){       // we only need k elements
            if(check(arr,x,left,right)){
                res.add(arr[left]);
                left--;
            }else{
                res.add(arr[right]);
                right++;
            }

        }


        Collections.sort(res);

        return res;

    }

    public static boolean check(int[] arr, int x,int left, int right) { // check if the number is at left hand

        if(left < 0){
            return false;
        }

        if(right >= arr.length){
            return true;
        }


        return x - arr[left] <= arr[right] - x;
    }

    public static int find (int[] arr, int target) {  // use binary search to find the closest value
        int start = 0;
        int end = arr.length - 1;


        while(start + 1 < end){
            int mid = start + (end - start)/2;
            if(arr[mid] >= target){
                end = mid;
            }else{
                start = mid;
            }
        }

        if(arr[start] >= target){
            return start;
        }

        if(arr[end] >= target){
            return end;
        }




        return arr.length;
    }
}