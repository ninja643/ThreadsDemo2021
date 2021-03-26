package rs.ac.ni.pmf.oop3.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyThread extends Thread
{
	@Override
	public void run()
	{
		for (int i = 0; i < 10; ++i)
		{
			log.info("[{}] Hello from MyThread", i + 1);

			try
			{
				Thread.sleep(900);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
