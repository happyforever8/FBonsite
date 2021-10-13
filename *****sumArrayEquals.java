    public int subarraySum(int[] nums, int k, int n) {
        // using hashmap to store the sum and 
        // the amount of the sum
        
        // time Complexity is O(N)
        // space Complexity is O(N)
        
        // the key is the sum
        // the value is the total acount of the sum
        Map<Integer, Integer> map = new HashMap<>();
        
        // the sum zero has the amount of 1
        map.put(0, 1);
        int sum = 0;
        
        int result = 0;
        
        for (int i = 0; i < nums.length; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                result += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            
        }
       return result == n;
     //   return result;
    }
}
