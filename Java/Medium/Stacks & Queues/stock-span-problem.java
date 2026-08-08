import java.util.*;

class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        // code here
        int n = arr.length; 
        ArrayList<Integer> res = new ArrayList<>(Collections.nCopies(n, 0));  
        Stack<Integer> stk = new Stack<>(); 
        
        for (int i = 0; i < arr.length; i++){
            
            while (!stk.isEmpty() && arr[stk.peek()] <= arr[i]){
                stk.pop();
            }
            
            if (stk.isEmpty()){
                res.set(i, i+1);
            }
            else{
                res.set(i, (i-stk.peek()));
            }
            
            stk.push(i);
        }
        
        return res;
    }
}