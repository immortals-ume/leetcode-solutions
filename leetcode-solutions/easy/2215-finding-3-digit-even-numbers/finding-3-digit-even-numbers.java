class Solution {
    public int[] findEvenNumbers(int[] digits) {
        Set<Integer> result = new TreeSet<>();
        int[] count = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            count[digit]++;
        }

        // Try every 3-digit number from 100 to 998
        for (int i = 100; i <= 999; i += 2) { // step by 2 since it must be even
            int a = i / 100;
            int b = (i / 10) % 10;
            int c = i % 10;

            int[] tempCount = new int[10];
            tempCount[a]++;
            tempCount[b]++;
            tempCount[c]++;

            boolean valid = true;
            for (int d = 0; d <= 9; d++) {
                if (tempCount[d] > count[d]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                result.add(i);
            }
        }

        // Convert result set to array
        int[] res = new int[result.size()];
        int idx = 0;
        for (int num : result) {
            res[idx++] = num;
        }
        return res;
    }
}