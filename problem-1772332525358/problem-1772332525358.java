// Last updated: 3/1/2026, 8:05:25 AM
1class Solution {
2    public String trimTrailingVowels(String s) {
3        Set<Character> set = Set.of('a','e','i','o','u');
4        for(int i = s.length()-1; i >= 0; i--){
5            if(!set.contains(s.charAt(i))){
6                return s.substring(0, i+1);
7            }
8        }
9        return "";
10    }
11}