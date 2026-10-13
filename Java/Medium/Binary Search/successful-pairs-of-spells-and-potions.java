import java.util.Arrays;

class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        // best solution - 5 ms
        int n = spells.length;
        int m = potions.length;

        int[] pairs = new int[n];
        
        int max = 0;
        for(int i:potions) max = Math.max(max,i);

        int[] suffix = new int[max+1];
        for(int i:potions) suffix[i]++;

        for(int i=max-1;i>=0;i--) {
            suffix[i] += suffix[i+1];
        }

        for(int i=0;i<n;i++) {
            long min = (success + spells[i] - 1) / spells[i];
            if(min > max) pairs[i] = 0;
            else pairs[i] = suffix[(int)min];
        }
        return pairs;
    
        // Binary Search

        // Arrays.sort(potions);

        // int pl = potions.length;
        // int sl = spells.length;

        // int result[] = new int[sl];

        // for (int i = 0; i < sl; i++){

        //     int left = 0;
        //     int right = pl-1;
        //     int valid = pl;

        //     while (left <= right){
                
        //         int mid = left + (right-left)/2;

        //         long product = (long) spells[i] * potions[mid];

        //         if(product >= success){
        //             valid = mid;
        //             right = mid - 1;
        //         } 
        //         else {
        //             left = mid + 1;
        //         }
        //     }

        //     result[i] = pl - valid;
        // }

        // return result;
        


        // Brute force - Time Limit Exceeded 51 / 57 testcases passed
        /*        
        int[] result = new int[spells.length];

        for (int i = 0; i < spells.length; i++){

            int count = 0;
            
            for (int j = 0; j < potions.length; j++){
                
                long product = (long) spells[i] * potions[j];
                
                if (product >= success) count++;
            }

            result[i] = count;
        }

        return result;       
        */


    }
}
