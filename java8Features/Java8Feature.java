package first.java8Features;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class Java8Feature {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(4);
		list.add(56);
		list.add(22);
		list.stream().collect(Collectors.summingInt(a->a));
		
		Set<Integer> listlist = list.stream().collect(Collectors.toSet());
		listlist.forEach(a->System.out.println(a));
		
	}
}
