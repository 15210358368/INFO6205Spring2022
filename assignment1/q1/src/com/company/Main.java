public void sortColors(int[] nums) {

        int[] colorCnt = new int[3];

        for(int i : nums){
        colorCnt[i]++;
        }


        int index = 0;
        for(int i = 0; i < colorCnt.length; i++){
        int cnt = colorCnt[i];
        while(cnt > 0){
        nums[index] = i;
        cnt--;
        index++;
        }
        }

        }