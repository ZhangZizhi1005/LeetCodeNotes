package Array._0914;




import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

class Solution{
    public static boolean hasGroupsSizeX(int[] deck){
        HashMap<Integer, Integer> cardSet = new HashMap<>();

        for(int i = 0; i <= deck.length -1 ;i++) {
            if (!cardSet.containsKey(deck[i])) {
                cardSet.put(deck[i], 1);
            } else {
                int count = cardSet.get(deck[i]);
                cardSet.put(deck[i], count + 1);
            }
        }
        if(deck.length == cardSet.size() || deck.length % cardSet.size() != 0)
            return false;

        Integer count = cardSet.get(deck[0]);//没有这一句就会一直报错
        Collection<Integer> counts = cardSet.values();

        Iterator<Integer> it = counts.iterator();

        while(it.hasNext()){
            Integer a = it.next();
            if (a.equals(count)) it.remove();
        }

        return counts.isEmpty();
    }


}