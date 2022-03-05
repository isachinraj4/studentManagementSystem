package studendManagement;

import java.util.HashMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import studentManagement.data.StudentRecordDataBase;

//@Configuration
@ComponentScan(basePackages = "studentManagement")
public class SpringConfig {

	@Bean
	public StudentRecordDataBase studentRecordDataBase() {
		StudentRecordDataBase studentRecordDataBase = new StudentRecordDataBase();
		studentRecordDataBase.hashMap = new HashMap<>();
		return studentRecordDataBase;
	}
}
