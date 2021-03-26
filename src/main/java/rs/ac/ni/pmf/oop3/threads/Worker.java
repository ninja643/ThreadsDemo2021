package rs.ac.ni.pmf.oop3.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker implements Runnable
{
	@Override
	public void run()
	{
		int counter = 0;
		boolean interruptRequested = false;

		while (!interruptRequested)
		{
			++counter;
			log.info("Computing...");

			int s = 0;

//			for(int i = 0; i < 1000000000; ++i)
			for(int i = 0; i < 10; ++i)
			{
				s += i % 2;

				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					log.info("Stop requested, will stop after computing is done");
					interruptRequested = true;
				}

				//				if (!interruptRequested && Thread.currentThread().isInterrupted())
//				{
//					log.info("Stop requested, will stop after computing is done");
//					interruptRequested = true;
//				}
			}

			log.info("{}: s = {}", counter, s);

			if (Thread.interrupted())
			{
				log.info("Thread interrupted. Stopping at: {}", counter);
				interruptRequested = true;
			}
		}
	}
}
