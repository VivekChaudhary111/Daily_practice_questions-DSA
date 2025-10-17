// Last updated: 10/17/2025, 7:11:28 PM
import java.util.*;

class Solution {
    public int maxPartitionsAfterOperations(String s, int k) {
        Map<Long, Integer> memo = new HashMap<>();
        return dfs(s, 0, true, 0, k, memo) + 1;
    }

    private int dfs(String s, int i, boolean canChange, int mask, int k, Map<Long, Integer> memo) {
        if (i == s.length()) return 0;

        long key = ((long) i << 27) | ((canChange ? 1L : 0L) << 26) | mask;
        if (memo.containsKey(key)) return memo.get(key);

        int res = helper(s, i, canChange, mask, 1 << (s.charAt(i) - 'a'), k, memo);

        if (canChange) {
            for (int c = 0; c < 26; ++c) {
                res = Math.max(res, helper(s, i, false, mask, 1 << c, k, memo));
            }
        }

        memo.put(key, res);
        return res;
    }

    private int helper(String s, int i, boolean canChange, int mask, int newBit, int k, Map<Long, Integer> memo) {
        int newMask = mask | newBit;

        if (Integer.bitCount(newMask) > k) {
            return 1 + dfs(s, i + 1, canChange, newBit, k, memo);
        } else {
            return dfs(s, i + 1, canChange, newMask, k, memo);
        }
    }
}
