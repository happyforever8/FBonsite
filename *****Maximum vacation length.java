Variation of https://leetcode.com/problems/max-consecutive-ones-iii/
Given boolean array of days at work, [T, F, T, T, F, F, F, T] and 
pto (number of PTOs one can take) - where boolean T means paid holiday 
and F means you can take a PTO. Find the maximum length of vacation an employee can take.

int findMaxVacationLength(year = [F, T, F, T, F, T, F, ], pto = 2) 
  should return 5 because if we take PTO on indices year[2] and year[4], 
then we can get the maximum length vacation (consecutive T's).
                                             
                                             
public int findMaxVacationLength(boolean[] days, int pto) {
    int counter = 0;
    int start = 0;
    int len = 0;

    for (int end = 0; end < days.length; end++) {
      if (!days[end]) {
        counter++;
      }

      while (counter > pto) {
        if (!days[start]) {
          counter--;
        }

        start++;
      }

      len = Math.max(len, end - start + 1);
    }

    return len;
  }                                             
        
                                                                                                                  
