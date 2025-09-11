// Last updated: 9/11/2025, 11:07:38 PM
class Solution {
    public String sortVowels(String s) {
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        ArrayList<Character> ll = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                ll.add(s.charAt(i));
            }
        }
        Collections.sort(ll);
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(vowels.contains(s.charAt(i))){
                sb.append(ll.get(idx++));
            }else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}