package StackandQueue.MediumQuestions;

/*
Design an algorithm that collects daily price quotes for some stock and returns the span of that 
stock's price for the current day.
The span of the stock's price in one day is the maximum number of consecutive days (starting from 
that day and going backward) for which the stock price was less than or equal to the price of that 
day.
    For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
    Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.

Implement the StockSpanner class:
    StockSpanner() Initializes the object of the class.
    int next(int price) Returns the span of the stock's price given that today's price is price.

Example 1:
Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]
*/

public class Q901OnlineStockSpan {
    
    int N = 10000;
    int cur, tt;
    int[] stk, stock;

    public Q901OnlineStockSpan() {
        cur = 0;
        tt = -1;
        stk = new int[N];
        stock = new int[N];
    }
    
    public int next(int price) {
        while(tt >= 0 && price >= stock[stk[tt]]) {
            tt--;
        }
        int res = tt < 0 ? cur + 1 : cur - stk[tt];
        stk[++tt] = cur;
        stock[cur++] = price;
        return res;
    }
}