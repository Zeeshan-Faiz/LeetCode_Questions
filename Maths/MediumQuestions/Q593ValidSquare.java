package Maths.MediumQuestions;

import java.util.HashSet;

/*
Given the coordinates of four points in 2D space p1, p2, p3 and p4, return true if the four points 
construct a square. The coordinate of a point pi is represented as [xi, yi]. The input is not 
given in any order. A valid square has four equal sides with positive length and four equal 
angles (90-degree angles).

Example 1:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
Output: true

Example 2:
Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
Output: false

Example 3:
Input: p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
Output: true
*/

public class Q593ValidSquare {

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {

        // Finding Distances between all the Pair of Points (All Sides and Diagonals)
        // and adding those into the set

        HashSet<Integer> set = new HashSet<>();

        set.add(findDistance(p1, p2));
        set.add(findDistance(p1, p3));
        set.add(findDistance(p1, p4));
        set.add(findDistance(p2, p3));
        set.add(findDistance(p2, p4));
        set.add(findDistance(p3, p4));

        // if Set contains only 2 values in the end
        // then those 2 values will be Length of Sides and Diagonals
        // it means that all sides are equal and Diagonals are also equal
        // so it's a Square
        // otherwise NOT a Square

        return !set.contains(0) && set.size() == 2;
    }

    public int findDistance(int[] p1, int[] p2) {

        return (p2[0] - p1[0]) * (p2[0] - p1[0]) + (p2[1] - p1[1]) * (p2[1] - p1[1]);
    }
}
