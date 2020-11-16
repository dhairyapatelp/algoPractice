public class Base62{
	public static void main(String[] args){
		Base62 encodeString = new Base62();
		//Long l = 12345678901234567890L;
		System.out.println("Encoded String is: "+ encodeString.base62(Long.valueOf(1230123L)));
	}

	private String base62(long randomNumber){
		char[] characterSpace = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

		StringBuilder encodedString = new StringBuilder();
		while(randomNumber > 0){
			encodedString.append(characterSpace[(int)(randomNumber%62)]);
			randomNumber /= 62;
		}

		while(encodedString.length() < 7){
			encodedString.append(0);
		}

		return encodedString.toString();
	}
}

