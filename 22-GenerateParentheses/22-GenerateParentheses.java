// Last updated: 9/24/2026, 9:22:14 PM
1class Solution {
2    public List<String> generateParenthesis(int n) {
3		List<String> ll = new ArrayList<>();
4		Parentheses(n, 0, 0, "", ll);
5		return ll;
6
7	}
8	public static void Parentheses(int n, int closed, int open, String ans, List<String> ll) {
9		if(open == n && closed == n) {
10			ll.add(ans);
11			return;
12		}
13		if(open < n)
14		    Parentheses(n, closed, open+1, ans+"(", ll);
15        if(closed < open)
16		    Parentheses(n, closed+1, open, ans+")", ll);
17    }
18}