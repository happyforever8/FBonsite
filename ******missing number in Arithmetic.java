Given an array that represents elements of arithmetic progression in order. One element is missing in the progression, find the missing number. 

Input: arr[]  = {2, 4, 8, 10, 12, 14}
Output: 6

Input: arr[]  = {1, 6, 11, 16, 21, 31};
Output: 26

class GFG
{
     
// A binary search function that
// returns the missing
// element in arithmetic
// progression
static int findMissingUtil(int arr[], int low,
                           int high, int diff)
{   
      // Find index of middle element
    int mid;
    while (low <= high)
    {   
          // find index of middle element
        mid = (low + high) / 2;
          // if mid == (nth position of element in AP)-1
          // the missing element will exist in right half
        if ((arr[mid] - arr[0]) / diff == mid)
            low = mid + 1;
        else
        // the missing element will exist in left half
            high = mid - 1;
    }

    return arr[high] + diff;
}
 

static int findMissing(int arr[], int n)
{

    int diff = (arr[n - 1] - arr[0]) / n;
 
    // Binary search for the missing
    // number using above calculated diff
    return findMissingUtil(arr, 0, n - 1, diff);
}
 
// Driver Code
public static void main (String[] args)
{
    int arr[] = {2, 4, 8, 10, 12, 14};
    int n = arr.length;
    System.out.println("The missing element is "+  
                            findMissing(arr, n));
}
