// Last updated: 10/19/2025, 9:31:36 AM
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = target.length();
        int[] sFreq = new int[26];
        for (char c : s.toCharArray()) {
            sFreq[c - 'a']++;
        }

        if (s.length() < n) {
            return "";
        }

        for (int i = n - 1; i >= 0; i--) {
            int[] prefixFreq = new int[26];
            for (int k = 0; k < i; k++) {
                prefixFreq[target.charAt(k) - 'a']++;
            }
            
            int[] availableFreq = new int[26];
            boolean isPrefixPossible = true;
            for (int k = 0; k < 26; k++) {
                availableFreq[k] = sFreq[k] - prefixFreq[k];
                if (availableFreq[k] < 0) {
                    isPrefixPossible = false;
                    break;
                }
            }

            if (!isPrefixPossible) {
                continue;
            }
            
            int targetCharIndex = target.charAt(i) - 'a';
            for (int j = targetCharIndex + 1; j < 26; j++) {
                if (availableFreq[j] > 0) {
                    char replacementChar = (char) ('a' + j);
                    
                    StringBuilder result = new StringBuilder();
                    result.append(target.substring(0, i));
                    result.append(replacementChar);
                    
                    availableFreq[j]--;

                    for (int k = 0; k < 26; k++) {
                        result.append(String.valueOf((char)('a' + k)).repeat(availableFreq[k]));
                    }
                    
                    return result.substring(0, n);
                }
            }
        }
        return "";
    }
}