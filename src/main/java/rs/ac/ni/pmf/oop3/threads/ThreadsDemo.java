package rs.ac.ni.pmf.oop3.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadsDemo
{
	public static void main(String[] args) throws InterruptedException
	{
		log.info("Hello Threads!");

//		final Thread myThread = new MyThread();
//		myThread.start();
//
//		final Thread threadWithRunnable = new Thread(new MyRunnable());
//		threadWithRunnable.start();

//		final Thread workerThread = new Thread(new Worker());
//		workerThread.start();
//
//		Thread.sleep(6000);
//
//		log.info("Requesting stop. Thread will finish soon...");
//		workerThread.interrupt();
//
		Thread t = new Thread(new Worker2(3000));
		Thread t2 = new Thread(new Worker2(10000));

		t.setName("Fast thread");
		t2.setName("Slow thread");

		t.start();
		t2.start();

		log.info("Waiting for thread to finish");

		for (int i = 0; i < 2; ++i)
		{
			log.info("Waiting for at most 2 seconds");
			t.join(2000);
			t2.join(2000);
		}

		if (t.isAlive())
		{
			log.info("Thread still running, forcing stop...");
			t.interrupt();

			t.join();
		}

		if (t2.isAlive())
		{
			log.info("Thread still running, forcing stop...");
			t2.interrupt();

			t2.join();
		}

		log.info("main finished");
	}
}
