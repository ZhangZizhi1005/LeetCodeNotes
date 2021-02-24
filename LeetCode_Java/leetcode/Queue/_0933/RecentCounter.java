package Queue._0933;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

class RecentCounter {
    Deque<Integer> counter = new ArrayDeque<>();

    public RecentCounter(){
        counter.clear();
    }

    public int ping( int t ){
        if(counter.size() == 0){
            counter.add(t);
            return 1;
        }
        while (counter.peek() < t - 3000 ){
            counter.removeFirst();
            if(counter.peek() == null)
                break;
        }
        counter.add(t);
        return counter.size();
    }
}