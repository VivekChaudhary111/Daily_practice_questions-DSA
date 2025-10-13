// Last updated: 10/13/2025, 8:07:13 AM
class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        int i = 0;
        int[] freqi = new int[26];
        for(int k = 0; k < words[i].length(); k++){
            freqi[words[i].charAt(k)-'a']++;
        }
        for(int j = 1; j < words.length; j++){
            int[] freqj = new int[26];
            for(int k = 0; k < words[j].length(); k++){
                freqj[words[j].charAt(k)-'a']++;
            }
            if(words[j].length() != words[i].length()){
                ans.add(words[j]);
                i=j;
                freqi = freqj;
            }else{
                if(Arrays.equals(freqi, freqj)){
                    continue;
                }else{
                    ans.add(words[j]);
                    i=j;
                    freqi = freqj;
                }
            }
        }
        return ans;
    }
}