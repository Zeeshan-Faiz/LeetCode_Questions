package BitManipulation.MediumQuestions;

/*
Given an integer n, return the number of prime numbers that are strictly less than n.

Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

Example 2:
Input: n = 0
Output: 0

Example 3:
Input: n = 1
Output: 0
*/

public class Q204CountPrimes {
    
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        boolean[] notPrime = new boolean[n];
        int ans = n / 2;
        for (int i = 3; i * i < n; i += 2) {
            if (!notPrime[i]) {
                for (int j = i * i; j < n; j += 2 * i) {
                    if (!notPrime[j]) {
                        notPrime[j] = true;
                        ans--;
                    }
                }
            }
        }
        return ans;
    }
}