package StackandQueue.MediumQuestions;

import java.util.Stack;

/*
We are given an array asteroids of integers representing asteroids in a row. For each asteroid, 
the absolute value represents its size, and the sign represents its direction (positive meaning 
right, negative meaning left). Each asteroid moves at the same speed. Find out the state of the 
asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are 
the same size, both will explode. Two asteroids moving in the same direction will never meet.

Example 1:
Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

Example 2:
Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.

Example 3:
Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
*/

public class Q735AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        
        Stack<Integer> stack = new Stack<>();
        int remCount = 0;
        for (int i = 0; i < asteroids.length; i++) 
        {
            if (asteroids[i] > 0) {
                stack.push(i);
                continue;
            }
            if (stack.isEmpty()) {
                continue;
            }
            while (!stack.isEmpty()) 
            {
                int top = stack.peek();
                if (asteroids[top] < -asteroids[i]) {
                    stack.pop();
                    asteroids[top] = 0;
                    remCount++;
                } else if (asteroids[top] > -asteroids[i]) {
                    asteroids[i] = 0;
                    remCount++;
                    break;
                } else {
                    asteroids[top] = 0;
                    stack.pop();
                    asteroids[i] = 0;
                    remCount += 2;
                    break;
                }
            }
        }
        int[] arr = new int[asteroids.length - remCount];
        int cur = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] == 0) {
                continue;
            }
            arr[cur++] = asteroids[i];
        }
        return arr;
    }
}