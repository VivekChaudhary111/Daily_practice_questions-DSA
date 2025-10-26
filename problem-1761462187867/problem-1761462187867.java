// Last updated: 10/26/2025, 12:33:07 PM
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

        int dis = s;

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < numDigits; i++) {
            
            int remDigitsLeft = numDigits - 1 - i;
            int maxPossibleRemSum = remDigitsLeft * 9;

            int minDigitNeeded = Math.max(0, dis - maxPossibleRemSum);
            int maxDigitPossible = Math.min(9, dis);

            int digitToPlace = maxDigitPossible;
            
            ans.append(digitToPlace);
            
            dis -= digitToPlace; 
        }
        
        if (dis != 0) {
            return "";
        }

        return ans.toString();
    }
}