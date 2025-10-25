// Last updated: 10/25/2025, 9:01:27 PM
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        int numDigits = num;
        int s = sum;

        if (s > numDigits * 9) {
            return "";
        }
        
        if (s < 1) {
             return "";
        }

        int drevantor = s;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numDigits; i++) {
            
            int remDigitsLeft = numDigits - 1 - i;
            int maxPossibleRemSum = remDigitsLeft * 9;

            int minDigitNeeded = Math.max(0, drevantor - maxPossibleRemSum);
            int maxDigitPossible = Math.min(9, drevantor);

            int digitToPlace = maxDigitPossible;
            
            ans.append(digitToPlace);
            
            drevantor -= digitToPlace; 
        }
        
        if (drevantor != 0) {
            return "";
        }

        return ans.toString();
    }
}