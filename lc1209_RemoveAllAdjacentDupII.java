
class Solution {
    
    class Node {
        char c;
        int count;
        public Node(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        /*
        
        use stack store Node <char c , int count >

        **/
        
        
        Stack<Node> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek().c) {
                stack.peek().count++;
            } else {
                stack.push(new Node(c, 1));
            }
            
            if (stack.peek().count == k) {
                stack.pop();
            }
  
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            int n = node.count;
            char tmp = node.c;
            for (int i = 0; i < n; i++) {
                sb.append(tmp);
            }
            
        }
        return sb.reverse().toString();
        
    }
    
}