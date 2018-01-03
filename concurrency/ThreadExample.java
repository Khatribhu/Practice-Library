package first.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
public class ThreadExample implements Runnable {
	public void run() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException in) {
				System.out.println(in);
			}
			System.out.println(i);
		}
	}

	public static void main(String[] args) {
		
		ThreadExample threadExample = new ThreadExample();
		Thread thread = new Thread(threadExample);
		Thread thread2 = new Thread(threadExample);
		thread.setName("one");
		System.out.println(thread.getName());
		
		thread.start();
		
		thread2.run();
		System.out.println(thread2.getName());
		thread2.setDaemon(true);
	}
}
