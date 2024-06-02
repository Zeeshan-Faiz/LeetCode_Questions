package BinarySearch.MediumQuestions;

/*
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of 
bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all 
of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Example 1:
Input: piles = [3,6,7,11], h = 8
Output: 4

Example 2:
Input: piles = [30,11,23,4,20], h = 5
Output: 30

Example 3:
Input: piles = [30,11,23,4,20], h = 6
Output: 23
*/

public class Q875KokoEatingBananas {
    
    public int minEatingSpeed(int[] piles, int h) {
        long sum = 0;
        for (int n : piles) {
            sum += n;
        }
        int l = (int) Math.ceilDiv(sum, h);
        int r = (int) Math.ceilDiv(sum, h - piles.length + 1);
        while (l < r) {
            int m = (l + r) / 2;
            int hours = 0;
            for (int p : piles) {
                hours += (p + m - 1) / m;
                if (hours > h) {
                    break;
                }
            }
            if (hours <= h) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}