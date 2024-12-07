class Solution {
    public boolean checkIfExist(int[] arr) {
       HashSet<Integer> seen = new HashSet<>();
        
        for (int num : arr) {
            if (seen.contains(2 * num) || (num % 2 == 0 && seen.contains(num / 2))) {
                return Boolean.TRUE;
            }
            seen.add(num);
        }
        
        return Boolean.FALSE;  
    }
}