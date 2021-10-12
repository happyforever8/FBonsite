=============Method one===========
  merge two a time
  time is O(m+n+o)
  space is :O(m+n)
  static ArrayList<Integer> mergeTwo(List<Integer> A,
                                       List<Integer> B)
    {
        // Get sizes of vectors
        int m = A.size();
        int n = B.size();
 
        // ArrayList for storing Result
        ArrayList<Integer> D = new ArrayList<Integer>(m + n);
 
        int i = 0, j = 0;
        while (i < m && j < n) {
 
            if (A.get(i) <= B.get(j))
                D.add(A.get(i++));
            else
                D.add(B.get(j++));
        }
 
        // B has exhausted
        while (i < m)
            D.add(A.get(i++));
 
        // A has exhausted
        while (j < n)
            D.add(B.get(j++));
 
        return D;
    }
 
    // Driver code
    public static void main(String[] args)
    {
        Integer[] a = { 1, 2, 3, 5 };
        Integer[] b = { 6, 7, 8, 9 };
        Integer[] c = { 10, 11, 12 };
        List<Integer> A = Arrays.asList(a);
        List<Integer> B = Arrays.asList(b);
        List<Integer> C = Arrays.asList(c);
 
        // First Merge A and B
        ArrayList<Integer> T = mergeTwo(A, B);
 
        // Print Result after merging T with C
        System.out.println(mergeTwo(T, C));
    }
}


=============Method two==========
  
  space is O(m+n+o)
  time is O(1)
  
  public static void main(String[] args)
    {
        int A[] = { 1, 2, 41, 52, 84 };
        int B[] = { 1, 2, 41, 52, 67 };
        int C[] = { 1, 2, 41, 52, 67, 85 };
 
        // call the function to sort and print the sorted numbers
        merge3sorted(A, B, C);
    }
 
    // Function to merge three sorted arrays
    // A[], B[], C[]: input arrays
    static void merge3sorted(int A[], int B[], int C[])
    {
        // creating an empty list to store sorted numbers
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = 0, k = 0;
 
        // using merge concept and trying to find
        // smallest of three while all three arrays
        // contains at least one element
        while (i < A.length && j < B.length && k < C.length) {
            int a = A[i];
            int b = B[j];
            int c = C[k];
            if (a <= b && a <= c) {
                list.add(a);
                i++;
            }
            else if (b <= a && b <= c) {
                list.add(b);
                j++;
            }
            else {
                list.add(c);
                k++;
            }
        }
        // next three while loop is to sort two
        // of arrays if one of the three gets exhausted
        while (i < A.length && j < B.length) {
            if (A[i] < B[j]) {
                list.add(A[i]);
                i++;
            }
            else {
                list.add(B[j]);
                j++;
            }
        }
        while (j < B.length && k < C.length) {
            if (B[j] < C[k]) {
                list.add(B[j]);
                j++;
            }
            else {
                list.add(C[k]);
                k++;
            }
        }
        while (i < A.length && k < C.length) {
            if (A[i] < C[k]) {
                list.add(A[i]);
                i++;
            }
            else {
                list.add(C[k]);
                k++;
            }
        }
 
        // if one of the array are left then
        // simply appending them as there will
        // be only largest element left
        while (i < A.length) {
            list.add(A[i]);
            i++;
        }
        while (j < B.length) {
            list.add(B[j]);
            j++;
        }
        while (k < C.length) {
            list.add(C[k]);
            k++;
        }
       
        // finally print the list
        for (Integer x : list)
            System.out.print(x + " ");
    } // merge3sorted closing braces
}
 
