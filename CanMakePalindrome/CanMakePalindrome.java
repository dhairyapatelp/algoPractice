public class CanMakePalindrome{
	
	public static void main(String[] args){
		CanMakePalindrome obj = new CanMakePalindrome();

		System.out.println("hello: "+obj.convertToPalindrome("hello"));
		System.out.println("eetete: "+obj.convertToPalindrome("eetete"));
		System.out.println("feffeee: "+obj.convertToPalindrome("feffeee"));
		System.out.println("dhairya: "+obj.convertToPalindrome("dhairya"));

	}

	private boolean convertToPalindrome(String str){
		int odd = 0;
		int[] charMap = new int[26];

		for(int i=0; i<str.length(); i++){
			charMap[str.charAt(i) - 'a']++;
		}

		for(int each: charMap){
			if(each % 2 != 0) odd++;
			if(odd > 1) return false; 
		}

		return true;
	}
}