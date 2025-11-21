// Last updated: 11/21/2025, 7:22:59 AM
import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);

        // Record first and last occurrence of each character
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }

        int ans = 0;

        // For each possible outer character
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) continue;                 // char doesn't appear
            if (first[c] == last[c]) continue;            // appears only once, can't form length 3

            boolean[] mid = new boolean[26];

            // Mark distinct middle characters between first[c] and last[c]
            for (int i = first[c] + 1; i < last[c]; i++) {
                int midChar = s.charAt(i) - 'a';
                mid[midChar] = true;
            }

            // Count distinct middle characters
            for (int k = 0; k < 26; k++) {
                if (mid[k]) ans++;
            }
        }

        return ans;
    }
}
