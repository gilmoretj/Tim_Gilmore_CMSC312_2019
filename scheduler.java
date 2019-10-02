import java.util.ArrayList;

//First come first serve scheduler

public class scheduler {

	static ArrayList<PCB> jobQueue = new ArrayList<>();
	static ArrayList<PCB> readyQueue;
	
	public static void addToJobQueue(PCB someProcess) {
		
		jobQueue.add(someProcess);
		System.out.println("Adding process to job Queue...");
	}
	
	public class dispatcher{
		
	}
}
