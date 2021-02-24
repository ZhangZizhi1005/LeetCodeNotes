## Answer ##

```java
import java.util.ArrayDeque;
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
```

---

## BetterSolution ##

>**Improvment**
>
>1. Use ```Queue``` rather than ```Deque```
>2. Instantialize in *constructor*
>3. Add first

```java
class RecentCounter {
    Queue<Integer> q;
    public RecentCounter() {
        q = new LinkedList();
    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}

```

