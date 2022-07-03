package br.pucrs.engswii.beans;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class EnrolledStudents {

    private HashMap<Subject, List<Student>> enrollmentRecord;
    private static EnrolledStudents enrStudents = null;

    private EnrolledStudents() {
        enrollmentRecord = new HashMap<Subject, List<Student>>();
    }

    public static EnrolledStudents getInstance(){
        if(enrStudents == null) {
			enrStudents = new EnrolledStudents();
			return enrStudents;
		}
		else {
			return enrStudents;
		}
    }

    public void addSubject(Subject sbj){
        if(!enrollmentRecord.containsKey(sbj)){
            enrollmentRecord.put(sbj, new ArrayList<Student>());
        }
    }

    public void addStudent(Subject sbj, Student std){
        List<Student> stdList = enrollmentRecord.get(sbj);
        if(stdList != null){
            stdList.add(std);
        }
    }

    public List<Student> getEnrolledStudents(Subject subject) {
        return enrollmentRecord.get(subject);
    }
}