// Last updated: 9/10/2025, 4:59:28 PM
class Solution {

    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        Set<Integer> cantCommunicate = new HashSet<>();
        for (int[] friendship : friendships) {
            Map<Integer, Integer> map = new HashMap<>();
            boolean conm = false;
            for (int lang : languages[friendship[0] - 1]) {
                map.put(lang, 1);
            }
            for (int lang : languages[friendship[1] - 1]) {
                if (map.containsKey(lang)) {
                    conm = true;
                    break;
                }
            }
            if (!conm) {
                cantCommunicate.add(friendship[0] - 1);
                cantCommunicate.add(friendship[1] - 1);
            }
        }
        int max_cnt = 0;
        int[] cnt = new int[n + 1];
        for (int friendship : cantCommunicate) {
            for (int lang : languages[friendship]) {
                cnt[lang]++;
                max_cnt = Math.max(max_cnt, cnt[lang]);
            }
        }
        return cantCommunicate.size() - max_cnt;
    }
}