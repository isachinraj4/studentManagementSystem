package studentManagement.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StudentRecord {

	private int rollNo;
	private String name;
	private long contactNo;

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContactNo() {
		return contactNo;
	}

	@Override
	public String toString() {
		return "StudentRecord [rollNo=" + rollNo + ", name=" + name + ", contactNo=" + contactNo + "]";
	}

	public void setContactNo(long contactNo) {
		this.contactNo = contactNo;
	}

	public StudentRecord(int rollNo, String name, long contactNo) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		this.contactNo = contactNo;
	}

	public StudentRecord() {

	}

}
