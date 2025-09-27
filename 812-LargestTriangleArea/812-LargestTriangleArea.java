// Last updated: 9/27/2025, 7:02:51 PM
class Solution {
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double ans = 0;
        for(int i = 0; i < n-2; i++){
            for(int j = i+1; j < n-1; j++){
                for(int k = i + 2; k < n; k++){
                    int x1 = points[i][0], x2 = points[j][0], x3 = points[k][0];
                    int y1 = points[i][1], y2 = points[j][1], y3 = points[k][1];
                    double area = 0.5*(x1*(y2 - y3) + x2*(y3 - y1) + x3*(y1 - y2));
                    ans = Math.max(ans, Math.abs(area));
                }
            }
        }
        return ans;
    }
}