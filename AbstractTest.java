package first;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public abstract class AbstractTest {
	int i=10;
	
	public abstract void abstractMethod();
	
	public void check(){
		System.out.println("from abstract method...!!!");
	};

	
	public static void main(String[] args) {
		System.out.println("i am main and JVM can call me directly...!!");
	}
}
