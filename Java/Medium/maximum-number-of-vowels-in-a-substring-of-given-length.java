//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length

///My Own Brute Force Approach (100/107 test cases passed - failed due to timelimit)
class Solution1 {
    public int countVowels(String str){
        String vowels = "aeiou";
        int count = 0;
        for (char c : str.toCharArray()){
            if (vowels.contains(String.valueOf(c))) count++;
        }

        return count;
    }
    public int maxVowels(String s, int k) {
        char [] vowels = {'a','e','i','o','u'};
        int finalCount = 0, n = s.length();
        for (int i = 0; i<=n-k; i++){
            int count = countVowels(s.substring(i,i+k));
            finalCount = Math.max(finalCount,count);
        }
        return finalCount;
    }
}

/// Refered Solution(13 ms - bet 75%)

class Solution2 {
    
    public boolean isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int count = 0;
        
        for (int i = 0; i < k; i++ ){
            if (isVowel(s.charAt(i))) count++;
        }

        int maxCount = count;

        for (int i = k; i < s.length(); i++){

            if(isVowel(s.charAt(i))) count++;

            if(isVowel(s.charAt(i-k))) count--;

            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}


/// best one 5 ms
class Solution {
    public int maxVowels(String s, int k) {
        int[] ch = new int[128];
        ch['a']++; ch['e']++; ch['i']++; ch['o']++; ch['u']++;

        int count = 0;
        char[] arr = s.toCharArray();

        for (int i = 0; i<k; i++){
            count += ch[arr[i]];
        } 

        if (maxCount == k) return k; // early exit

        int maxCount = count;

        for(int i = k; i < arr.length; i++){
            count += ch[arr[i]];
            count -= ch[arr[i-k]];

            maxCount = Math.max(maxCount,count);

            if (maxCount == k) return k; // early exit
        }

        return maxCount;
    }
}
