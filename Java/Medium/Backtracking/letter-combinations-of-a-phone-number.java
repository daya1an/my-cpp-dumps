import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 4ms
class Solution {
    Map<Character, String> map = new HashMap<>();
    List<String> result = new ArrayList<>();

    public Solution() {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }

        build("", 0, digits);

        return result;
    }

    private void build(String currentWord, int pos, String digits) {
        if (currentWord.length() == digits.length()) {
            result.add(currentWord);
            return;
        }

        String letters = map.get(digits.charAt(pos));

        for (char letter : letters.toCharArray()){
            build(currentWord + letter, pos+1, digits);
        }
    }
}

// 0ms (Best Solution)

class Solution {
    private final static String[] KEY_PAD = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return null;
        List<String> result = new ArrayList<>();

        backtrack(digits, 0, result, new StringBuilder());

        return result;
        
    }

    private void backtrack(String digits, int idx, List<String> result, StringBuilder path){
        if(digits.length() == idx){
            result.add(path.toString());
            return;
        }

        char ch = digits.charAt(idx);
        String word = KEY_PAD[ch - '0'];

        for(int i = 0; i < word.length(); i++){
            path.append(word.charAt(i));
            backtrack(digits, idx + 1, result, path);
            path.setLength(path.length() - 1);
        }
    }
}


