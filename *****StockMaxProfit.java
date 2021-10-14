Design an algorithm to find the maximum profit. 
You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).

Examples

Input: [7,1,5,3,6,4]
Output: 7
Explanation: 
   - buy on day-2, sell on day-3. Profit (5-1) = 4
   - buy on day-4, sell on day-5. Profit (6-3) = 3

     
 //If you look closely, we can keep track of low points,
   //and following high point. And take a sum of such points. We can get the maximum profit.
public int maxProfit_better(int[] prices) {
   if (prices == null || prices.length == 0) {
      return 0;
   }
   int max = 0;
   int i=0;
   
   int lowPrice = prices[i];
   int highPrice = prices[i];
   i++;
   
   while (i < prices.length) {
      //find low value
      while (i < prices.length && prices[i-1] >= prices[i]) {
         i++;
      }
      lowPrice = prices[i-1];
      
      //find high value
      while (i<prices.length && prices[i] >= prices[i-1]) {
         i++;
      }
      highPrice = prices[i-1];
      
      max += (highPrice - lowPrice);
   }
   
   return max;
}


public int maxProfit_better2(int[] prices) {
   if (prices == null || prices.length == 0) {
      return 0;
   }
   int max = 0;
   
   for (int i=1; i<prices.length; i++) {
      if (prices[i] > prices[i-1]) {
         max += (prices[i] - prices[i-1]);
      }
   }
   
   return max;
}
