import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class operatingSystemSimulater {

	public static void main(String[]args) {
		
		Scanner in = new Scanner(System.in);
		String userInput;
		int numberOfProcesses;
		
		boolean finished = false;
		
		while(!finished){
			
			System.out.println("1: Type a valid filename to create a process followed by the number of processes to create");
			System.out.println("2: Type EXECUTE to execute current list of processes");
			System.out.println("3: Type SHUTDOWN to end OS simulator");
			System.out.print("> ");
			
			userInput = in.next();
			System.out.println();
			
			if(userInput.equalsIgnoreCase("EXECUTE")) {
			
				scheduler.runScheduler();
			}
			
			else if(userInput.equalsIgnoreCase("SHUTDOWN")) {
				
				finished = true;
			}
			
			else {
				
				File programFile = new File(userInput);
				
				numberOfProcesses = in.nextInt();
			
				try {
						
					for(int i = 1; i <= numberOfProcesses; i++) {
						
						PCB newProcess = processCreator.createProcess(programFile);
						scheduler.addToReadyQueue(newProcess);
					}
				}					
				
				catch(FileNotFoundException e) {
						
					System.out.println("ERROR: please check that you are spelling the command correctly or that the file exists!");
					System.out.println();
				}
			}
		}
		
		in.close();
		
		System.out.println("Shutting down...");
	}
}
