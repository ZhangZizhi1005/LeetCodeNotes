package Stack._0020;

import java.util.Stack;

class Solution{
    public Boolean isValid(String s){
        Stack<Character> stk = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stk.push(s.charAt(i));
                continue;
            }

            if(stk.empty()){
                if(s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}')
                    return false;
            }

            if(s.charAt(i) == ')' && stk.peek() == '(') {
                stk.pop();
                continue;
            }
            if(s.charAt(i) == ']' && stk.peek() == '[') {
                stk.pop();
                continue;
            }
            if(s.charAt(i) == '}' && stk.peek() == '{') {
                stk.pop();
                continue;
            }
            return false;
        }
        return stk.empty();
    }
}