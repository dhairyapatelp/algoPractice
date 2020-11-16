public class RabinKarpImplementation{
	private final prime = 101;

	public static void main(String[] args){

	}

	public int patternSearch(char[] str, char[] ptrn){
		int pLen = ptrn.length;
		int sLen = str.lenght;
		long patrnHash = calculateHash(ptrn, pLen-1);

	}

	private void checkEqualSubstring(String str, String subString){

	}

	private long reCalculateHash(char[] str, int start, int end, int oldHashValue){
		int oldCharVal = str[start-1];
		oldHashValue -= oldCharVal;
		oldHashValue /= prime;
		oldHashValue += oldHashValue*Math.pow(prime, end-start+1);
		return oldHashValue;
	}

	private int calculateHash(char[] str, int end){
		int hash = 0;
		for(int i=0; i<end; i++){
			hash += char[i]*Math.pow(prime, i);
		}

		return hash;
	}
}