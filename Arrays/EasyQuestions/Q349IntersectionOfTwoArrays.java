package Arrays.EasyQuestions;

import java.util.HashSet;

/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique 
and you may return the result in any order.

Example 1:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Example 2:
Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.
*/

public class Q349IntersectionOfTwoArrays{

    static int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> a=new HashSet<>();
        HashSet<Integer> b=new HashSet<>();

        for(int i=0;i<nums1.length;i++){
            a.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(a.contains(nums2[i]))
                 b.add(nums2[i]);
        }
        
        int arr[]=new int[b.size()];
        int k=0;
        for(int i:b){
            arr[k]=i;
            k++;
        }
        return arr;
    }
    
}