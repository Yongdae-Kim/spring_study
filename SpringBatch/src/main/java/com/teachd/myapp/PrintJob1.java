package com.teachd.myapp;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

// ref http://www.jroller.com/0xcafebabe/entry/spring_batch_hello_world_1

public class PrintJob1 implements Tasklet {
	private String message;

	public void setMessage(String message) {
		this.message = message;
	}

	public RepeatStatus execute(StepContribution arg0, ChunkContext arg1)
			throws Exception {
		System.out.println("#################### JOB 1 ####################");
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		System.out.println(message);
		System.out.println("#################### END 1 ####################");
		return RepeatStatus.FINISHED;
	}
}
