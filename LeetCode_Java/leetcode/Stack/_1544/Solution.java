package Stack._1544;

import java.util.Stack;

class Solution{
    public static String makeGood(String s){

        Stack<Character> stk = new Stack<>();

        if(s.length() == 0)
            return "";
        if(s.length() == 1)
            return s;

        for (int i = 0; i < s.length(); i++){
            if(stk.empty()){
                stk.push(s.charAt(i));
            }else {
                if (stk.peek() >= 65 && stk.peek() <= 90) {
                    if (s.charAt(i) == stk.peek() + 32) {
                        stk.pop();
                        continue;
                    }
                    stk.push(s.charAt(i));
                }
                else if (stk.peek() >= 97 && stk.peek() <= 122) {
                    if (s.charAt(i) == stk.peek() - 32) {
                        stk.pop();
                        continue;
                    }
                    stk.push(s.charAt(i));
                }
            }
        }

        StringBuffer output = new StringBuffer();
        while(!stk.empty()){
            output.insert(0,stk.pop());
        }

        return output.toString();
    }
}