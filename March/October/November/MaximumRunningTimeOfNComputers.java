class Solution {
    public long maxRunTime(int n, int[] arr) {
        Arrays.sort(arr);
        long total = Arrays.stream(arr).reduce(0, (a, c) -> a + c);

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] <= total / n) break;
            total -= arr[i];
            n--;
        }

        return total / n;
    }
}
