// https://leetcode.com/problems/dota2-senate

//12ms - Queues || Bet ~ 47%
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public String predictPartyVictory(String senate) {
        
        int n = senate.length();
        char[] ch = senate.toCharArray(); 

        Queue<Integer> rd = new LinkedList<>();
        Queue<Integer> dr = new LinkedList<>();

        for (int i = 0; i < n; i++){
            if (ch[i] == 'R') rd.offer(i);
            else dr.offer(i);
        }
        while( !rd.isEmpty() && !dr.isEmpty() ){
            
            if ( rd.peek() < dr.peek() ) {
                int x = rd.poll();
                rd.offer(x+n);
                dr.poll();
            }
            else {
                int x = dr.poll();
                dr.offer(x+n);
                rd.poll();
            } 
        }

        String result = rd.isEmpty() ? "Dire" : "Radiant";

        return result;
    }
}

//1ms - Counters + Recursion || Bet ~ 100%
import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public Boolean simulate (byte[] s, int rp, int dp){ // rp ~ R - Power, dp ~ D - Power 
        int r = 0, d = 0;

        for (int i = 0; i < s.length; i++){
            if (s[i] == 'R'){
                if (dp > 0 ){
                    dp--;
                    s[i] = 0;
                }
                else {
                    r++;
                    rp++;
                }
            }

            else if (s[i] == 'D'){
                if(rp > 0){
                    rp--;
                    s[i] = 0;
                }
                else {
                    d++;
                    dp++;
                }
            }
        }

        if (r == 0) return false;
        if (d == 0) return true;

        return simulate(s, rp, dp);

    }
    public String predictPartyVictory(String senate) {
        
        return simulate(senate.getBytes(), 0, 0 ) ? "Radiant" : "Dire";
    }
}


