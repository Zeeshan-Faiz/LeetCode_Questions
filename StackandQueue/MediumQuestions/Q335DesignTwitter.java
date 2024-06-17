package StackandQueue.MediumQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Design a simplified version of Twitter where users can post tweets, follow/unfollow another user, 
and is able to see the 10 most recent tweets in the user's news feed.

Implement the Twitter class:
    Twitter() Initializes your twitter object.
    void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId by the user 
    userId. Each call to this function will be made with a unique tweetId.
    List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in the user's 
    news feed. Each item in the news feed must be posted by users who the user followed or by the 
    user themself. Tweets must be ordered from most recent to least recent.
    void follow(int followerId, int followeeId) The user with ID followerId started following the 
    user with ID followeeId.
    void unfollow(int followerId, int followeeId) The user with ID followerId started unfollowing 
    the user with ID followeeId.

Example 1:
Input
["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
[[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
Output
[null, null, [5], null, null, [6, 5], null, [5]]
Explanation
Twitter twitter = new Twitter();
twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
twitter.follow(1, 2);    // User 1 follows user 2.
twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
twitter.unfollow(1, 2);  // User 1 unfollows user 2.
twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
*/

public class Q335DesignTwitter {

    class Node {
        int userId;
        int tweetId;
        Node next;
        Node prev;

        Node(int userId, int tweetId) {
            this.userId = userId;
            this.tweetId = tweetId;
        }
    }

    class Twitter {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);

        public Twitter() {
            head.next = tail;
            tail.prev = head;
        }

        public boolean valid(Node curr, int userId) {
            if (curr.userId == userId)
                return true;
            List<Integer> temp = map.get(curr.userId);
            if (temp == null)
                return false;
            for (int ele : temp) {
                if (ele == userId)
                    return true;
            }
            return false;
        }

        public void postTweet(int userId, int tweetId) {
            Node curr = new Node(userId, tweetId);
            insertFirst(curr);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<Integer> tweets = new ArrayList<>();
            Node curr = head.next;
            while (curr != tail) {
                if (valid(curr, userId) && tweets.size() < 10)
                    tweets.add(curr.tweetId);
                curr = curr.next;
            }
            return tweets;
        }

        public void follow(int followerId, int followeeId) {
            
            if (!map.containsKey(followeeId))
                map.put(followeeId, new ArrayList<>());

            ArrayList<Integer> temp = map.get(followeeId);
            temp.add(followerId);
            map.put(followeeId, temp);

        }

        public void unfollow(int followerId, int followeeId) {
            
            ArrayList<Integer> temp = map.get(followeeId);
            if (temp == null)
                return;
            temp.remove((Integer) followerId);
            map.put(followeeId, temp);
        }

        public void insertFirst(Node curr) {
            curr.next = head.next;
            head.next = curr;
            curr.next.prev = curr;
            curr.prev = head;
        }
    }
}