package FindWord;

import java.util.*;

public class FindWord {
    static Set<String> set;
    public static void main(String[] args){
        set = new HashSet<>();
        set.add("bowl");
        set.add("batsman");
        set.add("bat");
        set.add("ball");
        set.add("bowler");

        checkByCombination();
    }

    private static void checkByCombination(){
        String str = "batsaman";
        ArrayList<String> list = new ArrayList<>();
        combinationHelper(str, list, 0, new StringBuilder());
        int len = 0;
        for(String each: list) System.out.println(++len +":"+each);
    }

    private static void combinationHelper(String str, ArrayList<String> list, int start, StringBuilder bld){
        if(contains(bld.toString())){
            list.add(bld.toString());
            return;
        }
        for(int i=start; i<str.length(); i++){
            System.out.println(bld.toString());
            System.out.println("===");
            bld.append(str.charAt(i));
            combinationHelper(str, list, i+1, bld);
            bld.setLength(bld.length()-1);
        }
    }

    private static boolean contains(String str){
        if(set.contains(str)) return true;
        return false;
    }

    private static String ifAccessToDictIsAvailable(){
        Set<String> dict = new HashSet<>();
        dict.add("cute");
        dict.add("cut");
        dict.add("cutie");

        String str = "cutieasdfsafawcadadfasefdawees";
        String result = "";
        for(String each: dict){
            if(each.length()>result.length() && exists(each, str)){
                result = each;
            }
        }
        return result;
    }
    public static boolean exists(String dict, String str){
        int[] map = new int[256];
        for(char c: dict.toCharArray()){
            map[c]++;
        }
        for(char c: str.toCharArray()){
            map[c]--;
        }
        for(int i=0; i<256; i++){
            if(map[i]>0) return false;
        }
        return true;
    }


}
