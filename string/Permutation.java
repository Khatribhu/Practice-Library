package first.string;

import java.util.HashSet;
import java.util.Set;

public class Permutation {

	/**
	 * Plain permute Method
	 * @param str
	 * @return
	 */
	
	public static Set<String> permute(String str) {
		Set<String> perm = new HashSet<String>();

		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}

		char initial = str.charAt(0);
		String rem = str.substring(1);
		Set<String> words = permute(rem);

		for (String wordss : words) {
			for (int i = 0; i <= wordss.length(); i++) {
				perm.add(charAtIndex(wordss, initial, i));
			}
		}

		return perm;
	}
	
	
	/**
	 * Helper method
	 * 
	 * @param str
	 * @param c
	 * @param j
	 * @return
	 */
	
	public static String charAtIndex(String str, char c, int j) {
		String first = str.substring(0, j);
		String last = str.substring(j);

		return first + c + last;
	}
	
	/**
	 * Recursive method
	 * 
	 * @param str
	 * @return
	 */
	
/*	public static Set<String> permute(String str, int p) {
		Set<String> perm = new HashSet<String>();

		if (str == null) {
			return null;
		} else if (str.length() == 0) {
			perm.add("");
			return perm;
		}

		//char initial = str.charAt(0,p);
		String initial = str.substring(0, p);
		String rem;
		String end = "";
		//take the two elements at a time.
		if(p < str.length()) {
			rem = str.substring(p,++p);
			end = str.substring(p);
		} else {
			rem = str.substring(p);
		}
		Set<String> words = permute(rem, p);

		for (String wordss : words) {
			for (int i = 0; i <= wordss.length(); i++) {
				perm.add(charAtIndex(wordss, initial, i, end));
			}
		}

		return perm;
	}*/

	/**
	 * Helper method
	 * 
	 * @param str
	 * @param c
	 * @param j
	 * @return
	 */
	/*public static String charAtIndex(String str, String c, int j, String rem) {
		String first = str.substring(0, j);
		String last = str.substring(j);

		return first + c + last+rem;
	}*/

	private void permute(String str, int l, int r) {
		if (l == r)
			System.out.println(str);
		else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	private static void permutation(char[] perm, int pos, String str) {
		if (pos == perm.length) {
			System.out.println(new String(perm));
		} else {
			for (int i = 0; i < str.length(); i++) {
				perm[pos] = str.charAt(i);
				permutation(perm, pos + 1, str);
			}
		}
	}

	public static void main(String args[]) {
		String input = "ABCDER";
		String[] arr = { "hat", "abc", "Zu6" };

		Set<String> stringSet = new HashSet<String>();
		int j = 0;
		
		//in place permutations.
		for (int i = j + 1; i < input.length(); i++, j++) {
			String st = input.charAt(j) + "" + input.charAt(i);
			stringSet = permute(st);
			stringSet.forEach(an -> System.out.println(an + ","));
		}
		j++;		
		
		System.out.println("----------2nd---------");
			
		j = 0;
		//all the permutations with char 0 to every other char.
		while (j < input.length()) {
			for (int i = j + 1; i < input.length(); i++) {
				String st = input.charAt(j) + "" + input.charAt(i);
				stringSet = permute(st);
				stringSet.forEach(an -> System.out.println(an + ","));
			}
			j++;
		}

		/*for (int i = 0; i < arr.length; i++) {
			Set<String> stringSet = new HashSet<String>();
			stringSet = permute(arr[i]);
			stringSet.forEach(an -> System.out.print(an + ","));
			System.out.println();
		}*/

	}
}
