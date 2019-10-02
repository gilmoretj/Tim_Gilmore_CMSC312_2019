import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class operatingSystemSimulater {

	public static void main(String[]args) {
		
		Scanner in = new Scanner(System.in);
		String filename;
		int desiredNumberOfProcesses;
		
		boolean finished = false;
		
		while(!finished){
			
			System.out.println("Enter file name + # of processes you wish to create: ex. file.txt 5");
			System.out.println("Or Enter SHUTDOWN to end program");
			
			filename = in.next();
			
			if(!filename.equalsIgnoreCase("SHUTDOWN")) {
				
				desiredNumberOfProcesses = in.nextInt();
				
				try {
					
					File programFile = new File(filename);
				
					for(int i = 0; i < desiredNumberOfProcesses; i++) {
						
						PCB newProcess = loader.readProgramFileAndCreateProcess(programFile);
						
						scheduler.addToJobQueue(newProcess);
					}
				
				}
				
				catch(FileNotFoundException e) {
					
					System.out.println("File: " + filename + " not found...");
				}
				
				System.out.println();
			}
			
			else {
				
				finished = true;
			}
		}
		
		in.close();
		
		System.out.println("Shutting down...");
	}
}
