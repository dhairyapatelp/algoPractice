public class KMP{
	public static void main(String[] args){
		String txt = "ABABDABACDABABCABABABCDABCDABCCDAABCDABCDABCAABCDABCDCCDA"; 
        String pat = "CDAASB";
        //String pat = "ACACABACACABACACAC";

        KMP obj = new KMP();
        System.out.println(obj.stringMatching(txt, pat));
	}

	private boolean stringMatching(String txt, String pat){
		int[] result = createPatternLookUpTable(pat);
		char[] txtCharArray = txt.toCharArray();
		char[] patCharArray = pat.toCharArray();

		int txtArrayPtr = 0;
		int patArrayPtr = 0;
		while(txtArrayPtr<txt.length() && patArrayPtr<pat.length()){
			if(patCharArray[patArrayPtr] == txtCharArray[txtArrayPtr]){
				patArrayPtr++;
				txtArrayPtr++;
			}
			else{
				if(patArrayPtr != 0){
					patArrayPtr = result[patArrayPtr-1];
				}
				else{
					txtArrayPtr++;
				}
			}

		}

		return patArrayPtr == pat.length();
	}

	private int[] createPatternLookUpTable(String pat){
		int len = pat.length();
		int[] patLookUp = new int[len];
		char[] c = pat.toCharArray();
		int leading = 1;
		int chasing = 0;

		while(leading<len){
			if(c[chasing] == c[leading]){
				chasing++;
				patLookUp[leading] = chasing;
				leading++;
				
			}
			else{
				if(chasing != 0){
					chasing = patLookUp[chasing-1];
				}
				else{
					patLookUp[leading] = chasing;
					leading++;
				}
			}

		}

		return patLookUp;
	}
}


//Time Complexity - O(M+N) where N is the length of the string and M is the length of the substring
//Space Complexity - O(M) where M is the length of the substring - used for creating the subarray.