package demo;

import java.util.ArrayList;
import java.util.List;

public class DemoGeneric {
	public static void main(String[] args) {
		KeyValue<String, Integer> keyValue = new KeyValue<String, Integer>("IT", 1);
		
		System.out.println("====Sample One====");
		System.out.println(keyValue.getValue() + 1);
		System.out.println(keyValue.getKey() + 1);
		
		KeyValue<String, String> keyValue2 = new KeyValue<String, String>("ITLAB", "dainn");
		System.out.println("====Sample Two====");
		System.out.println(keyValue2.getKey() + 2);
		System.out.println(keyValue2.getValue() + 2);
		
		KeyValue<Integer, Integer> keyValue3 = new KeyValue<Integer, Integer>(10, 11);
		System.out.println("====Sample Three====");
		System.out.println(keyValue3.getKey() + 3);
		System.out.println(keyValue3.getValue() + 3);
		
		Student newStudent = new Student(1, "dainn", "ha dong", 20);
		KeyValue<Student, String> keyValue4 = new KeyValue<Student, String>(newStudent, "ITLAB");
		System.out.println("====Sample Four====");
		System.out.println("Informtation Student " +keyValue4.getKey().getName() +" In " +keyValue4.getValue());
		System.out.println("Id: " +keyValue4.getKey().getId());
		System.out.println("Name: " +keyValue4.getKey().getName());
		System.out.println("Address: " +keyValue4.getKey().getAddress());
		System.out.println("Age: " +keyValue4.getKey().getAge());
		
		
		List<Student> listStudent = new ArrayList<Student>();
		Student newStudent2 = new Student(2, "dainn2", "ha dong2", 25);
		Student newStudent3 = new Student(3, "dainn3", "ha dong", 30);
		listStudent.add(newStudent);
		listStudent.add(newStudent2);
		listStudent.add(newStudent3);
		KeyValue<List<Student>, String> keyValue5 = new KeyValue<List<Student>, String>(listStudent, "ITLAB");
		System.out.println("====Sample Five====");
		System.out.println("Information Students In" +keyValue5.getValue());
		for(Student student : keyValue5.getKey()) {
			System.out.println(student.toString());
		}
		
		//còn 1 loại nữa là class con của Student nữa tẹo nữa làm nốt
	}
}
