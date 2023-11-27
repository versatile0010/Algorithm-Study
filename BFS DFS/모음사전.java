import java.util.*;

class Solution {
    char[] words;
    int count;
    HashMap<String, Integer> hm;
    public int solution(String word) {
        int answer = 0;
        words = new char[]{'A', 'E', 'I', 'O', 'U'};
        hm = new HashMap<>();
        
        dfs("", word);
        
        return hm.get(word);
    }
    
    public void dfs(String str, String target){
        if(str.length() > 5){
            return;
        }
        if(!hm.containsKey(str)){
            hm.put(str, count);
        }
        count += 1;
        for(char word : words){
            dfs(str + word, target);
        }
    }
}
