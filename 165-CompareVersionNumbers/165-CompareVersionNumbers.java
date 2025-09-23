// Last updated: 9/23/2025, 8:14:02 AM
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");
        int n1 = s1.length;
        int n2 = s2.length;
        if(n1 <= n2){
            for(int i = 0; i < n1; i++){
                int num1 = Integer.parseInt(s1[i]);
                int num2 = Integer.parseInt(s2[i]);
                if(num1 < num2) return -1;
                if (num1 > num2) return 1;
            }
            for(int j = n1; j < n2; j++){
                if(Integer.parseInt(s2[j]) > 0) return -1;
            }
            return 0;
        }
        else{
            for(int i = 0; i < n2; i++){
                int num1 = Integer.parseInt(s1[i]);
                int num2 = Integer.parseInt(s2[i]);
                if(num1 < num2) return -1;
                if (num1 > num2) return 1;
            }
            for(int j = n2; j < n1; j++){
                if(Integer.parseInt(s1[j]) > 0) return 1;
            }
            return 0;
        }
    }
}