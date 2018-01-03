package first.concurrency;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {

    public static void main(String[] args) throws InterruptedException {

    	ProcessingTherad pt = new ProcessingTherad();
        Thread t1 = new Thread(pt, "t1");
        t1.start();
        Thread t2 = new Thread(pt, "t2");
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Processing count=" + pt.getCount());
    }

}

class ProcessingTherad implements Runnable{
	private AtomicInteger count;
	
	
	ProcessingTherad() {
		count = new AtomicInteger(0);
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			processingSomething(i);
			count.incrementAndGet();
		}
	}
	
	public int getCount() {
		return this.count.get();
	}
	
	private void processingSomething(int i) {
		//processing
		try {
			Thread.sleep(i*1000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}