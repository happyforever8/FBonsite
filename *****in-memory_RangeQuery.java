VO的其中一coding round，三姐，第二题：

We are trying to build simple naive in-memory data store. 
Data store always receives unique integer in a random order which should be stored to support range sum query.
Data store supports:
a> write to the data store which stores the incoming integer.
b> query for a sum between range of integer (min, max) inclusive.
Pick a data structure focused on optimizing queries for average cases.
For simplicity lets only implement query opertaion
fetch_sum_with_in_range(min, max) assuming writes are handled.

E.g: Random integers in the data store at time t1:
6, 2, 3, 7, 8, 9, 4
at time t2 fetch_sum_with_in_range(3, 7) returns 20
2, 3, 4, 6, 7, 8,  9 = 20

快速地看了题目，刚开始以为要implement，bla bla讲了一些，后来提醒看题目，
当看到data ‍‍‍‍‍‍‍‍‌‍‌‌‍‌‌‌‌‌structure后有点傻了，不知道她想要什么。想跟recruiter反应一下这个不像是coding question

 class Node {
        public Node left;
        public Node right;
        public int start;
        public int end;
        public int sum;
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }
   
    private Node root;
    public Solution(int[] nums) {
        root = buildTree(nums,0,nums.length-1);
    }
   
    private Node buildTree(int[] nums, int start, int end) {
        if (start > end) return null;
        Node node = new Node(start, end);
        if (start == end) {
            node.sum = nums[start];
        } else {
            int mid = (start + end) >> 1;
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid+1, end);
            node.sum = node.left.sum + node.right.sum;
        }
        return node;
    }
   
    public void update(int i, int val) {
        update(root,i,val);
    }
   
    private void update(Node root, int i, int val) {
        if (root.start == i && root.end == i) {
            root.sum = val;
            return;
        }
        int mid = (root.start + root.end) / 2;
        if (i<=mid) {
            update(root.left, i, val);
        } else {
            update(root.right, i, val);
        }
        root.sum = root.left.sum+root.right.sum;
    }
   
    private int sumRange(Node root, int left, int right) {
        if (left>right || root == null) return 0;
        if (root.start==left && root.end==right) return root.sum;
        int mid = (root.start+root.end)>>1;
        return sumRange(root.left,left,mid)+sumRange(root.right,mid+1,right);
    }
   
    public int sumRange(int i, int j) {
        return sumRange(root,i,j);
    }
