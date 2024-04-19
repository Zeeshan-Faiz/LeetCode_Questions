package Maths.MediumQuestions;

/*
Given two numbers, hour and minutes, return the smaller angle (in degrees) formed between the 
hour and the minute hand. Answers within 10-5 of the actual value will be accepted as correct.

Example 1:
Input: hour = 12, minutes = 30
Output: 165

Example 2:
Input: hour = 3, minutes = 30
Output: 75

Example 3:
Input: hour = 3, minutes = 15
Output: 7.5
*/

public class Q1344AnglesBetweenHandsOfClock {
    
    public double angleClock(int hour, int minutes) {
        int totalMinutes=hour*60+minutes;
       double hourAngle=totalMinutes*0.5;
       double minuteAngle=minutes*6;
       if(hourAngle>=360)
           hourAngle=hourAngle-360;
       double ans=Math.abs(minuteAngle-hourAngle);
       if(ans>180.00)
           ans=360.00-ans;
       return ans;
   }
}