package studentManagement.main;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import studendManagement.SpringConfig;
import studentManagement.bean.StudentRecord;
import studentManagement.utils.StudentManagementImplementation;
import studentManagement.utils.StudentManagementUtil;

public class MainClass {

	public static void main(String[] args) {

		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);

		StudentManagementUtil studentManagementUtil = applicationContext.getBean(StudentManagementImplementation.class);

		outer: while (true) {
			System.out.println("Welcome to my Student Management System");
			System.out.println("Please choose from following options");
			System.out.println("1. Add new student record \n" + "2. View all student record \n"
					+ "3. View particular student record \n" + "4. Delete student record \n"
					+ "5. Edit student record \n" + "6. Exit from system");

			Scanner scanner = new Scanner(System.in);
			String ch = scanner.next();

			int rollNo = 0;
			String studentName = null;
			long contactNo = 0;
			StudentRecord studentRecord = null;
			Optional<StudentRecord> result = null;

			switch (ch) {
			case "1":
				System.out.println("Please enter RollNo");
				rollNo = scanner.nextInt();
				System.out.println("Please enter name");
				studentName = scanner.next();
				System.out.println("Please enter contact no");
				contactNo = scanner.nextLong();
				studentRecord = applicationContext.getBean(StudentRecord.class);
				studentRecord.setRollNo(rollNo);
				studentRecord.setName(studentName);
				studentRecord.setContactNo(contactNo);
				studentManagementUtil.addStudentRecord(studentRecord);
				System.out.println("Student record added successfully");
				break;
			case "2":
				List<StudentRecord> list = studentManagementUtil.getAllStudentRecord();
				if(list!=null && list.size()>0)
					studentManagementUtil.getAllStudentRecord().forEach(student -> System.out.println(student.toString()));
				else
					System.out.println("No student record found");
				break;
			case "3":
				System.out.println("Please enter RollNo");
				rollNo = scanner.nextInt();
				result = studentManagementUtil.getStudentRecord(rollNo);
				if(result.isPresent()) {
					System.out.println(result.get().toString());
				}
				else
					System.out.println("No student record found");
					
				break;
			case "4":
				System.out.println("Please enter RollNo");
				rollNo = scanner.nextInt();
				result = studentManagementUtil.deleteStudentRecord(rollNo);
				if(result.isPresent()) {
					System.out.println("Student record deleted successfully");
				}
				else
					System.out.println("No student record found");
				break;
			case "5":
				System.out.println("Please enter new RollNo");
				rollNo = scanner.nextInt();
				System.out.println("Please enter new name");
				studentName = scanner.next();
				System.out.println("Please enter new contact no");
				contactNo = scanner.nextLong();
				studentRecord = applicationContext.getBean(StudentRecord.class);
				studentRecord.setRollNo(rollNo);
				studentRecord.setName(studentName);
				studentRecord.setContactNo(contactNo);
				result = studentManagementUtil.editStudentRecord(studentRecord);
				if(result.isPresent()) {
					System.out.println("Student record edited successfully");
				}
				else
					System.out.println("No student record found");
				break;
			case "6":
				System.out.println("Thank you for using my application");
				break outer;
			default:
				break;
			}
		}
	}
}
