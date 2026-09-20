class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(char ch: s.toCharArray()){
            if(ch == '(' || ch == '{'  || ch == '['){
            stack.push(ch);
            }else if(ch == ')' && !stack.isEmpty() && stack.peek() == '(' ){
             stack.pop();
            }else if(ch == '}' && !stack.isEmpty() && stack.peek() == '{'){
                stack.pop();
            }else if(ch == ']' && !stack.isEmpty() && stack.peek() == '['){
                stack.pop();
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}


----------------------------------------------

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        java.util.Map<Character, Character> closeToOpen = new java.util.HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');

        for (char c : s.toCharArray()) {
            if (closeToOpen.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == closeToOpen.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
-----------------------------------------
    class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> pairs = Map.of(')', '(', '}', '{', ']', '[');
        for(char c:s.toCharArray()){
            if(pairs.containsKey(c)){
            if(!stack.isEmpty() && stack.peek() == pairs.get(c)){
                stack.pop();
            }else{
                return false;
                }
            }else {
            stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
