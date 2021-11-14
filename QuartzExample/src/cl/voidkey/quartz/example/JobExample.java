package cl.voidkey.quartz.example;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class JobExample implements Job {

	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
	{
		JobDataMap data = jobExecutionContext.getMergedJobDataMap();
		
		String mensaje = data.getString("mensaje");
		System.out.println("Se envio un mensaje y es ".concat(mensaje));
	}
	
}
