import java.util.ArrayList;
import java.util.*;

class Solution {
    public String getPermutation(int n, int k) {
        // index = (k - 1) / (n - 1)!
        // k = (k - 1) % (n - 1)! + 1

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            nums.add(i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            long fact = factorial(n - i);

            int index = (int) ((k - 1) / fact);
            sb.append(nums.get(index));
            nums.remove(index);

            k = (int) ((k - 1) % fact + 1);
        }

        return sb.toString();
    }

    static long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++) {
            res *= i;
        }
        return res;
    }
}