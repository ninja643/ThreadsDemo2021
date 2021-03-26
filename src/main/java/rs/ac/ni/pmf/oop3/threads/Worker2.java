package rs.ac.ni.pmf.oop3.threads;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Worker2 implements Runnable
{
	private final long _delay;

	public Worker2(final long delay)
	{
		_delay = delay;
	}

	@Override
	public void run()
	{
		log.info("Starting...");
		a();
	}

	private void a()
	{
		try
		{
			b();
			checkIfInterrupted();
		}
		catch (InterruptedException e)
		{
			log.info("Method a() interrupted");
			Thread.currentThread().interrupt();
		}
	}

	private void b()
	{
		try
		{
			c();
			checkIfInterrupted();
		}
		catch (InterruptedException e)
		{
			log.info("Method b() interrupted");
			Thread.currentThread().interrupt();
		}
	}

	private void c()
	{
		try
		{
			Thread.sleep(_delay);
		}
		catch (InterruptedException e)
		{
			log.info("Method c() interrupted");
			Thread.currentThread().interrupt();
		}
	}

	private void checkIfInterrupted() throws InterruptedException
	{
		if (Thread.interrupted())
		{
			throw new InterruptedException();
		}
	}
}
