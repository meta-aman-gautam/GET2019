package studentCouncelling;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.Workbook;
import jxl.Sheet;


public class ReadExcelFile{
	
    @SuppressWarnings("unused")
	public static void main(String[] args)
    {
    	MyQueue mQ = new MyQueue();
    	
    	Councelling councelling;
    	
    	Student student = null ;
   
    	String studentName ;
    	List <Student> listOfStudents = new ArrayList<Student>();
    	
    	
    	String programName ;
    	int capacityOfStudent = 0 ;
    	List <Program> listOfPrograms = new ArrayList<Program>();
    	
    	
        try
        {
        	
        	String FilePath = "C:\\AMAN\\GET\\PF\\ASSIGNMENT2019\\DS_Session2\\Programs.xls";
        	String FilePath2 = "C:\\AMAN\\GET\\PF\\ASSIGNMENT2019\\DS_Session2\\Students.xls";
    		FileInputStream fs = new FileInputStream(FilePath);
    		Workbook wb = Workbook.getWorkbook(fs);
    		
    		FileInputStream fs2 = new FileInputStream(FilePath2);
    		Workbook wb2 = Workbook.getWorkbook(fs2);
 
        	Sheet sh = wb.getSheet(0);
        	Sheet sh2 = wb2.getSheet(0);
        	
        
//        	
//        	Cell Row0Col0 = sh.getCell(0,0);
//        	Cell Row1Col1 = sh.getCell(1,1);
//        	String FirstRowFirstColumn = Row0Col0.getContents();
//        	String SecondRowSecondColumn = Row1Col1.getContents();
//        	
        	
        
        	for (int row = 0; row < sh.getRows(); row++) {
    			//System.out.print(sh.getCell(col, row).getContents().toString() + "\t");
    			programName =sh.getCell(0, row).getContents().toString() ;
    			capacityOfStudent = Integer.parseInt(sh.getCell(1, row).getContents()) ;
    			Program program = new Program(programName,capacityOfStudent) ;
    			listOfPrograms.add(program);
    		}
//        	for (int row = 0; row < sh.getRows(); row++) {
//        		System.out.println("LIST of Programs->"+listOfPrograms.get(row).programName);
//        	}
        	
        	for (int row = 0; row < sh2.getRows(); row++) {
        		studentName =sh2.getCell(0, row).getContents().toString() ;
        		List <String> listOfPrefrence = new ArrayList<String>();
        		for(int col =1; col<sh2.getColumns();col++){
        			listOfPrefrence.add(sh2.getCell(col, row).getContents()) ;
        		}
        		student = new Student(studentName,listOfPrefrence) ;
        		listOfStudents.add(student);
        	}
        	
        	//System.out.println(listOfStudents.get(1).listOfPrefrence.size());
        	
        	String allocated ;
        	List<Councelling> resultList= new ArrayList<Councelling>();
        	
        	for (int row = 0; row < listOfStudents.size(); row++) {
        		mQ.enqueue(listOfStudents.get(row));
        		
        		String temp;
        		for(int col =0 ;col < listOfStudents.get(row).listOfPrefrence.size(); col++){
        			temp = student.listOfPrefrence.get(col);
        			System.out.println(temp);
        			System.out.println(listOfPrograms.get(col).getCapacityOfStudents());
        			
        			 if(listOfPrograms.get(col).getCapacityOfStudents()>0){
        				listOfPrograms.get(col).setCapacityOfStudents(capacityOfStudent-1);
        				allocated = temp ;
        				studentName =  listOfStudents.get(row).studentName ;
        				councelling = new Councelling(studentName, allocated); 
        				resultList.add(councelling);
        				System.out.println("->"+allocated );
        				//mQ.dequeue();
        			}
        			else{
        				//System.out.println("lol");
        				allocated = "Unallocated" ;
        				studentName =  listOfStudents.get(row).studentName ;
        				councelling = new Councelling(studentName, allocated); 
        				resultList.add(councelling);
        				//mQ.dequeue();
        				
        			}
        		}
        	}
        	
        	
//        	for (int row = 0; row < resultList.size(); row++) {
//        		System.out.println(resultList.get(row).name+"==" + resultList.get(row).allocated);
//        	}
        	
//        	for (int row = 0; row < sh2.getRows(); row++) {
//        		int i=0 ;
//        		//System.out.print(listOfStudents.get(row).studentName+"  ");
//        		for(int col =1; col<sh2.getColumns();col++){
//        			System.out.print(" "+listOfStudents.get(row).listOfPrefrence.get(i));
//        			i++;
//        		}
//        		System.out.println();
//        	}
       
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}