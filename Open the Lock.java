You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.

The lock initially starts at '0000', a string representing the state of the 4 wheels.

You are given a list of deadends dead ends, meaning if the lock displays any of 
these codes, the wheels of the lock will stop turning and you will be unable to open it.

Given a target representing the value of the wheels that will unlock the lock, 
return the minimum total number of turns required to open the lock, or -1 if it is impossible.

 

Example 1:

Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
Output: 6
Explanation:
A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
because the wheels of the lock become stuck after the display becomes the dead end "0102".
Example 2:

Input: deadends = ["8888"], target = "0009"
Output: 1
Explanation:
We can turn the last wheel in reverse to move from "0000" -> "0009".
  
  
  class Solution {
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        
        Set<String> set = new HashSet<>();
        
        for (String str : deadends){
            set.add(str);
        }
        int count = 0;
        Queue<String> queue = new LinkedList<>();
        
        queue.offer(start);
        
        while (!queue.isEmpty()){
            int size = queue.size();
            
            for (int i = 0; i < size; i++){
                String curr = queue.poll();
                if (set.contains(curr)){
                    continue;
                }
                
                if (curr.equals(target)){
                    return count;
                }
                
                //List<String> canReach = helper(curr);
                
                for (String str :  helper(curr)){
                    if (!set.contains(str)){
                        queue.offer(str);
                    }
                }
            }
            count++;
        }
        return -1;
    }
    
    public List<String> helper(String lock){
        List<String> result = new ArrayList<>();
        
        char[] ch = lock.toCharArray();
        
        for (int i = 0; i < ch.length; i++){
            char c = ch[i];
            
            ch[i] = c == '9' ? '0' :(char)(c + ((char)1));
            result.add(String.valueOf(ch));
            
            ch[i] = c == '0' ? '9' : (char)(c - ((char)1));
            result.add(String.valueOf(ch));
            
            ch[i] = c;
        }
        return result;
    }
}
