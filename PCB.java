//Structure dedicated to holding process information

enum State{	
	NEW, READY, RUNNING, WAITING, TERMINATED;
}

public class PCB {
	
	static int numberOfProcesses = 0;
	public int processId;
	public State currentState;
	
	public PCB() {
		
		initialize();
		numberOfProcesses++;
		System.out.println("Creating new PCB ID: " + processId + " ...");
	}
	
	public void initialize() {
		
		currentState = State.NEW;
		processId = numberOfProcesses + 1;
	}
}
