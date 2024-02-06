package Strings.EasyQuestions;

/*
You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you 
have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also 
jewels.
Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:
Input: jewels = "aA", stones = "aAAbbbb"
Output: 3

Example 2:
Input: jewels = "z", stones = "ZZ"
Output: 0
*/

public class Q771JewelsAndStones {

    static int numJewelsInStones(String jewels, String stones) {
        
        int count = 0;
        for(char x: stones.toCharArray()){
            //If the resultant int produced by indexOf method is not equal to -1, meaning jewel string contains the char then increase count by 1.
            if( jewels.indexOf(x) != -1) count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        
        System.out.println(numJewelsInStones("aA", "aAAbbb"));
    }
}
