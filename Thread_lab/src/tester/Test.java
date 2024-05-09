package tester;
import static utils.StudentCollectionUtils.populateList;
import static utils.StudentCollectionUtils.populateMap;

import java.util.Map;
import java.util.Scanner;

import com.app.core.Student;

import thread.SortOnDoB;
import thread.SortOnGpaFromSubject;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		try(Scanner sc = new Scanner(System.in);){
			
			Map<String, Student> studMap = populateMap(populateList());
			System.out.println("enter file name");
			Thread t1 = new Thread(new SortOnDoB(studMap, sc.nextLine()));
			System.out.println("enter file name and subject name");
			Thread t2 = new Thread(new SortOnGpaFromSubject(studMap,sc.nextLine(),sc.next()));
			
			t1.start();
			t2.start();
			
			t1.join();
			t2.join();
			
		}

	}

}
