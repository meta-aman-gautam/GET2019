package studentCouncelling;
import java.util.*;
/**
 * This class contains method to allocate a program to student
 * 
 * @author Aman Gautam
 * 
 * Dated 1/8/2019
 */
public class AllocateBranch {

	/**
	 * method to allocate program to students
	 * @param studentQueue is the queue of students along with preference
	 * @return {Queue} student and their allocated programs
	 */
	public Queue<CounsellingResult> allocateBranch(Queue<StudentList> studentQueue) {

		Queue<CounsellingResult> resultList = new LinkedList<>();
		String studentName, branch;
		for (int count_i = 0; studentQueue.size() != 1; count_i++) {
            studentName = studentQueue.peek().studentName;
			for (int count_j = 0; count_j < 5; count_j++) {
				branch = studentQueue.peek().preference[count_j];
				if (FileOperation.programs.get(branch) > 0) {
					resultList.add(new CounsellingResult(studentName, branch));
					FileOperation.programs.put(branch,FileOperation.programs.get(branch) - 1);
					break;
				} else
					continue;
			}
			studentQueue.remove();
		}
		return resultList;
	}

}
