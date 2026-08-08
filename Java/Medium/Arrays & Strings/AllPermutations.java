import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class AllPermutations {

    static void recurPermute(int index, char[] s, List<String> res) {
        if (index == s.length) {
            res.add(new String(s));
            return;
        }

        for (int i = index; i < s.length; i++) {
            // Skip duplicates - don't swap if character already used at this level
            if (i > index && s[i] == s[i - 1]) {
                continue;
            }
            
            // swap
            char temp = s[index];
            s[index] = s[i];
            s[i] = temp;

            System.out.println(i + " Phase 1: " + s[index] + " with " + s[i] + " -> " + Arrays.toString(s));

            recurPermute(index + 1, s, res);

            System.out.println(i + " Phase 2: " + s[index] + " with " + s[i] + " -> " + Arrays.toString(s));

            // backtrack
            temp = s[index];
            s[index] = s[i];
            s[i] = temp;

            System.out.println(i + " Phase 3: " + s[index] + " with " + s[i] + " -> " + Arrays.toString(s));
        }
    }

    static List<String> findPermutation(String s) {
        List<String> res = new ArrayList<>();
        
        // Sort input to handle duplicates and avoid duplicate permutations
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);

        recurPermute(0, chars, res);
        return res;
    }

    public static void main(String[] args) {
        String s = "ABC";
        List<String> res = findPermutation(s);

        for (String x : res) {
            System.out.print(x + " ");
        }
        
        System.out.println("\nCount: " + res.size());
    }
}