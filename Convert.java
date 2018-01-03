package first;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Convert {
	
	Convert() {
		System.out.println("construtor with one argument is called");
	}
	static void convertInt(String str) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		//System.out.println(Integer.parseInt(str.replaceAll("[\\D]", "")));

		Convert c = (Convert)Class.forName("first.Convert").newInstance();
		/*StringBuilder strBld = new StringBuilder();
		for(int i =0; i < str.length(); i++) {
			if(str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				strBld.append(str.charAt(i));
			}
		}
		String result = strBld.toString();
		System.out.println(result);*/

		
		/*
		boolean exceptionFound = false;
		try {
			int n = Integer.parseInt(str);
			System.out.println(n);
		}catch(NumberFormatException e) {
			exceptionFound = true;
		}finally {
			if(exceptionFound)
			System.out.println("String is not correct, not all the char are string");
		}*/
		
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, CloneNotSupportedException, IOException {
		//convertInt("45455");

		FileInputStream file = new FileInputStream("a.txt");
		ObjectInputStream in = new ObjectInputStream(file);
		Object obj = in.readObject();
	}
}
