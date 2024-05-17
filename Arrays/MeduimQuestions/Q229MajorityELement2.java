package Arrays.MeduimQuestions;

import java.util.ArrayList;
import java.util.List;

/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Example 1:
Input: nums = [3,2,3]
Output: [3]

Example 2:
Input: nums = [1]
Output: [1]

Example 3:
Input: nums = [1,2]
Output: [1,2]
*/

public class Q229MajorityELement2 {

    public List<Integer> majorityElement(int[] v) {
        
        int n = v.length;

        int cnt1 = 0, cnt2 = 0;
        int el1 = Integer.MIN_VALUE;
        int el2 = Integer.MIN_VALUE;

        // applying the Extended Boyer Moore's Voting Algorithm:
        for (int i = 0; i < n; i++) 
        {
            if (cnt1 == 0 && el2 != v[i]) {
                cnt1 = 1;
                el1 = v[i];
            } 
            else if (cnt2 == 0 && el1 != v[i]) {
                cnt2 = 1;
                el2 = v[i];
            } 
            else if (v[i] == el1)
                cnt1++;
            else if (v[i] == el2)
                cnt2++;
            else {
                cnt1--;
                cnt2--;
            }
        }

        List<Integer> ls = new ArrayList<>();

        // Manually check if the stored elements in el1 and el2 are the majority elements:
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el1)
                cnt1++;
            if (v[i] == el2)
                cnt2++;
        }

        int mini = (int) (n / 3) + 1;
        if (cnt1 >= mini)
            ls.add(el1);
        if (cnt2 >= mini)
            ls.add(el2);

        return ls;
    }
}