# Stack _ 1544 #

---

## Failure 1 ##

> Input: any input
>
> Reason : missing ```continue``` experession, leading to continuous push instruction

---

## Failure 2 ##

> Input: "Code" | "ABabCcDd"
>
> Output: "edooC" | "EmptyStackException"
>
> Reason: to be finded | didn't check whether stack is empty before peek
>
> Code after corrected:
>
> ```java
> package Link._1544;
> 
> import java.util.Stack;
> 
> class Solution{
>     public static String makeGood(String s){
> 
>         Stack<Character> stk = new Stack<>();
> 
>         if(s.length() == 0)
>             return "";
>         if(s.length() == 1)
>             return s;
>         stk.push(s.charAt(0));
> 
>         for (int i = 1; i < s.length(); i++){
>             if(stk.peek() >= 65 && stk.peek() <=90){
>                 if (s.charAt(i) == stk.peek() + 32) {
>                     stk.pop();
>                     continue;
>                 }
>                 stk.push(s.charAt(i));
> 
>             }
>             if(stk.peek() >= 97 && stk.peek() <= 122){
>                 if (s.charAt(i) == stk.peek() - 32) {
>                     stk.pop();
>                     continue;
>                 }
>                 stk.push(s.charAt(i));
> 
>             }
>         }
> 
>         String output = "";
>         while(!stk.empty()){
>             output += stk.pop();
>         }
> 
>         return output;
>     }
> }
> ```

---

## Failure 3 ##

> Input: "Code" 
>
> Output: "edooC" 
>
> Reason: 
>
> 1. When peek of the stack is a capital letter like **A**, suppose the next letter is another lowercase letter like **b**, accidents happened. As  **b** is not the lowercase for **A**, so **b** will be pushed into the stack. However, the loop wasn't end, so that program may  continue to check the next if expression. Attention! The peek of stack has been changed to **b**, and the ```charAt(i)``` is also **b**, so the **b** will be pushed into stack one more time. **We should correct the second** ```if``` **to** ```else if```
> 2. We can not simply pop the peek element of stack, as ```Stack``` is a **LIFO** structure. **Use** ```StringBuffer``` for the frequently insertion other than ```String```
>
> Code after corrected:
>
> ```java
> class Solution{
>     public static String makeGood(String s){
> 
>         Stack<Character> stk = new Stack<>();
> 
>         if(s.length() == 0)
>             return "";
>         if(s.length() == 1)
>             return s;
> 
>         for (int i = 0; i < s.length(); i++){
>             if(stk.empty()){
>                 stk.push(s.charAt(i));
>             }else {
>                 if (stk.peek() >= 65 && stk.peek() <= 90) {
>                     if (s.charAt(i) == stk.peek() + 32) {
>                         stk.pop();
>                         continue;
>                     }
>                     stk.push(s.charAt(i));
>                 }
>                 else if (stk.peek() >= 97 && stk.peek() <= 122) {
>                     if (s.charAt(i) == stk.peek() - 32) {
>                         stk.pop();
>                         continue;
>                     }
>                     stk.push(s.charAt(i));
>                 }
>             }
>         }
> 
>         StringBuffer output = new StringBuffer();
>         while(!stk.empty()){
>             output.insert(0,stk.pop());
>         }
> 
>         return output.toString();
>     }
> }
> ```

---

## Best Solution ##

> Thought:
>
> 1.  We don't have to use ```Stack``` to new and maintain a stack if the stack is not so complicated. Just use other data structure like ```Array``` or ```StringBuffer``` is enough.
> 2. When we estimate upper or lower case things, ```Math.abd()``` method is usually very useful.
>
> Code
>
> ```java
> class Solution {
>     public String makeGood(String s) {
>         char[] cs = new char[s.length()];
>         int stackLength = 0;
> 
>         for (int i = 0; i < s.length(); i++) {
>             char c = s.charAt(i);
>             if (stackLength > 0) {
>                 if (Math.abs(cs[stackLength - 1] - c) == 32) {
>                     stackLength--;
>                     continue;
>                 }
>             }
> 
>             cs[stackLength++] = c;
>         }
> 
>         return String.valueOf(Arrays.copyOf(cs, stackLength));
>     }
> }
> ```
>
> 