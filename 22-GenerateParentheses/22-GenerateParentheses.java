// Last updated: 9/6/2026, 11:55:28 PM
1class Solution {
2    public List<String> generateParenthesis(int n) {
3		List<String> ll = new ArrayList<>();
4		Parentheses(n, 0, 0, "", ll);
5		return ll;
6
7	}
8	public static void Parentheses(int n, int closed, int open, String ans, List<String> ll) {
9		if(open == n && closed == n) {
10//			System.out.println(ans);
11			ll.add(ans);
12			return;
13		}
14		if(open > n || closed > open) {
15			return;
16		}
17		Parentheses(n, closed, open+1, ans+"(", ll);
18		Parentheses(n, closed+1, open, ans+")", ll);
19    }
20}