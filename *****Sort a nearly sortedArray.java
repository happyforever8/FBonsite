Given an array of n elements, where each element is at most k 
away from its target position, devise an algorithm that sorts 
in O(n log k) time. For example, let us consider k is 2, an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.

Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
            k = 3 
Output : arr[] = {2, 3, 5, 6, 8, 9, 10}

Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
         k = 4
Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}

complexity will be O(nk)
We can use Insertion Sort to sort the elements efficiently. Following is the C code for standard Insertion Sort.  
  
  
/* Function to sort an array using insertion sort*/
static void insertionSort(int A[], int size)
{
    int i, key, j;
    for (i = 1; i < size; i++)
    {
        key = A[i];
        j = i-1;
 
        /* Move elements of A[0..i-1], that
            are greater than key, to one
            position ahead of their current position.
            This loop will run at most k times */
        while (j >= 0 && A[j] > key)
        {
            A[j+1] = A[j];
            j = j-1;
        }
        A[j+1] = key;
    }
}
