Given an array of characters chars, compress it using the following algorithm:

Begin with an empty string s. For each group of consecutive repeating characters in chars:

If the group's length is 1, append the character to s.
Otherwise, append the character followed by the group's length.
The compressed string s should not be returned separately, but instead, be stored in the input character array chars. Note that group lengths that are 10 or longer will be split into multiple characters in chars.

After you are done modifying the input array, return the new length of the array.

You must write an algorithm that uses only constant extra space.
 

Example 1:

Input: chars = ["a","a","b","b","c","c","c"]
Output: Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
Explanation: The groups are "aa", "bb", and "ccc". This compresses to "a2b2c3".
  
  
  class Solution {
    public int compress(char[] chars) {
        // time is O(N)
        // space is O(1)
        if (chars == null || chars.length == 0){
            return 0;
        }
        int resultIndex = 0;
        int index = 0;
        
        while (index < chars.length){
            char ch = chars[index];
            
            int count = 0;
            
            while (index < chars.length && chars[index] == ch){
                count++;
                index++;
            }
            chars[resultIndex++] = ch;
            
            if (count != 1){
                String str = String.valueOf(count);
                
                for (char c : str.toCharArray()){
                    chars[resultIndex++] = c;
                }
            }
        }
        return resultIndex;
    }
}
//// Decode string =================
Input: s = "3[a]2[bc]"
Output: "aaabcbc"

 
 class Solution {
    
    // tims is o(n * maxK)
    // n is length of String, maxK is max value of num
    // space is o(n)
    public String decodeString(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        Queue<Character> queue = new LinkedList<>();
        
        for (char ch : s.toCharArray()){
            queue.offer(ch);
        }
        return helper(queue);
        
    }
    
    public String helper(Queue<Character> queue){
        if (queue.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int num = 0;
        
        while (!queue.isEmpty()){
            char ch = queue.poll();
            
            if (ch >= '0' && ch <= '9'){
                num = num * 10 + (ch - '0');
            } else if (ch == '['){
                String sub = helper(queue);
                for (int i = 0; i < num; i++){
                    sb.append(sub);
                }
                num = 0;
            } else if (ch == ']'){
                break;
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
