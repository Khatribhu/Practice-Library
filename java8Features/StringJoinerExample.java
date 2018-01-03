package first.java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import javax.script.ScriptException;

public class StringJoinerExample {
	public static void main(String[] args) throws ScriptException {
		StringJoiner joinNames = new StringJoiner(",", "{", "}"); // passing comma(,) as delimiter

		// Adding values to StringJoiner
		joinNames.add("Rahul");
		joinNames.add("Raju");
		joinNames.add("Peter");
		joinNames.add("Raheem");

		joinNames.merge(joinNames);
		System.out.println(joinNames);
		
		String val = joinNames.toString();

		String[] words = val.split(",");

		for (String st : words) {
			System.out.println(st + " ");
		}

		String[] lower = new String[5];

	}

}