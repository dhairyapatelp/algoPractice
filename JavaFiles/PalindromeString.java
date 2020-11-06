//finds if the string is palindrome or not in a recursive way.

class PalindromeString{
	
	public static void main(String[] args){
		String word = "abba";
		System.out.println(isPalindrome(word, 0, word.length()-1));
	}

	private static boolean isPalindrome(String word, int start, int end){
		if(start>=end) return true; 
		if(word.charAt(start) != word.charAt(end)) return false;
		else isPalindrome(word, start+1, end-1); 

		return true;
	}
}