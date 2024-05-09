package utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.stream.Stream;

import com.app.core.Student;
import com.app.core.Subject;

public interface IOUtils {

	static void sortByDoB(Map<String, Student> map,String fName) throws IOException {
	
		try(PrintWriter pw = new PrintWriter(new FileWriter(fName))){
			Stream<Student> res = map.values()
			.stream()
			.sorted((s1,s2)->s1.getDob().compareTo(s2.getDob()));
			
			res.forEach(i->pw.println(i));
			
		}
		
	}
	
	
	static void sortByGPA(Map<String, Student> map,String fName,String subject) throws IOException {
		
		try(PrintWriter pw = new PrintWriter(new FileWriter(fName))){
			Stream<Student> res = map.values()
			.stream()
			.filter(i->i.getSubject()==Subject.valueOf(subject.toUpperCase()))
			.sorted((s1,s2)->((Double)s1.getGpa()).compareTo(s2.getGpa()));
			
			res.forEach(i->pw.println(i));
			
		}
		
	}
	
}
