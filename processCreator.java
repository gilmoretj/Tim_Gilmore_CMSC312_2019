import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class processCreator {
	
	public static int numberOfProcessesCreated = 0;
	
	public static PCB createProcess(File programFile)throws FileNotFoundException {
		
		String processName,instructionType;
		int runtime, memory, instructionRuntime;
		ArrayList<instruction> programInstructions;
		PCB newProcess;
		
		Scanner scan = new Scanner(programFile);
		
		scan.next();// gets rid of "Name:" token
		processName = scan.nextLine();// gets everything else on line 1
		
		scan.next();// gets rid of "Total" token
		scan.next();// gets rid of "runtime:" token
		runtime = scan.nextInt();// gets integer following the "runtime:" token
		
		scan.next();// gets rid of "Memory:" token
		memory = scan.nextInt();// gets integer following "Memory:" token
		
		programInstructions = new ArrayList<>();
		newProcess = null;
		
		while(scan.hasNext()) {
			
			instructionType = scan.next();
			
			if(!instructionType.equalsIgnoreCase("EXE")) {
			
				instructionRuntime = scan.nextInt();
			
				int randomValue = randomizedValue(25);			
				instructionRuntime = instructionRuntime + randomValue;
			
				if(instructionType.equalsIgnoreCase("CALCULATE")) {
				
					runtime = runtime + randomValue;
				}
			
				instruction newInstruction = new instruction(instructionType, instructionRuntime);
				programInstructions.add(newInstruction);
			}
		}
		
		scan.close();
		
		newProcess = new PCB(numberOfProcessesCreated, runtime, programInstructions.iterator());
		numberOfProcessesCreated++;
		
		System.out.println("Creating new process ID: " + newProcess.getID() + "...");
		System.out.println();
		
		return newProcess;
	}
	
	public static int randomizedValue(int range) {
		
		int a = (int) (Math.random()*2);
		int b = (int) (Math.random()*range);
		
		return (int) Math.pow(-1, a) * b;
	}
}
