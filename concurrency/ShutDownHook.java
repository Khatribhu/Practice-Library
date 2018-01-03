package first.concurrency;
/* ====================================== */
/* Copyright (c) 2017 BK Corporation. */
/*          All rights reserved.          */
/* ====================================== */
class MyThread extends Thread {
	public void run() {
		System.out.println("Shutdown hook task completed..");
	}
}

public class ShutDownHook {
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new MyThread());
		
		System.out.println("Now main sleeping... press ctrl+c to exit");
		try {
			Thread.sleep(3000);
		}catch(Exception e) {
			
		}
	}
}
