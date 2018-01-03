package second;

import java.io.Serializable;

import first.*;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class Test implements Serializable{

	
	static interface inter{
		
	}
	
	public static void main(String args[]){
		
		DiffString adiff = new DiffString();
		System.out.println(adiff instanceof DiffString);
	}
}
