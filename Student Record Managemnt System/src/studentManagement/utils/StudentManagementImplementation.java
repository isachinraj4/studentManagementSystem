package studentManagement.utils;

import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import studentManagement.bean.StudentRecord;
import studentManagement.data.StudentRecordDataBase;

@Component
public class StudentManagementImplementation implements StudentManagementUtil {

	@Autowired
	private StudentRecordDataBase studentRecordDataBase;

	@Override
	public void addStudentRecord(StudentRecord studentRecord) {
		studentRecordDataBase.hashMap.put(studentRecord.getRollNo(), studentRecord);

	}

	@Override
	public List<StudentRecord> getAllStudentRecord() {
		return studentRecordDataBase.hashMap.entrySet().stream().map(entry -> entry.getValue())
				.collect(Collectors.toList());
	}

	@Override
	public Optional<StudentRecord> getStudentRecord(int rollNo) {
		return Optional.ofNullable(studentRecordDataBase.hashMap.get(rollNo));
	}

	@Override
	public Optional<StudentRecord> deleteStudentRecord(int rollNo) {
		StudentRecord studentRecord = studentRecordDataBase.hashMap.get(rollNo);
		studentRecordDataBase.hashMap.remove(rollNo);
		return Optional.ofNullable(studentRecord);
	}

	@Override
	public Optional<StudentRecord> editStudentRecord(StudentRecord newStudentRecord) {
		StudentRecord oldStudentRecord = studentRecordDataBase.hashMap.get(newStudentRecord.getRollNo());
		if(Objects.nonNull(oldStudentRecord)) {
			oldStudentRecord.setContactNo(newStudentRecord.getContactNo());
			oldStudentRecord.setName(newStudentRecord.getName());
			studentRecordDataBase.hashMap.replace(newStudentRecord.getRollNo(), newStudentRecord);
		}
		return Optional.ofNullable(oldStudentRecord);
	}

}
