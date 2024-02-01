package Arrays.EasyQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Difficulty = Easy
Given an integer numRows, return the first numRows of Pascal's triangle.
In Pascal's triangle, each number is the sum of the two numbers directly above it as shown::

            1
           1 1
          1 2 1
         1 3 3 1
        1 4 6 4 1

Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]

*/

public class Q118PascalsTriangle {

    static List<List<Integer>> generate(int numRows) {

    List<List<Integer>> result = new ArrayList<>();
    if(numRows == 0)
        return result;
       
    result.add(Arrays.asList(1));
    List<Integer> resultSet;
    
    for(int i = 1; i <numRows; i++){
        resultSet = new ArrayList<>();

        //adding 1's in the corner
        resultSet.add(1);

        //finding the middle elements
        List<Integer> prevRow = result.get(i-1);
        for(int j = 1; j < i; j++){
            resultSet.add(prevRow.get(j-1) + prevRow.get(j));
        }

        //adding 1's in the corner
        resultSet.add(1);
        result.add(resultSet);
    }
    return result;
    }

    
    
}
