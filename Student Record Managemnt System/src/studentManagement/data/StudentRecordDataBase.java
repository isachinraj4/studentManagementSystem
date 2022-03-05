package studentManagement.data;

import java.util.Map;

import org.springframework.stereotype.Component;

import studentManagement.bean.StudentRecord;

@Component
public class StudentRecordDataBase {

	public Map<Integer, StudentRecord> hashMap;
}
