// "static void main" must be defined in a public class.
public class Main {
    
        // Number in stack is in decreasing order. 
    //If the new number large than number in stack, 
    //adding those less numbers, and multiple that sum with the new number.
    
    public static void main(String[] args) {
        System.out.println(solution("One hundred twenty three"));
        System.out.println(solution("Three hundred million"));
        System.out.println(solution("One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"));
        
         System.out.println(solution("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"));
         System.out.println(solution("Twelve Thousand Three Hundred Forty Five"));
        
    }
    
    public static int solution(String sentence) {
        String[] words = sentence.split(" ");
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("billion", 1_000_000_000);
        map.put("million", 1_000_000);
        map.put("thousand", 1_000);
        map.put("hundred", 100);
        map.put("ninety", 90);
        map.put("eighty", 80);
        map.put("seventy", 70);
        map.put("sixty", 60);
        map.put("fifty", 50);
        map.put("forty", 40);
        map.put("thirty", 30);
        map.put("twenty", 20);
        map.put("nineteen", 19);
        map.put("eighteen", 18);
        map.put("seventeen", 17);
        map.put("sixteen", 16);
        map.put("fifteen", 15);
        map.put("forteen", 14);
        map.put("thirteen", 13);
        map.put("twelve", 12);
        map.put("eleven", 11);
        map.put("ten", 10);
        map.put("nine", 9);
        map.put("eight", 8);
        map.put("seven", 7);
        map.put("six", 6);
        map.put("five", 5);
        map.put("four", 4);
        map.put("three", 3);
        map.put("two", 2);
        map.put("one", 1);
        map.put("zero", 0);
        
        
        //Three hundred million
        //Twelve Thousand Three Hundred Forty Five
        Stack<Integer> stack = new Stack();
        for(String w : words) {
            Integer currValue = map.get(w.toLowerCase());
            if(stack.isEmpty()) {
                stack.push(currValue);
                continue;
            }
            
            int num = 0;
            while(!stack.isEmpty() && stack.peek() < currValue) {
                num += stack.pop();
            }
            
            if(num > 0) {
                stack.push(num * currValue);
            }else{
                stack.push(currValue);
            }
        }
        
        int ans = 0;
        while(!stack.isEmpty()) ans += stack.pop();
        
        return ans;
    }
}
