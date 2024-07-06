package Graphs.MediumQuestions;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. 
You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must 
take course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
*/

public class Q207CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        if (numCourses == 0)
            return true;
        
        int[] course = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            course[prerequisites[i][1]]++;
        }
        boolean visited[] = new boolean[prerequisites.length];
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < prerequisites.length; i++) {
                if (!visited[i]) {
                    if (course[prerequisites[i][0]] == 0) {
                        visited[i] = true;
                        course[prerequisites[i][1]]--;
                        flag = true;
                    }
                }
            }
        }
        for (int i = 0; i < numCourses; i++) {
            if (course[i] != 0)
                return false;
        }
        return true;
    }
}