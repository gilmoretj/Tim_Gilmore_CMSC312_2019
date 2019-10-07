import java.util.ArrayList;

//First come first serve scheduler

public class scheduler {

	static int numberOfProcesses = 0;
	static ArrayList<PCB> readyQueue = new ArrayList<>();
	
	public static void runScheduler() {
		
		while(numberOfProcessesInReadyQueue() > 0) {
			
			dispatcher.giveCpuToNextProcess();
		}
		
		System.out.println("All jobs Completed!");
		System.out.println();
	}
	
	public static void addToReadyQueue(PCB someProcess) {
		
		readyQueue.add(someProcess);
		numberOfProcesses++;
		
		System.out.println("Adding process ID: " + someProcess.getID() + " to ready queue...");
		System.out.println();
	}
	
	public static int numberOfProcessesInReadyQueue() {
		
		return readyQueue.size();
	}
	
	public static class dispatcher{
		
		public static void giveCpuToNextProcess() {
			
			if(!readyQueue.isEmpty()) {
			
				PCB nextProcessToRun = readyQueue.remove(0);
			
				nextProcessToRun.changeStateToRunning();
			
				CPU.runProcess(nextProcessToRun);
			}
		}
		
		public static void terminateProcess(PCB process) {
			
			process.changeStateToTerminated();
			numberOfProcesses--;
			
			System.out.println("Terminating process ID: " + process.getID() + " ...");
			System.out.println();
		}
	}
	
	public static class CPU{
		
		public static void runProcess(PCB runningProcess) {
			
			System.out.println("Running process ID: " + runningProcess.getID() + " on CPU...");
			System.out.println();
			
			dispatcher.terminateProcess(runningProcess);
		}
	}
}
