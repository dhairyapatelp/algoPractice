import java.util.*;
import java.lang.*;

class WordDistance {
    String[] words;
    Map<String, List<Integer>> map;

    public static void main(String[] args){
        String[] words = {"practice", "makes", "perfect", "coding", "makes"};
        WordDistance obj = new WordDistance(words);
        System.out.println("practice <-> perfect");
        System.out.println(obj.shortest("practice", "perfect"));

        System.out.println("makes <-> perfect");
        System.out.println(obj.shortest("makes", "perfect"));

    }
    
    public WordDistance(String[] words) {
        this.words = words;
        map = new HashMap<String, List<Integer>>();
        int index = 0;
        for(String each: words){
            if(!map.containsKey(each)){
                map.put(each, new ArrayList<Integer>());
            }
            map.get(each).add(index++);
        }
    }
    
    public int shortest(String word1, String word2) {
        int result = Integer.MAX_VALUE;
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int size1 = list1.size();
        int size2 = list2.size();
        int i=0, j=0;
        
        while(i<size1 && j<size2){
            int p1 = list1.get(i);
            int p2 = list2.get(j);
            if(p1<p2){
                result = Math.min(result, p2-p1);
                i++;
            } else{
                result = Math.min(result, p1-p2);
                j++;
            }
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */