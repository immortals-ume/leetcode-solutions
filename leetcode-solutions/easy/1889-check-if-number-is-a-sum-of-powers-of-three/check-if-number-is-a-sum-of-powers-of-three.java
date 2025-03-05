class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
          if (n % 3 == 2) return false; // If remainder is 2, it's invalid
            n /= 3; // Reduce n by dividing it by 3
        }
        return true; // If no '2' was found, it's valid 
    }
}