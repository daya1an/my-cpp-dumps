import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        
        if (word1.length() != word2.length()) return false;

        int[] wa1 = new int[26];
        int[] wa2 = new int[26];

        for(char c : word1.toCharArray()) wa1[c-'a']++;

        for(char c : word2.toCharArray()) wa2[c-'a']++;

        for (int i = 0; i < 26; i++){
            if((wa1[i] == 0) != (wa2[i] == 0)) return false;
        }


        // Block 1
        Arrays.sort(wa1);
        Arrays.sort(wa2);

        // return Arrays.equals(wa1, wa2);
        //----
        /* 
        The above block's runtime is 11 ms, beat 80% and the below one is 8 ms, beat 100%. 
        But the above is much better and production ready code than the below one, and the below one is more of a hack to get better runtime:
        Reasons to prefer the above approach:
        Readability — intent is obvious in 2 lines vs nested loop with mutable state
        Maintainability — no risk of off-by-one or missed wa2[j]=0 reset bugs
        Correctness risk — your O(26²) mutates wa1/wa2 mid-loop; subtle bugs if logic changes
        Performance — O(26 log 26) vs O(26²), both constant but sort is fewer operations
        Idiomatic Java — reviewers instantly recognize Arrays.sort + Arrays.equals; nested manual matching raises questions in code review
        Testability — no side effects, pure comparison; easier to unit test and reason about
        */

        //Block 2
        for (int i = 0; i < 26; i++) {
            if (wa1[i] > 0) {
                boolean found = false;
                for (int j = 0; j < 26; j++) {
                    if (wa2[j] > 0 && wa1[i] == wa2[j]) {
                        found = true;
                        wa1[i] = 0;
                        wa2[j] = 0;
                        break;
                    }
                }
                if (!found) return false;
            }
        }
        return true;
    }
}