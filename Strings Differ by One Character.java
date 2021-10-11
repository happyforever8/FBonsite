Given a list of strings dict where all the strings are of the same length.

Return true if there are 2 strings that only differ by 1 character in the same index, otherwise return false.

 

Example 1:

Input: dict = ["abcd","acbd", "aacd"]
Output: true
Explanation: Strings "abcd" and "aacd" differ only by one character in the index 1.
Example 2:

Input: dict = ["ab","cd","yz"]
Output: false
Example 3:

Input: dict = ["abcd","cccc","abyd","abab"]
Output: true
  
  class Solution {
    
//     replace each character in a String with a filler '*'
// and check if it already existed
// if not, add to the set.
    public boolean differByOne(String[] dict) {
        Set<String> seen = new HashSet<>();
        
        for (int i = 0; i < dict.length; i++) {
            char[] ch = dict[i].toCharArray();
            for (int j = 0; j < ch.length; j++) {
                char temp = ch[j];
                ch[j] = '*';
                if (seen.contains(String.valueOf(ch))) {
                    return true;
                }
                seen.add(String.valueOf(ch));
                ch[j] = temp;
            }
        }
        return false;
    }
}

// for (int i = 0; i < words[0].length(); i++) {
//             Set<String> s = new HashSet<>();
//             for (String w : words)
//                 if (!s.add(w.substring(0, i) + w.substring(i + 1)))
//                     return true;
//         }
//         return false;
