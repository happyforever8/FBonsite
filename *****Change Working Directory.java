Given current directory and change directory path, return final path.

For Example:

Curent                 Change            Output

/                    /facebook           /facebook
/facebook/anin       ../abc/def          /facebook/abc/def
/facebook/instagram   ../../../../.      /
public class SimplifyPathII {

    public static void main(String[] args) {

        SimplifyPathII s = new SimplifyPathII();

        String current1 = "/";
        String change1 = "/facebook ";
        System.out.println(s.simplifyPath(current1, change1)); //ans: /facebook

        String current2 = "/facebook/anin";
        String change2 = "../abc/def";
        System.out.println(s.simplifyPath(current2, change2)); //ans: /facebook/abc/def

        String current3 = "/facebook/instagram";
        String change3 = "../../../../.";
        System.out.println(s.simplifyPath(current3, change3)); //ans: /
    }

    private static final String CURRENT_DIRECTORY = ".";

    private static final String PREVIOUS_DIRECTORY = "..";

    private static final String SEPARATOR = "/";

    // Time: O(N + M) (N = current Length, M = change Length)
    // Space: O(N + M)
    public String simplifyPath(String current, String change) {
        if (change == null || change.trim().isEmpty()) {
            return current;
        }

        Deque<String> stack = new ArrayDeque<>();
        // O(N)
        String[] currentComponents = current.split("/");
        // O(Directory Size) <= O(N)
        // Assuming directory is normal
        for (String directory : currentComponents) {
            if (!directory.isEmpty()) {
                stack.push(directory);
            }
        }
        String[] changeComponents = change.split("/");

        // O(Directory Size) <= O(N)
        for (String directory : changeComponents) {
            // current directory . or empty directory
            if (directory.isEmpty() || directory.equals(".")) {
                continue;
            }

            // Previous directory ..
            if (directory.equals("..")) {
                // if stack is not empty then go to previous directory
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(directory);
            }
        }

        // O(Directory Size) <= O(N)
        StringBuilder path = new StringBuilder();
        // reverse sequential order
        Iterator<String> itr = stack.descendingIterator();
        while (itr.hasNext()) {
            path.append("/");
            path.append(itr.next());
        }
        return path.length() > 0 ? path.toString() : "/";
    }
}
==============================71. Simplify Path====================================
class Solution {
    
//     Constraints:

// 1 <= path.length <= 3000
// path consists of English letters, digits, period '.', slash '/' or '_'.
// path is a valid absolute Unix path.
    // time is O(n)
    // space is also O(N)
    
//     In a Unix-style file system, a period '.' refers to the current directory,
//     a double period '..' refers to the directory up a level, 
//     and any multiple consecutive slashes (i.e. '//') are treated 
//         as a single slash '/'. For this problem, 
//     any other format of periods such as '...' are treated as file/directory names.
    
    
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0){
            return "/";
        }
        Stack<String> stack = new Stack<>();
        
        for (String str : path.split("/")){
            if (str.equals("..")){
                if (!stack.isEmpty()){
                    stack.pop();
                }
            } else if (str.length() > 0 && !str.equals(".")){
                stack.push(str);
            }
        }
        return "/" + String.join("/", stack);
    }
}
