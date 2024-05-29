package StackandQueue.MediumQuestions;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
Implement the MinStack class:
    MinStack() initializes the stack object.
    void push(int val) pushes the element val onto the stack.
    void pop() removes the element on the top of the stack.
    int top() gets the top element of the stack.
    int getMin() retrieves the minimum element in the stack.

You must implement a solution with O(1) time complexity for each function.

Example 1:
Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]
Output
[null,null,null,null,-3,null,0,-2]
*/

public class Q155MinStack {

    private int[] arr;
    private int size;
    private int[] lowestNumbers;
    private int lowestNumbersSize;

    public Q155MinStack() {
        size = 0;
        lowestNumbers = new int[8];
        lowestNumbers[0] = Integer.MIN_VALUE;
        arr = new int[8];
        lowestNumbersSize = 0;
    }

    public void push(int val) {
        if (size == arr.length) {
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                newArr[i] = arr[i];
            }
            this.arr = newArr;
        }
        arr[size] = val;
        size++;
        if (lowestNumbersSize == 0 || val <= lowestNumbers[lowestNumbersSize - 1]) {
            if (lowestNumbersSize == lowestNumbers.length) {
                int[] newArr = new int[arr.length * 2];
                for (int i = 0; i < arr.length; i++) {
                    newArr[i] = arr[i];
                }
                this.lowestNumbers = newArr;
            }
            lowestNumbers[lowestNumbersSize] = val;
            lowestNumbersSize++;
        }
    }

    public void pop() {
        int numberToPop = arr[size - 1];
        if (lowestNumbers[lowestNumbersSize - 1] == numberToPop)
            lowestNumbersSize--;
        size--;
    }

    public int top() {
        return arr[size - 1];
    }

    public int getMin() {
        return lowestNumbers[lowestNumbersSize - 1];
    }
}