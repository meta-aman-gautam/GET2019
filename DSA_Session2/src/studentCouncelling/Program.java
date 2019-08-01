package studentCouncelling;

public class Program {

	String programName;
	int capacityOfStudents ; 
	public Program(String programName ,int capacityOfStudents){
		this.programName =programName;
		this.capacityOfStudents =capacityOfStudents;
	}
	public int getCapacityOfStudents() {
		return capacityOfStudents;
	}
	public void setCapacityOfStudents(int capacityOfStudents) {
		this.capacityOfStudents = capacityOfStudents;
	}
	public String getProgramName() {
		return programName;
	}
	
	
}
