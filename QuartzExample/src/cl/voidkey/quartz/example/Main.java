package cl.voidkey.quartz.example;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

	public static void main(String[] args) throws SchedulerException {

		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		System.out.println("Iniciando Scheduler...");
		scheduler.start();
		JobDetail job = JobBuilder.newJob(JobExample.class).
				withIdentity("testjob", "grupo01").
				usingJobData("mensaje", "hola mundo").
				build();
		
		Trigger trigger = TriggerBuilder.newTrigger().
				withIdentity("triggertest", "grupo01").
				startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(10).repeatForever()).build();
		
		scheduler.scheduleJob(job,trigger);
	}

}
