// tim is o(nlogk)
/// SPACE IS o(N)
public class Solution {
    /**
     * @param arrays: k sorted integer arrays
     * @return: a sorted array
     */
    public int[] mergekSortedArrays(int[][] arrays) {
        // write your code here
          if (arrays == null || arrays.length == 0 || arrays[0].length ==0 ){
              return new int[0];
          }
         return helper(arrays, 0, arrays.length - 1);
    }
    public int[] helper(int[][] arrays, int start, int end){
        if (start >= end){
            return arrays[start];
        }
        
        int mid = start + (end - start) / 2;
        
        int[] left = helper(arrays, start, mid);
        int[] right = helper(arrays, mid + 1, end);
        
        return merge(left, right);
    }
    
    public int[] merge(int[] arr1, int[] arr2){
        
        int[] result = new int[arr1.length + arr2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        
        while (i < arr1.length  && j < arr2.length){
            if (arr1[i] < arr2[j]){
                result[index++] = arr1[i++];
            } else {
                result[index++] = arr2[j++];
            }
        }
        while (i < arr1.length){
            result[index++] = arr1[i++];
        }
        while (j < arr2.length){
            result[index++] = arr2[j++];
        }
        
        return result;
    }
}
