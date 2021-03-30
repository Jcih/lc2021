class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String comp : components) {
            if (comp.equals(".") || comp.length() == 0) continue;
            else if (comp.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(comp);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (String folder : stack) {
            res.append("/");
            res.append(folder);
        }
        
        return res.length() > 0 ? res.toString() : "/";
    }
}