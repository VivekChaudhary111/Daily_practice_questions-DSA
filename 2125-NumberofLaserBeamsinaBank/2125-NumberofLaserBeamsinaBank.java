// Last updated: 10/27/2025, 11:03:37 AM
class Solution {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int lastones = 0;
        for(int i = 0; i < bank.length; i++){
            int currones = 0;
            String st = bank[i];
            for(int j = 0; j < st.length(); j++){
                if(st.charAt(j) == '1'){
                    currones++;
                }
            }
            if(currones != 0){
                ans += currones*lastones;
                lastones = currones;
            }
        }
        return ans;
    }
}