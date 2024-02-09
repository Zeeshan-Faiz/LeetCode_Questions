package BinarySearch.EasyQuestions;

/*
An array arr is a mountain if the following properties hold:

    arr.length >= 3
    There exists some i with 0 < i < arr.length - 1 such that:
        arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
        arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

Given a mountain array arr, return the index i such that arr[0] < arr[1] < ... < arr[i - 1] < arr[i] > arr[i + 1] >
 ... > arr[arr.length - 1].

You must solve it in O(log(arr.length)) time complexity.
*/

public class Q852PeakIndexInMountainArray {

    static int peakIndexInMountainArray(int[] arr) {

        int start = 0;
        int end = arr.length - 1;
        int mid = -1;

        while(start < end){
            
            mid = (start+end)/2;
            if(arr[mid] > arr[mid+1])
                //we are in descending part
                end = mid;
            else
                //we are in ascending part
                start = mid + 1;
        }
        return start;   
    }

    public static void main(String[] args) {
        
        System.out.println(peakIndexInMountainArray(new int[] {0,1,0}));
    }
}
