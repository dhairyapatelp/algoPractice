//https://github.com/mission-peace/interview/blob/master/src/com/interview/string/RabinKarpSearch.java

public class RabinKarpImplementation{
	static int prime = 101;

	public static void main(String[] args){
		RabinKarpImplementation rb = new RabinKarpImplementation();
		System.out.println(rb.patternSearch("aaa".toCharArray(), "aaa".toCharArray()));
	}

	public static int patternSearch(char[] str, char[] ptrn){
		int len1 = str.length;
		int len2 = ptrn.length;
		long strHash = calculateHash(str, str.length-1);
		long ptrnHash = calculateHash(ptrn, ptrn.length-1);
		for(int i=1; i<=len1-len2+1; i++){
			if(strHash == ptrnHash && checkEqualSubstring(String.valueOf(str), String.valueOf(ptrn), i-1, i+len2-2)){
				return i-1;
			}
			if(i<len1-len2+1){
				strHash = reCalculateHash(str, i-1, i+len2-1, strHash, len2);
			}
		}

		return -1;
	}

	private static boolean checkEqualSubstring(String str, String subString,  int strStart, int strEnd){

		if(strEnd - strStart+1 != subString.length()) return false;
		int subStart = 0;
		int subEnd = subString.length();
		while(strStart<=strEnd && subStart<=subEnd){
			if(str.charAt(strStart) != subString.charAt(subStart))  return false;
			else {
				strStart++;
				subStart++;
			}
		}
		return true;
	}

	private static long reCalculateHash(char[] str, int start, int end, long oldHashValue, int ptrnLen){
		long newHash = oldHashValue - str[start];
		newHash = oldHashValue/prime;
		newHash += str[end]*Math.pow(prime, ptrnLen-1);
		return newHash;
	}

	private static int calculateHash(char[] str, int end){
		int hash = 0;
		for(int i=0; i<=end; i++){
			hash += str[i]*Math.pow(prime, i);
		}
		return hash;
	}
}