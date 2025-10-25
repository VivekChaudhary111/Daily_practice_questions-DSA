// Last updated: 10/25/2025, 8:51:53 PM
class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String bestResult = new StringBuilder(s).reverse().toString();

        for (int k = 1; k <= n; k++) {
            String pre = s.substring(0, k);
            String suf = s.substring(k);
            
            String reversedPrefix = new StringBuilder(pre).reverse().toString();
            String newString = reversedPrefix + suf;
            
            if (newString.compareTo(bestResult) < 0) {
                bestResult = newString;
            }
        }

        for (int k = 1; k <= n; k++) {
            String pre = s.substring(0, n - k);
            String suf = s.substring(n - k);
            
            String reversedSuffix = new StringBuilder(suf).reverse().toString();
            String newString = pre + reversedSuffix;
            
            if (newString.compareTo(bestResult) < 0) {
                bestResult = newString;
            }
        }
        
        return bestResult;
    }
}