class Solution {
    int countWays(int n) {
        int a = 1, b = 1;
        
        for (int i = 2; i<=n; i++){
            int next = a + b;
            a = b;
            b = next;
        }
        
        return b;
    }
}
