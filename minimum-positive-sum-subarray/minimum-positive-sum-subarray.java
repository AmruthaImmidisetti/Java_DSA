class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();

        int[] p = new int[n + 1];

        for (int i = 0; i < n; i++) {
            p[i + 1] = p[i] + nums.get(i);
        }

        int mm = Integer.MAX_VALUE;

        for (int i = l; i <= r; i++) {
            for (int j = 0; j <= n - i; j++) {
                int sum = 0;

                for (int k = j; k < j + i; k++) {
                    sum += nums.get(k);
                }

                if (sum > 0) {
                    mm = Math.min(mm, sum);
                }
            }
        }

        return mm == Integer.MAX_VALUE ? -1 : mm;
    }
}
