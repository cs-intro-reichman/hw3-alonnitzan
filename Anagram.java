/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");

		System.out.println("Tests Pre Proccess: " + "Al!2on3 Ni !!tzan" + " is: " + preProcess("Al!2on3 Ni !!tzan"));
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		
		// pre processing the 2 strings
		str1 = preProcess(str1);
		str2 = preProcess(str2);

		boolean isItAnagram = true;

		// build new string from the chars of str2 by the same order of str1
		String charsFromStr2 = "";

		for (int i = 0; i < str1.length() && isItAnagram; i++){

			char charStr1 = str1.charAt(i);

			for (int j = 0; j < str2.length() && isItAnagram; j++){
				char charStr2 = str2.charAt(j);
				if (charStr1 == charStr2){
					
					charsFromStr2 = charsFromStr2 + charStr2;

					// taking out the specific char from str2
					String tempStr = str2;
					
					if (str2.length() == 1) tempStr = "";
					
					else if (j == 0) tempStr = str2.substring(j + 1, str2.length());
					
					else if (j == str2.length() - 1) tempStr = str2.substring(0, str2.length() - 1);
					
					else tempStr = str2.substring(0, j) + str2.substring(j + 1, str2.length());

					j = str2.length();
					str2 = tempStr;

				}
				else if (j == str2.length() - 1) isItAnagram = false;
			}

		}

		if (str1.equals(charsFromStr2)) return true;

		else return false;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {

		String newStr = "";

		for (int i = 0; i < str.length(); i++){
			
			char c = str.charAt(i);
			if (Character.isLetter(c)) {
				c = Character.toLowerCase(c);
				newStr = newStr + c;
			}
		}
		
		return newStr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		
		// pre processing the string
		str = preProcess(str);

		String newStr = "";

		// running until all the characters moved to newStr
		while (str.length() > 0) {
			
			int randomIndex = (int) (Math.random() * str.length());

			char strCHar = str.charAt(randomIndex);
			newStr = newStr + strCHar;

			// remove the char from the old str
			String tempStr = str;
					
			if (str.length() == 1) tempStr = "";
			
			else if (randomIndex == 0) tempStr = str.substring(randomIndex + 1, str.length());
			
			else if (randomIndex == str.length() - 1) tempStr = str.substring(0, str.length() - 1);
			
			else tempStr = str.substring(0, randomIndex) + str.substring(randomIndex + 1, str.length());

			str = tempStr;

		}
		

		return newStr;
	}
}
