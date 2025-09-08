// Last updated: 9/8/2025, 5:25:03 PM
class Solution {
    public int countPrimes(int n) {
        if(n <= 2){
            return 0;
        }
        return PrimeSieve(n);
    }
    public static int PrimeSieve(int n) {
		boolean[] notPrimes = new boolean[n];
		notPrimes[0] = notPrimes[1] = true;
		for(int i = 2; i * i <= notPrimes.length; i++) {
			if(notPrimes[i] == false) { // i prime hai
				for(int j = 2; i * j < notPrimes.length; j++) {
					notPrimes[i*j] = true;
				}
				
			}
		}
		int count = 0;
		for(int i = 2; i < notPrimes.length; i++) {
			if(notPrimes[i] == false) {
				count++;
			}
		}
		return count;
	}
}