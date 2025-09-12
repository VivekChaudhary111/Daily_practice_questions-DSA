// Last updated: 9/12/2025, 10:36:01 AM
class Solution {
    public boolean doesAliceWin(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        for(int i =0 ; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                return true;
            }
        }
        return false;
    }
}