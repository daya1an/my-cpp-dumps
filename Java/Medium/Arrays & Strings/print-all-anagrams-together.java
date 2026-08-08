class Solution {
    
    public static Integer MAX_CHAR = 26;
    
    public String getHash(String s){
           
        int[] frq = new int[MAX_CHAR];
        StringBuilder hash = new StringBuilder();
        for (char ch : s.toCharArray()){
            frq[ch - 'a']++;
        }
        
        for (int i = 0; i < MAX_CHAR; i++){
            hash.append(frq[i]);
            hash.append('#');
        }
        
        return hash.toString();
    }
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        
        for (int i = 0; i<arr.length; i++){
            String key = getHash(arr[i]);
            
            if(!map.containsKey(key)){
                map.put(key,res.size());
                res.add(new ArrayList<>());
            }
            
            res.get(map.get(key)).add(arr[i]);
        }
        
        return res;
        
    }
}
