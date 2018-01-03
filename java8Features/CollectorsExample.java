package first.java8Features;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

class Product {
	int id;
	String name;
	float price;
	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class CollectorsExample {
	public static void main(String[] args) {
		List<Product> productsList = new ArrayList<Product>();
		// Adding Products
		productsList.add(new Product(1, "HP Laptop", 25000f));
		productsList.add(new Product(2, "Dell Laptop", 30000f));
		productsList.add(new Product(3, "Lenevo Laptop", 28000f));
		productsList.add(new Product(4, "Sony Laptop", 28000f));
		productsList.add(new Product(5, "Apple Laptop", 90000f));
		Set<String> productPriceList = productsList.stream().map(x -> (x.name+" "+x.price)) // fetching price
				.collect(Collectors.toSet()); // collecting as list
		
		double sum = productsList.stream().collect(Collectors.counting());
		System.out.println(sum);
		//System.out.println(productPriceList);
	}
}