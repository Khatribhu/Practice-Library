package first;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class Threadss implements Runnable {
	public void run(){
		System.out.println("Thread is running");
	}
	
	public static void main(String args[]){
		Threadss thr = new Threadss();
		Thread thre = new Thread(thr);
		//thre.start();
		ExecutorService aserv = Executors.newFixedThreadPool(5);
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new Thread(){
			public void run(){
				System.out.println("thread is running");
			}
		});
		
		System.out.println("Now main sleeping... press ctrl+c to exit");  
		try{Thread.sleep(3000);}catch (Exception e) {}
	}
}
