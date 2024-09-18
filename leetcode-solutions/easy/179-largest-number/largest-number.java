class Solution {
    public String largestNumber(int[] nums) {
         // Convert the integers to strings
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort strings using custom comparator
        Arrays.sort(strNums, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                // Compare based on which concatenation gives a larger number
                String order1 = a + b;
                String order2 = b + a;
                return order2.compareTo(order1);  // reverse order to get descending sort
            }
        });

        // If the largest number is '0', return '0'
        if (strNums[0].equals("0")) {
            return "0";
        }

        // Join the sorted numbers into a single string
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strNums) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
}