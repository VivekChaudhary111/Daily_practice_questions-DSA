// Last updated: 10/12/2025, 8:48:51 AM
class Solution {
    public int longestBalanced(String s) {
        int maxlen = 0;
        for(int i = 0; i < s.length(); i++){
            int[] freq = new int[26];
            for(int j = i; j < s.length(); j++){
                freq[s.charAt(j) - 'a']++;
                if(isValid(freq)){
                    maxlen = Math.max(maxlen,j - i + 1);
                }
            }
        }
        return maxlen;
    }
    public static boolean isValid(int[] freq){
        int first = -1;
        for(int f : freq){
            if(f > 0){
                if(first == -1){
                    first = f;
                }
                else if(f != first) return false;
            }
        }
        return true;
    }
}