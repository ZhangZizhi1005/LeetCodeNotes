# Stack_0155 #

---

## Failure 1 ##

>Reason:
>
>​	Missing requirement of question due to read question  careless. When getting minstack, time out.
>
>Code
>
>```java
>import java.util.ArrayList;
>
>class MinStack{
>    private ArrayList<Integer> stk;
>
>    public MinStack(){
>        stk = new ArrayList<>();
>    }
>
>    public void push(int x){
>        stk.add(x);
>    }
>
>    public void pop(){
>        stk.remove(stk.size() - 1);
>    }
>
>    public int top(){
>        return stk.get(stk.size() -1);
>    }
>//O(n)
>    public int getMin(){
>        int min = Integer.MAX_VALUE;
>        for(int i = 0; i < stk.size(); i++){
>            if(stk.get(i) <= min)
>                min = stk.get(i);
>        }
>        return min;
>    }
>}
>```

---

## Better Solution ##

>Thought:
>
>​	We've learned that find a item in ```Stack``` is leaner time, but the question requires constant time. So we can easily think out that we must spend more space to reduce time cost.
>
>Code
>
>```java
>import java.util.Stack;
>
>class MinStack{
>
>    private Stack<Integer> stk;
>    private Stack<Integer> min;
>
>    public MinStack(){
>        stk = new Stack<>();
>        min = new Stack<>();
>    }
>
>    public void push(int x){
>        if(min.empty()){
>            min.push(x);
>        }else{
>            min.push(x>min.peek()?min.peek():x);
>        }
>
>        stk.push(x);
>    }
>
>    public void pop(){
>        stk.pop();
>        min.pop();
>    }
>
>    public int top(){
>        return stk.peek();
>    }
>
>    public int getMin(){
>        return min.peek();
>    }
>}
>```
>
>

