mport java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Program to solve the 2 sum problem
 * Problem statement - Given an array of integers, find two numbers such that they add up to a specific target number
 * Variation to this is to return all the pairs of integers in an integer array who sum up to the target value
 * 
 * @author megha krishnamurthy
 *
 */
public class TwoSum {

Question one: find all index	
*******Find all pairs of elements in a given array that *******
	sum to the given target number. Return all the pairs of indices.
public List<List<Integer>> allPairs(int[] array, int target) {
    List<List<Integer>> ans = new ArrayList<>();
	
  // key is the arr[i], value is the list of the index
    Map<Integer, List<Integer>> hashmap = new HashMap<>();
		
    for (int i = 0; i < array.length; i++) {
      if (hashmap.containsKey(target - array[i])) {
        List<Integer> list = hashmap.get(target - array[i]);
        for (int index : list) {
          List<Integer> pair = new ArrayList<>();
          pair.add(index);
          pair.add(i);
          ans.add(pair);
        }
      }
      if (hashmap.containsKey(array[i])) {
        hashmap.get(array[i]).add(i);
      } else {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        hashmap.put(array[i], list);
      }
    }
    return ans;
  }

***************Question two, find all values pair
	
public List<List<Integer>> allPairs(int[] array, int target) {
    Arrays.sort(array);
    List<List<Integer>> ans = new ArrayList<>();
    int i = 0, j = array.length - 1;
    while (i < j) {
      while (i > 0 && array[i] == array[i - 1] && i < j) {
        i++;
      }
      while (j + 1 < array.length && array[j] == array[j + 1] && i < j) {
        j--;
      }
      if (i >= j) {
        break;
      }
      int sum = array[i] + array[j];
      if (sum == target) {
        List<Integer> pair = new ArrayList<>();
        pair.add(array[i]);
        pair.add(array[j]);
        ans.add(pair);
        i++;
        j--;
      } else if (sum < target) {
        i++;
      } else {
        j--;
      }
    }
    return ans;
  }
