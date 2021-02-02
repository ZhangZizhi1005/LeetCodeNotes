package Stack._0155;

import java.util.Stack;

class MinStack{

    private Stack<Integer> stk;
    private Stack<Integer> min;

    public MinStack(){
        stk = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x){
        if(min.empty()){
            min.push(x);
        }else{
            min.push(x>min.peek()?min.peek():x);
        }

        stk.push(x);
    }

    public void pop(){
        stk.pop();
        min.pop();
    }

    public int top(){
        return stk.peek();
    }

    public int getMin(){
        return min.peek();
    }
}

