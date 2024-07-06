package Graphs.MediumQuestions;

import java.util.ArrayList;

/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You 
are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take 
course bi first if you want to take course ai.
    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return the ordering of courses you should take to finish all courses. If there are many valid 
answers, return any of them. If it is impossible to finish all courses, return an empty array.

Example 1:
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
*/

public class Q210CourseScheduleII {
    
    int[] ans;
    boolean[] taken;
    ArrayList<ArrayList<Integer>> graph;
    int ansIdx;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> prereqs = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            prereqs.add(new ArrayList<Integer>());
        }
        for (int[] p : prerequisites) {
            prereqs.get(p[0]).add(p[1]);
        }
        this.taken = new boolean[numCourses];
        this.ans = new int[numCourses];
        this.graph = prereqs;
        this.ansIdx = -1;
        // System.out.println(graph.size());
        for (int i = 0; i < numCourses; i++) {
            boolean search = dfs(i,0);
            // System.out.println(search);
            if (!search) return new int[0];
        }
        if (ansIdx > numCourses) return new int[0];
        return ans;
    }

    public boolean dfs(int course, int depth) {
        // System.out.println(depth);
        if (depth >= graph.size()) {
            // System.out.println("returning false");
            return false;
        } 
        if (taken[course]) return true;
        ArrayList<Integer> prereqs = graph.get(course);
        for (int i = 0; i < prereqs.size(); i++) {
            if (!taken[prereqs.get(i)]) {
                if (!dfs(prereqs.get(i), depth + 1)) return false;
            }
        }
        taken[course] = true;
        ansIdx++;
        if (ansIdx >= graph.size()) return false;
        ans[ansIdx] = course;
        return true;
    }
}