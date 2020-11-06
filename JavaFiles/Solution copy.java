import java.util.*;

class Solution{
	public static String[] solution(int n, int k){
		if(n == 0) return new String[] {""};
		ArrayList<String> result = new ArrayList<String>();
		String[] rec = solution(n-1, k);//0, 2
		for(String p: rec){
			
			for(char l: new char[] {'a', 'b', 'c'}){
				int pLen = p.length();//0
				if(pLen == 0 || p.charAt(pLen - 1) != l){
					result.add(p + l);
				}
			}
		}
		int prefSize = Math.min(result.size(), k);
		return result.subList(0, prefSize).toArray(new String[prefSize]);
	}

	public static void main(String[] args){
		String[] ans = solution(6,6);
		for(String i: ans) System.out.println(i);
	}
}

