class Solution {
    final long MOD = (long)1e9+7;
    public int[] productQueries(int n, int[][] queries) {
        int len = queries.length;
        List<Integer> powers = new ArrayList<>();
        int[] ans = new int[len];
        int pos = 0;
        while(n > 0){
            if(n % 2 != 0){
                powers.add((int)Math.pow(2, pos));
            }
            n /= 2;
            pos++;
        }
        pos = 0;
        for(int i = 0; i < len; i++){
            int low = queries[i][0];
            int high = queries[i][1];
            long subsum = powers.get(low++);
            while(low <= high){
                subsum = subsum * powers.get(low)%MOD;
                low++;
            }
            ans[pos++] = (int)subsum;
        }
        return ans;
    }
}
