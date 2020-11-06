import java.util.List;
import java.util.ArrayList;

class Subsets {
    public static List<String> subsets(String s) {
        List<String> result = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        helper(result, temp, 0, s);
        return result;
    }
    
    private static void helper(List<String> result, StringBuilder temp, int start, String s){
        result.add(new String(temp));
        for(int i=start; i<s.length(); i++){
            temp.append(s.charAt(i));
            helper(result, temp, i+1, s);
            temp.deleteCharAt(temp.length()-1);
        }
        return;
    }

    public static void main(String[] args){
        String s = "Rooots";
        List<String> res = subsets(s);
        for(String each: res) System.out.println(each);
    }
}