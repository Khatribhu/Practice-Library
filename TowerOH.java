package first;

import java.util.Scanner;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class TowerOH {

	   public void solve(int n, String start, String auxiliary, String end) {
	       if (n == 1) {
	           System.out.println(start + " -> " + end);
	       } else {
	           solve(n - 1, start, end, auxiliary);
	           System.out.println(start + " -> " + end);
	           solve(n - 1, auxiliary, start, end);
	       }
	   }

	   public static void main(String[] args) {
		   TowerOH towersOfHanoi = new TowerOH();
	       System.out.print("Enter number of discs: ");
	       Scanner scanner = new Scanner(System.in);
	       int discs = scanner.nextInt();
	       towersOfHanoi.solve(discs, "A", "B", "C");
	   }
	}