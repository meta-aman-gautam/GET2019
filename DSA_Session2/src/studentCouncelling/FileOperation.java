package studentCouncelling;
import java.util.*;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.Number;
import java.io.File;
/**
 * This class contains method to read write files
 *
 * @author Aman Gautam
 * 
 * Dated 01/08/2019
 */
public class FileOperation {

	
	static Map<String,Integer> programs=new HashMap<>();
	/**
	 * this method reads student file
	 * @param inputFile is the address of source excel file 
	 * @return {Queue} contains list of StudentList Object fetched from file
	 * @throws IOException
	 */
	 public Queue<StudentList> studentFileRead(String inputFile) throws IOException  {
		 Queue<StudentList> studentQueue=new LinkedList<>();
		 StudentList student;
	        File inputWorkbook = new File(inputFile);
	        Workbook wb;
	        ArrayList<String> parameters=new ArrayList<String>();
	        try {
	            wb = Workbook.getWorkbook(inputWorkbook);
	            // Get the first sheet
	            Sheet sheet1 = wb.getSheet(0);
	            for (int j = 0; j < sheet1.getRows(); j++) {
	            	
	                for (int i = 0; i < sheet1.getColumns(); i++) {
	                    Cell cell = sheet1.getCell(i, j);
	                        parameters.add(cell.getContents());

	                }
	                    student=new StudentList(parameters); 
	                    studentQueue.add(student);
	                    parameters.clear();
	             }
 
	        } catch (BiffException e) {
	            e.printStackTrace();
	        }
	        return studentQueue;
	    }
	 
	 /**
		 * this method reads Programs file
		 * @param inputFile is the address of source excel file 
		 * @throws IOException
		 */
	 public void programFileRead(String inputFile) throws IOException  {
		 
	        File inputWorkbook = new File(inputFile);
	        Workbook wb;
	        try {
	            wb = Workbook.getWorkbook(inputWorkbook);
	            // Get the Second sheet
	            Sheet sheet2 = wb.getSheet(1);
	            for (int i = 0; i < sheet2.getRows(); i++) {
	            	
	                    Cell cell1 = sheet2.getCell(0, i);
	                    Cell cell2 = sheet2.getCell(1, i);
	                    CellType type = cell1.getType();
	                    programs.put(cell1.getContents(), Integer.parseInt(cell2.getContents()));
	             
	                }
  
	        } catch (BiffException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 /**
	  * this method writes the result of allocation to a excel file
	  * @param resultList is the result of allocation in queue
	  */
	 void makeExcelSheet(Queue<CounsellingResult> resultList)
	 {
		 try {
			 	WritableWorkbook workbook = Workbook.createWorkbook(new File("C:\\Users\\Mahendra\\Documents\\AllocationList.xls"));
			 	WritableSheet workbookSheet = workbook.createSheet("sheet1",0);
			 	int count_j=0;
			 	while(resultList.size()!=0) {
			 		String name= resultList.peek().studentName;
			 		Label nameLabel = new Label(0, count_j, name);
			 		workbookSheet.addCell(nameLabel);
			 		String program = resultList.peek().allocatedBranch;
			 		Label programLabel = new Label(1, count_j, program);
			 		workbookSheet.addCell(programLabel);
			 		count_j++;
			 		resultList.remove();
			 	}

	 workbook.write();
	 workbook.close();
	 } catch (Exception e) {
	 e.printStackTrace();
	 }
	 }


}
