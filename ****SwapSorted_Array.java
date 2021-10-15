static void sortByOneSwap(int arr[],int n)
{
    // Traverse the given array
    // from rightmost side
    for (int i = n - 1; i > 0; i--)
    {
   
        if (arr[i] < arr[i - 1])
        {
            // Find the other element
            // to be swapped with arr[i]
            int j = i - 1;
            while (j >= 0 && arr[i] < arr[j])
                j--;
 
            // Swap the pair
            int temp = arr[i];
            arr[i] = arr[j + 1];
            arr[j + 1] = temp;
     
            break;
        }
    }
}
 
// A utility function to
// print an array of size n
static void printArray(int arr[], int n)
{
    int i;
    for (i = 0; i < n; i++)
        System.out.print(arr[i] + " ");
    System.out.println();
}
