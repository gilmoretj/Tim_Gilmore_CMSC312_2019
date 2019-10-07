//Structure dedicated to holding process information
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

enum State{	
	NEW, READY, RUNNING, WAITING, TERMINATED;
}

public class PCB {
	
	public int processId;
	public int runtime;
	public Iterator<instruction> programCounter;
	public State currentState;
	
	public PCB(int id, int runtime, Iterator<instruction> text) {
		
		processId = id;
		this.runtime = runtime;
		programCounter = text;
	}
	
	public void changeStateToReady() {
		
		currentState = State.READY;
	}
	
	public void changeStateToWaiting() {
		
		currentState = State.WAITING;
	}
	
	public void changeStateToRunning() {
		
		currentState = State.RUNNING;
	}
	
	public void changeStateToTerminated() {
		
		currentState = State.TERMINATED;
	}
	
	public int getID() {
		
		return processId;
	}
	
	public instruction nextInstruction() {
		
		instruction nextInstruction = programCounter.next();
		return nextInstruction;
	}
}
