package studentManagement.utils;

import java.util.List;
import java.util.Optional;

import studentManagement.bean.StudentRecord;

public interface StudentManagementUtil {
	/* This will add the student record into the database */
	public void addStudentRecord(StudentRecord studentRecord);

	/* This will show all the student record form database */
	public List<StudentRecord> getAllStudentRecord();

	/* This will show the student record based of rollNo */
	public Optional<StudentRecord> getStudentRecord(int rollNo);

	/* This will delete the student record for the database based on rollNo */
	public Optional<StudentRecord> deleteStudentRecord(int rollNo);

	/* This will update the student record based on data */
	public Optional<StudentRecord> editStudentRecord(StudentRecord studentRecord);

}
