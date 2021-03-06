package com.algoPractice.TimerClass;

import java.util.Timer;
import java.util.TimerTask;

class ScheduledTasks extends TimerTask{

	public static int i = 0;
	
	@Override
	public void run(){
		System.out.println("Printing i: "+ i++);
	}
}

public class TimerClass{
	public static void main(String[] args){
		Timer timer = new Timer();
		TimerTask timerTask = new ScheduledTasks();

		timer.schedule(timerTask, 2000, 5000);

	}
}



