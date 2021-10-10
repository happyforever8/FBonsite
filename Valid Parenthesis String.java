Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

The following rules define a valid string:

Any left parenthesis '(' must have a corresponding right parenthesis ')'.
Any right parenthesis ')' must have a corresponding left parenthesis '('.
Left parenthesis '(' must go before the corresponding right parenthesis ')'.
'*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".
 

Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "(*)"
Output: true
Example 3:

Input: s = "(*))"
Output: true
  
  class Solution {
    
    // time is O(n)
    // space is O(1)
    public boolean checkValidString(String s) {
        int leftCount = 0;
        int rightCount = 0;
        
        int leftStart = 0;
        int rightStart = 0;
        
        for (char ch : s.toCharArray()){
            if (ch == '('){
                leftCount++;
            } else if (ch == '*'){
                leftStart++;
            } else if (ch == ')'){
                if (leftCount > 0){
                    leftCount--;
                } else if (leftStart > 0){
                    leftStart--;
                } else {
                    // in this case,
                    // there is no left ( and start
                    // can return false;
                    return false;
                }
            }
        }
        // right part should starts from s.length() - 1
        for (int j = s.length() - 1; j >= 0; j--){
            char ch = s.charAt(j);
            if (ch == ')'){
                rightCount++;
            } else if (ch == '*'){
                rightStart++;
            } else if (ch == '('){
                if (rightCount > 0){
                    rightCount--;
                } else if (rightStart > 0){
                    rightStart--;
                } else {
                    return false;
                }
            }
        }
        
        return (leftStart >= leftCount) && (rightStart >= rightCount);
    }
}
